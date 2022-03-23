import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String middleName;
    private String lastname;
    private int age;
    private String sex;
    private Person mother;
    private Person father;
    private Person partner;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;

    public Person(String name, String lastname, int age, String sex) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastname, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getPartner() {
        return partner;
    }

    public List<Person> getSiblings() {
        return this.siblings;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addParents(Person father, Person mother, Person child){
        child.setMother(mother);
        mother.addChildToChildren(mother, child);
        child.setFather(father);
        father.addChildToChildren(father, child);
    }

    public void addChildToChildren(Person parent, Person child){
        List<Person> kids = new ArrayList<>();
        if(parent.getChildren()!= null) {
            for (Person person : parent.getChildren()) {
                kids.add(person);
            }
        }
        kids.add(child);
        parent.setChildren(kids);
    }

    public void addPet(Person person, Pet pet){
        List<Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public void addSibling(Person person, Person sibling){
        List<Person> family = new ArrayList<>();
        if(person.getSiblings() != null){
            for (Person people : person.getSiblings()) {
                family.add(people);
            }
        }
        family.add(sibling);
        person.setSiblings(family);
    }

    public List<Person> getGrandChildren(Person person){
        List<Person> grandChildren = new ArrayList<>();
        if(person.getChildren() != null){
            for (Person children : person.getChildren()) {
                if(children.getChildren() != null){
                    for (Person grandKid : children.getChildren()) {
                        grandChildren.add(grandKid);
                    }
                }
            }
        }
        return grandChildren;
    }

    public List<Pet> getGrandChildrenPets(Person person){
        List<Person> grandChildren = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();
        if(person.getChildren() != null){
            for (Person children : person.getChildren()) {
                if(children.getChildren() != null){
                    for (Person grandKid : children.getChildren()) {
                        grandChildren.add(grandKid);
                    }
                }
            }
            if(grandChildren != null){
                for (Person grandChild : grandChildren) {
                    List<Pet> petsOfGrandChild = grandChild.getPets();
                    for (Pet pet : petsOfGrandChild) {
                        pets.add(pet);
                    }
                }
            }
        }
        return pets;
    }

    public List<Person> getNieces(Person person){
        List<Person> nieces = new ArrayList<>();
        List<Person> siblings = person.getSiblings();
        if(siblings != null){
            for (Person sibling : siblings) {
                List<Person> niecesAndNephews = sibling.getChildren();
                for (Person child : niecesAndNephews) {
                    if (child.getSex().equalsIgnoreCase("female")){
                        nieces.add(child);
                    }
                }
            }
        }
        return nieces;
    }

    public void addParntner(Person person, Person partner){
        if(person.getPartner() == null && partner.getPartner() == null){
            person.setPartner(partner);
            partner.setPartner(person);
        }
    }
}

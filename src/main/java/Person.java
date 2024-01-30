import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Person {



    private final String name;
    private String middleName = "";
    private final String lastname;
    private int age;
    private BiologicalGender biologicalGender;
    private Person mother;
    private Person father;
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets;

    public Person(String name, String lastname, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.biologicalGender = biologicalGender;
    }

    public Person(String name, String middleName, String lastname, int age, BiologicalGender biologicalGender) {
        this.name = name;
        this.middleName = middleName;
        this.lastname = lastname;
        this.age = age;
        this.biologicalGender = biologicalGender;
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

    public BiologicalGender getBiologicalGender() {
        return biologicalGender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return findSiblings();
    }

    private List<Person> findSiblings() {
        var siblings = new HashSet<Person>();
        if (mother != null) {
            siblings.addAll(mother.getChildren());
        }
        if (father != null) {
            siblings.addAll(father.getChildren());
        }
        siblings.remove(this); // remove this person because this person should ot be in the list of siblings
        return siblings.stream().toList();
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

    public void setBiologicalGender(BiologicalGender biologicalGender) {
        this.biologicalGender = biologicalGender;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }


    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setChildren(List<Person> children) {
        if(children == null) {
            throw new IllegalArgumentException("children cannot be null");
        }
        this.children = new ArrayList<>();
        for (Person child: children) {
            addChild(child);
        }
    }

    public void addParents(Person father, Person mother){
        setMother(mother);
        mother.addChild(this);
        setFather(father);
        father.addChild(this);
    }

    public void addChild(Person child){
       if(!getChildren().contains(child))
       {
           getChildren().add(child);
       }
       if(biologicalGender == BiologicalGender.Male ){
            child.setFather(this);
       }
       if(biologicalGender == BiologicalGender.Female ){
            child.setMother(this);
       }
    }

    public void addPet(Person person, Pet pet){
        List<Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public List<Person> getGrandChildren(){
        List<Person> grandChildren = new ArrayList<>();
            for (Person children : getChildren()) {
                grandChildren.addAll(children.getChildren());
            }
        return grandChildren;
    }
}

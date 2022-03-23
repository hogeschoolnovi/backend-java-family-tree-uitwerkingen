import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getNameTest() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");

//        Act
        String name = person1.getName();

//        Assert
        assertEquals("Piet", name);
    }

    @Test
    void getMiddleNameTest() {
        //        Arrange
        Person person1 = new Person("Piet","van der" ,"Pietersen", 34, "non-binear");

//        Act
        String name = person1.getMiddleName();

//        Assert
        assertEquals("van der", name);
    }

    @Test
    void getLastnameTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");

//        Act
        String name = person1.getLastname();

//        Assert
        assertEquals("Pietersen", name);
    }

    @Test
    void getAgeTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");

//        Act
        int age = person1.getAge();

//        Assert
        assertEquals(34, age);
    }

    @Test
    void getSexTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");

//        Act
        String sex = person1.getSex();

//        Assert
        assertEquals("non-binear", sex);
    }

    @Test
    void getMotherTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Hannah", "van der", "Plassen", 62, "female");
        person1.setMother(person2);

//        Act
        Person mother = person1.getMother();

//        Assert
        assertEquals(person2, mother);
    }

    @Test
    void getFatherTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        person1.setFather(person2);

//        Act
        Person father = person1.getFather();

//        Assert
        assertEquals(person2, father);
    }

    @Test
    void getSiblingsTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jade", "Pietersen", 22, "female");
        Person person3 = new Person("James", "Pietersen", 27, "male");
        List<Person> kids = new ArrayList<>();
        kids.add(person2);
        kids.add(person3);
        person1.setSiblings(kids);

//        Act
        List<Person> siblings = person1.getSiblings();

//        Assert
        assertEquals(kids, siblings);
    }

    @Test
    void getChildrenTest() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jade", "Pietersen", 22, "female");
        Person person3 = new Person("James", "Pietersen", 27, "male");
        Person father = new Person("Jan", "Pietersen", 64, "male");
        List<Person> kids = new ArrayList<>();
        kids.add(person2);
        kids.add(person3);
        kids.add(person1);
        father.setChildren(kids);

//        Act
        List<Person> children = father.getChildren();

//        Assert
        assertEquals(kids, children);
    }

    @Test
    void getPetsTest() {
//        Arrange
        Person person1 = new Person("Jan", "Pietersen", 64, "male");
        Pet dog = new Pet("Pluto", 5, "dogs");
        Pet cat = new Pet("Kitty", 2, "cats");
        List<Pet> pets = new ArrayList<>();
        pets.add(dog);
        pets.add(cat);
        person1.setPets(pets);

//        Act
        List<Pet> animals = person1.getPets();

//        Assert
        assertEquals(pets, animals);

    }

    @Test
    void setAgeTest() {
//        Arrange
        Person person1 = new Person("Jan", "Pietersen", 64, "male");

//        Act
        person1.setAge(65);
        int age = person1.getAge();

//        Assert
        assertEquals(65, age);

    }

    @Test
    void setSexTest() {
//        Arrange
        Person person1 = new Person("Jan", "Pietersen", 64, "male");

//        Act
        person1.setSex("female");
        String sex = person1.getSex();

//        Assert
        assertEquals("female", sex);
    }

    @Test
    void addParentsTest() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        Person person3 = new Person("Hannah", "van der", "Plassen", 62, "female");

//        Act
        person1.addParents(person2, person3, person1);
        Person mother = person1.getMother();
        Person father = person1.getFather();

//        Assert
        assertEquals(person2, father);
        assertEquals(person3, mother);

    }

    @Test
    void addChildToChildrenTest() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        List<Person> children = new ArrayList<>();
        children.add(person1);

//        Act
        person2.addChildToChildren(person2, person1);
        List<Person> kids = person2.getChildren();

//        Assert
        assertEquals(children, kids);
    }

    @Test
    void addChildToExistingChildrenTest() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jade", "Pietersen", 22, "female");
        Person person3 = new Person("James", "Pietersen", 27, "male");
        Person person4 = new Person("Jan", "Pietersen", 64, "male");
        List<Person> children = new ArrayList<>();
        children.add(person1);
        children.add(person2);
        children.add(person3);
        person4.addChildToChildren(person4,person1);
        person4.addChildToChildren(person4,person2);

//        Act
        person4.addChildToChildren(person4, person3);
        List<Person> kids = person4.getChildren();

//        Assert
        assertEquals(children, kids);
    }
    @Test
    void addPetTest() {
//        Arrange
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        Pet dog = new Pet("Luna", 3, "dogs");
        Pet cat = new Pet("Minoes", 4, "cats");
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);
        person2.addPet(person2, cat);

//        Act
        person2.addPet(person2,dog);

//        Assert
        assertEquals(pets, person2.getPets());
    }

    @Test
    void addSiblingTest() {
//        Arrange
        List<Person> sibblings = new ArrayList<>();
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binear");
        Person person2 = new Person("Jade", "Pietersen", 22, "female");
        Person person3 = new Person("Marie", "Pietersen", 22, "female");
        sibblings.add(person3);
        sibblings.add(person2);
        person1.addSibling(person1, person3);

//        Act
        person1.addSibling(person1, person2);

//        Assert
        assertEquals(sibblings, person1.getSiblings());
    }

    @Test
    void getGrandChildrenTest() {
//        Arrange
        List<Person> grandChildren = new ArrayList<>();
        Person person1 = new Person("Jay Jay", "Pietersen", 3, "female");
        Person person2 = new Person("James", "Pietersen", 22, "male");
        Person person3 = new Person("Jan", "Pietersen", 64, "male");
        grandChildren.add(person1);

//        Act
        person2.addChildToChildren(person2, person1);
        person3.addChildToChildren(person3, person2);
        List<Person> list = person3.getGrandChildren(person3);

//        Assert
        assertEquals(grandChildren, list);
    }

    @Test
    void getGrandChildrenPetsTest() {
//        Arrange
        List<Pet> pets = new ArrayList<>();
        Person person1 = new Person("Jay Jay", "Pietersen", 3, "female");
        Person person4 = new Person("Klaas", "Pietersen",12, "male");
        Person person2 = new Person("James", "Pietersen", 22, "male");
        Person person3 = new Person("Jan", "Pietersen", 64, "male");
        Pet cat1 = new Pet("Minoes", 4,"cats");
        Pet cat2 = new Pet("Garth", 3, "cats");
        Pet dog = new Pet("Bello", 6, "dogs");
        person3.addChildToChildren(person3, person2);
        person2.addChildToChildren(person2,person1);
        person2.addChildToChildren(person2, person4);
        person1.addPet(person1, cat2);
        person4.addPet(person4, cat1);
        person4.addPet(person4, dog);
        pets.add(cat2);
        pets.add(cat1);
        pets.add(dog);

//        Act
        List<Pet> animals = person3.getGrandChildrenPets(person3);

//        Assert
        assertEquals(pets, animals);

    }

    @Test
    void getNiecesTest() {
//        Arrange
        List<Person> nieces = new ArrayList<>();
        Person person1 = new Person("Jay Jay", "Pietersen", 3, "female");
        Person person4 = new Person("Marie", "Pietersen",12, "female");
        Person person2 = new Person("James", "Pietersen", 22, "male");
        Person person3 = new Person("Piet", "Pietersen", 30, "male");
        person3.addSibling(person3, person2);
        person2.addChildToChildren(person2, person1);
        person2.addChildToChildren(person2, person4);
        nieces.add(person1);
        nieces.add(person4);

//        Act
        List<Person> girls = person3.getNieces(person3);

//        Assert
        assertEquals(nieces, girls);
    }

    @Test
    void addParntnerTest() {
//        Arrange
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        Person person3 = new Person("Hannah", "van der", "Plassen", 62, "female");

//        Act
        person2.addParntner(person2, person3);

//        Assert
        assertEquals(person2.getPartner(), person3);
        assertEquals(person3.getPartner(), person2);
    }
}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getName() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");

//        Act
        String name = person1.getName();

//        Assert
        assertEquals("Piet", name);
    }

    @Test
    void getMiddleName() {
        //        Arrange
        Person person1 = new Person("Piet","van der" ,"Pietersen", 34, "non-binair");

//        Act
        String name = person1.getMiddleName();

//        Assert
        assertEquals("van der", name);
    }

    @Test
    void getLastname() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");

//        Act
        String name = person1.getLastname();

//        Assert
        assertEquals("Pietersen", name);
    }

    @Test
    void getAge() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");

//        Act
        int age = person1.getAge();

//        Assert
        assertEquals(34, age);
    }

    @Test
    void getSex() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");

//        Act
        String sex = person1.getSex();

//        Assert
        assertEquals("non-binair", sex);
    }

    @Test
    void getMother() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
        Person person2 = new Person("Hannah", "van der", "Plassen", 62, "female");
        person1.setMother(person2);

//        Act
        Person mother = person1.getMother();

//        Assert
        assertEquals(person2, mother);
    }

    @Test
    void getFather() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
        Person person2 = new Person("Jan", "Pietersen", 64, "male");
        person1.setFather(person2);

//        Act
        Person father = person1.getFather();

//        Assert
        assertEquals(person2, father);
    }

    @Test
    void getSiblings() {
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
    void getChildren() {
        //        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
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
    void getPets() {
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
    void setAge() {
//        Arrange
        Person person1 = new Person("Jan", "Pietersen", 64, "male");

//        Act
        person1.setAge(65);
        int age = person1.getAge();

//        Assert
        assertEquals(65, age);

    }

    @Test
    void setSex() {
//        Arrange
        Person person1 = new Person("Jan", "Pietersen", 64, "male");

//        Act
        person1.setSex("female");
        String sex = person1.getSex();

//        Assert
        assertEquals("female", sex);
    }

    @Test
    void addParents() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
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
    void addChildToChildren() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
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
    void addChildToExistingChildren() {
//        Arrange
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
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
    void addPet() {
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
    void addSibling() {
//        Arrange
        List<Person> sibblings = new ArrayList<>();
        Person person1 = new Person("Piet", "Pietersen", 34, "non-binair");
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
    void getGrandChildren() {
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
}

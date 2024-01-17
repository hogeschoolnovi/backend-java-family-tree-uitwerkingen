import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    String person1Name = "Piet";
    String person1LastName = "Pietersen";
    String person1MiddleName = "van der";
    Person.BiologicalGender person1Gender = Person.BiologicalGender.Male;
    int person1Age = 34;
    Person person2;
    Person person3;

    @BeforeEach
    void SetInitialState() {
        person1 = new Person(person1Name, person1MiddleName, person1LastName, person1Age, person1Gender);
        person2 = new Person("Jade", "Pietersen", 22, Person.BiologicalGender.Female);
        person3 = new Person("James", "Pietersen", 3, Person.BiologicalGender.Male);
    }

    @Test
    void getName() {
//        Arrange
//        Act
        String name = person1.getName();
//        Assert
        assertEquals(person1Name, name);
    }

    @Test
    void getMiddleName() {
        //        Arrange
//        Act
        String name = person1.getMiddleName();

//        Assert
        assertEquals(person1MiddleName, name);
    }

    @Test
    void getLastname() {
        //        Arrange

        //        Act
        String name = person1.getLastname();

        //        Assert
        assertEquals(person1LastName, name);
    }

    @Test
    void getAge() {
        //        Arrange

//        Act
        int age = person1.getAge();

//        Assert
        assertEquals(person1Age, age);
    }

    @Test
    void getGender() {
        //        Arrange

//        Act
        Person.BiologicalGender gender = person1.getBiologicalGender();

//        Assert
        assertEquals(person1Gender, gender);
    }

    @Test
    void getMother() {
        //        Arrange
        Person motherPerson = new Person("Jannie", "Pietersen", 64, Person.BiologicalGender.Female);
        person1.setMother(motherPerson);

//        Act
        Person mother = person1.getMother();

//        Assert
        assertEquals(motherPerson, mother);
    }

    @Test
    void getFather() {
        //        Arrange
        Person fatherPerson = new Person("Jan", "Pietersen", 64, Person.BiologicalGender.Male);
        person1.setFather(fatherPerson);
//        Act
        Person father = person1.getFather();

//        Assert
        assertEquals(fatherPerson, father);
    }

    @Test
    void getSiblings() {
        //        Arrange

        List<Person> kids = new ArrayList<>();
        kids.add(person2);
        kids.add(person3);
        person1.setChildren(kids);
//        Act
        List<Person> siblings = person2.getSiblings();

//        Assert
        assertTrue(siblings.contains(person3));
    }

    @Test
    void getChildren() {
        //        Arrange
        Person child1 = new Person("Piet", "Pietersen", 34, Person.BiologicalGender.Male);
        Person child2 = new Person("Jade", "Pietersen", 22, Person.BiologicalGender.Female);
        Person child3 = new Person("James", "Pietersen", 27, Person.BiologicalGender.Male);

        List<Person> kids = new ArrayList<>();
        kids.add(child1);
        kids.add(child2);
        kids.add(child3);
        person1.setChildren(kids);

//        Act
        List<Person> children = person1.getChildren();

//        Assert
        assertEquals(kids, children);
    }

    @Test
    void getPets() {
//        Arrange
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
//        Act
        person1.setAge(65);
        int age = person1.getAge();
//        Assert
        assertEquals(65, age);

    }

    @Test
    void setGender() {
//        Arrange

//        Act
        person1.setBiologicalGender(Person.BiologicalGender.Female);
        Person.BiologicalGender gender = person1.getBiologicalGender();

//        Assert
        assertEquals(Person.BiologicalGender.Female, gender);
    }

    @Test
    void addParents() {
//        Arrange

//        Act
        person3.addParents(person1, person2);
        Person mother = person3.getMother();
        Person father = person3.getFather();

//        Assert
        assertEquals(person1, father);
        assertEquals(person2, mother);

    }

    @Test
    void addChildToChildren() {
//        Arrange
        Person grandChild = new Person("Jamie",person1LastName, 1, Person.BiologicalGender.Male);
//        Act
        person1.addChild(person2);
        person2.addChild(grandChild);

//        Assert
        assertTrue(person1.getGrandChildren().contains(grandChild));
    }

    @Test
    void addPet() {
//        Arrange
        Pet dog = new Pet("Luna", 3, "dogs");
        Pet cat = new Pet("Minoes", 4, "cats");
        List<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);
        person2.addPet(person2, cat);

//        Act
        person2.addPet(person2, dog);

//        Assert
        assertEquals(pets, person2.getPets());
    }
}

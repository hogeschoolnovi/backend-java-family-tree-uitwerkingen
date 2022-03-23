import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTest {

//    Pet cat = new Pet("Garth", 2, "cats");

    @Test
    public void getNameTest(){
//        Arrange
        Pet cat = new Pet("Minoes", 3, "cat");

//        Act
        String name = cat.getName();

//        Assert
        assertEquals("Minoes", name);
    }

    @Test
    public void getAgeTest(){
//        Arrange
        Pet cat = new Pet("Minoes", 3, "cat");

//        Act
        int age = cat.getAge();

//        Assert
        assertEquals(3, age);
    }

    @Test
    public void getSpiecesTest(){
//        Arrange
        Pet cat = new Pet("Minoes", 3, "cat");

//        Act
        String species = cat.getSpecies();

//        Assert
        assertEquals("cat", species);
    }

    @Test
    public void getOwnerTest(){
//        Arrange
        Pet cat = new Pet("Minoes", 3, "cat");

//        Act
        Person owner = cat.getOwner();

//        Assert
        assertEquals(null, owner);
    }
    @Test
    public void setOwnerTest(){
//        Arrange
        Person mike = new Person("Mike", "van", "Dalen", 23, "male");
        Pet cat = new Pet("Minoes", 3, "cat");

//        Act
        cat.setOwner(mike);
        String owner = cat.getOwner().getName();

//        Assert
        assertEquals("Mike", owner);
    }
}
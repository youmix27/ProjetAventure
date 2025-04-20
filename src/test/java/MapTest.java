import fr.mfraisse.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    protected Map map;

    @BeforeEach
    void setUp() {
        map = new Map();
    }

    @Test
    @DisplayName("map Constructor Test")
    void testMapConstructor() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Map("fichierNonExistant.txt"));
        assertEquals("File was not found.", exception.getMessage(),
                "map constructor should have thrown an exception.");
    }

    @Test
    @DisplayName("getRow Test")
    void testGetRow() {
        assertEquals(20, map.getRow(),
                "getRow should return the number of row (20)");
    }

    @Test
    @DisplayName("getCol Test")
    void testGetCol() {
        assertEquals(20, map.getRow(),
                "getCol should return the number of col (20)");
    }

    @Test
    @DisplayName("isMovable test")
    void testIsMovable() {
        assertTrue(map.isMovable(4, 0),
                "isMovable should return True for the coordinate (4,0)");
        assertFalse(map.isMovable(19, 19),
                "isMovable should return False for the coordinate (19,19)");
        assertTrue(map.isMovable(6, 7),
                "isMovable should return True for the coordinate (5,6)");
        assertTrue(map.isMovable(3, 0),
                "isMovable should return True for the coordinate (3,0)");
        assertFalse(map.isMovable(3, 20),
                "isMovable should return False for the coordinate (3,27)");
    }

    @Test
    @DisplayName("getCharacterCoordinates Test")
    void testGetCharacterCoordinates() {
        assertEquals(new Point(7, 8), map.getCharacterCoordinates("7,8"),
                "getCharacterCoordinates should return the coordinate (7,8)");
        assertEquals(new Point(17, 8), map.getCharacterCoordinates("17,8G"),
                "getCharacterCoordinates should return the coordinate (17,8)");
        assertEquals(new Point(7, 18), map.getCharacterCoordinates("7,18"),
                "getCharacterCoordinates should return the coordinate (7,18)");
        assertEquals(new Point(17, 18), map.getCharacterCoordinates("17,18"),
                "getCharacterCoordinates should return the coordinate (17,18)");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> map.getCharacterCoordinates("7,"));
        assertEquals("Coordinates line must be at least 3 characters", exception.getMessage(),
                "getCharacterCoordinates should return \"Coordinates line must be at least 3 characters\"");
        exception = assertThrows(IllegalArgumentException.class, () -> map.getCharacterCoordinates("17,"));
        assertEquals("Coordinates line does not contain y coordinates", exception.getMessage(),
                "getCharacterCoordinates should return \"Coordinates line does not contain y coordinates\"");
    }

    @Test
    @DisplayName("moveCharacter Test")
    void testMoveCharacter() {
        assertEquals(new Point(1, 9), map.moveCharacter("src/main/resources/instructions/file1.txt"),
                "moveCharacter should return the coordinate (1,9) with file1.txt");
        assertEquals(new Point(9, 2), map.moveCharacter("src/main/resources/instructions/file2.txt"),
                "moveCharacter should return the coordinate (9,2) with file2.txt");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> map.moveCharacter("src/main/resources/instructions/file3.txt"));
        assertEquals("File was not found.", exception.getMessage(),
                "moveCharacter should have thrown an FileNotFoundException.");
        exception = assertThrows(IllegalArgumentException.class, () -> map.moveCharacter("src/main/resources/instructions/file4.txt"));
        assertEquals("Wrong origin position.", exception.getMessage(),
                "moveCharacter should have thrown a Wrong origin position Exception.");
        exception = assertThrows(IllegalArgumentException.class, () -> map.moveCharacter("src/main/resources/instructions/file5.txt"));
        assertEquals("File wasn't as expected.", exception.getMessage(),
                "moveCharacter should have thrown a File wasn't as expected Exception.");

    }
}

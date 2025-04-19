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
    @DisplayName("moveCharacter Test")
    void testMoveCharacter() {
        assertEquals(new Point(1, 9), map.moveCharacter("file1.txt"),
                "moveCharacter should return the coordinate (1,9) with file1.txt");
        assertEquals(new Point(9, 2), map.moveCharacter("file2.txt"),
                "moveCharacter should return the coordinate (9,2) with file2.txt");

    }
}

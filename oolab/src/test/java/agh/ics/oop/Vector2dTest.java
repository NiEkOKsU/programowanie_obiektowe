package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d vector = new Vector2d(2, 5);
        assertEquals(vector.toString(), "(2,5)");
    }

    @Test
    void precedes() {
        Vector2d vector = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(1, 4);
        assertFalse(vector.precedes(vector2));
        assertTrue(vector2.precedes(vector));
        assertTrue(vector.precedes(vector));
    }

    @Test
    void follows() {
        Vector2d vector = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(1, 4);
        assertTrue(vector.follows(vector2));
        assertFalse(vector2.follows(vector));
        assertTrue(vector.follows(vector));
    }

    @Test
    void add() {
        Vector2d vector = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(1, 4);
        assertEquals(vector.add(vector2), new Vector2d(3, 9));
    }

    @Test
    void substract() {
        Vector2d vector = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(1, 4);
        assertEquals(vector.substract(vector2), new Vector2d(1, 1));
    }

    @Test
    void upperRight() {
        Vector2d vector = new Vector2d(2, 4);
        Vector2d vector2 = new Vector2d(1, 5);
        assertEquals(vector.upperRight(vector2), new Vector2d(2, 5));
    }

    @Test
    void lowerLeft() {
        Vector2d vector = new Vector2d(2, 4);
        Vector2d vector2 = new Vector2d(1, 5);
        assertEquals(vector.lowerLeft(vector2), new Vector2d(1, 4));
    }

    @Test
    void opposite() {
        Vector2d vector = new Vector2d(2, 5);
        assertEquals(vector.opposite(), new Vector2d(-2, -5));
    }

    @Test
    void testEquals() {
        Vector2d vector = new Vector2d(2, 5);
        Vector2d vector2 = new Vector2d(1, 5);
        Vector2d vector3 = new Vector2d(2, 5);
        Vector2d vector4 = new Vector2d(2, -5);
        assertTrue(vector.equals(vector3));
        assertFalse(vector.equals(vector2));
        assertFalse(vector.equals(vector4));
    }
}
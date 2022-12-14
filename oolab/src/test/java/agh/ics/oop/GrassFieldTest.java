package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    private final IWorldMap map = new GrassField(10);
    @Test
    void canMoveTo(){
        this.map.place(new Animal(this.map,new Vector2d(2,2)));
        Assertions.assertFalse(this.map.canMoveTo(new Vector2d(2,2)));
        Assertions.assertTrue(this.map.canMoveTo(new Vector2d(0,1)));
        Assertions.assertTrue(this.map.canMoveTo(new Vector2d(-1,2)));
    }
    @Test
    void place(){
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(3,3))));
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(2,6))));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            this.map.place(new Animal(this.map,new Vector2d(3,3)));
        });
        Assertions.assertEquals("You cannot place another animal on (3,3)", exception.getMessage());
    }
    @Test
    void isOccupied(){
        this.map.place(new Animal(this.map,new Vector2d(2,3)));
        this.map.place(new Animal(this.map,new Vector2d(7,3)));
        Assertions.assertTrue(this.map.isOccupied(new Vector2d(2,3)));
        Assertions.assertTrue(this.map.isOccupied(new Vector2d(7,3)));
        Assertions.assertFalse(this.map.isOccupied(new Vector2d(-1,3)));
    }
    @Test
    void objectAt(){
        Animal animal1 = new Animal(this.map,new Vector2d(2,3));
        Animal animal2 = new Animal(this.map,new Vector2d(4,5));
        this.map.place(animal1);
        this.map.place(animal2);
        Assertions.assertEquals(animal1,this.map.objectAt(new Vector2d(2,3)));
        Assertions.assertEquals(animal2,this.map.objectAt(new Vector2d(4,5)));
    }

}
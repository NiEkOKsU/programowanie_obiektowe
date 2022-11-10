package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void tests(){
        Animal animal1 = new Animal(new RectangularMap(4,4), new Vector2d(2, 2));
        Animal animal2 = new Animal(new RectangularMap(4,4), new Vector2d(2, 2));
        Animal animal3 = new Animal(new RectangularMap(4,4), new Vector2d(2, 2));
        Animal animal4 = new Animal(new RectangularMap(4,4), new Vector2d(2, 2));
        Animal animal5 = new Animal(new RectangularMap(4,4), new Vector2d(2, 2));


        animal1.move(MoveDirection.LEFT);

        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.RIGHT);

        animal3.move(MoveDirection.RIGHT);
        animal3.move(MoveDirection.BACKWARD);
        animal3.move(MoveDirection.BACKWARD);
        animal3.move(MoveDirection.BACKWARD);
        animal3.move(MoveDirection.RIGHT);
        animal3.move(MoveDirection.LEFT);

        animal4.move(MoveDirection.LEFT);
        animal4.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.LEFT);
        animal4.move(MoveDirection.FORWARD);
        animal4.move(MoveDirection.FORWARD);

        String[] moves = new String[] {"f", "f", "r", "r", "f", "f", "f", "f", "r", "r"};
        MoveDirection[] options = OptionsParser.parse(moves);
        for (MoveDirection option: options){
            animal5.move(option);
        }


        assertEquals(MapDirection.WEST, animal1.getDirection());
        assertEquals(new Vector2d(2, 2), animal1.getPosition());
        assertEquals(MapDirection.NORTH, animal2.getDirection());
        assertEquals(new Vector2d(2, 3), animal2.getPosition());
        assertEquals(MapDirection.EAST, animal3.getDirection());
        assertEquals(new Vector2d(0, 2), animal3.getPosition());
        assertEquals(MapDirection.SOUTH, animal4.getDirection());
        assertEquals(new Vector2d(0, 0), animal4.getPosition());
        assertEquals(MapDirection.NORTH, animal5.getDirection());
        assertEquals(new Vector2d(2, 0), animal5.getPosition());
    }

}
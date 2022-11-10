package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    @Test
    public void movingAnimals(){
        String[] args= {"r", "l", "f", "b", "f", "f", "b", "l"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }

    @Test
    public void respAnimalsOnOccupiedPlaces(){
        String[] args= {"r", "l", "f", "b", "f", "f", "b", "l"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3), new Vector2d(3,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        //Sprawdzam pozycje w których byłyby zwierzaki jeżeli udało by nam się je stworzyć na tym samym polu
        assertFalse(map.isOccupied(new Vector2d(0, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 3)));
        assertFalse(map.isOccupied(new Vector2d(3, 5)));
    }


    @Test
    public void animalsCollision(){
        String[] args= {"f", "b", "r", "l", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //Jeżeli była by możliwośc zderzenia się zwieżaków na mapie to na tej pozycji by nie było zwierzaka
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }


    @Test
    void steppingOutOfMapTest() {
        String[] args= {"b", "b", "b", "b", "r", "f", "f", "b", "b", "b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(3, 3);
        Vector2d[] positions = { new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 0)));
    }

}
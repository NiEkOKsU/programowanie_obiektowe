package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final List<Animal> animals= new ArrayList<>();
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialAnimalsPositions){
        this.directions=directions;
        for (Vector2d currPosition: initialAnimalsPositions){
            Animal animal=new Animal(map, currPosition);
            animals.add(animal);
        }
    }
    @Override
    public void run() {
        int numbersOfAnimals=animals.size();
        for (int i=0;i<directions.length;i++){
            animals.get(i%numbersOfAnimals).move(directions[i]);
        }
    }
}

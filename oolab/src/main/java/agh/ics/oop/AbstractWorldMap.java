package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap() {
        animals = new HashMap<>();
        mapVisualizer = new MapVisualizer(this);
    }
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    protected abstract Vector2d calcLowerBound();
    protected abstract Vector2d calcUpperBound();

    @Override
    public String toString() {
        return mapVisualizer.draw(calcLowerBound(), calcUpperBound());
    }
    public abstract Object objectAt(Vector2d position);

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
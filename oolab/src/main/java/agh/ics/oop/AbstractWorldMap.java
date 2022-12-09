package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, Animal> animals;
    protected final MapVisualizer mapVisualizer;
    protected MapBoundary mapBoundary = new MapBoundary();

    protected AbstractWorldMap() {
        animals = new HashMap<>();
        mapVisualizer = new MapVisualizer(this);
    }

    public boolean isOccupied(Vector2d position) {
        return (animals.containsKey(position));
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            mapBoundary.updateMapBoundary(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException("You cannot place another animal on " + animal.getPosition());
    }

    public abstract Vector2d calcLowerBound();

    public abstract Vector2d calcUpperBound();

    @Override
    public String toString() {
        return mapVisualizer.draw(this.calcLowerBound(), this.calcUpperBound());
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        mapBoundary.positionChanged(oldPosition,newPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
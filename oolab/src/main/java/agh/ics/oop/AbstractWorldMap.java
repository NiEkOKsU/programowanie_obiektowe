package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final List<Animal> animals;
    protected Vector2d mapLowerLeft;
    protected Vector2d mapUpperRight;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap(Vector2d leftBottom, Vector2d rightTop) {
        mapUpperRight = rightTop;
        mapLowerLeft = leftBottom;
        animals = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);
    }
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(this.mapLowerLeft, this.mapUpperRight);
    }
    public abstract Object objectAt(Vector2d position);
}
package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap implements IWorldMap {
    private final Vector2d mapLowerLeft;
    private final Vector2d mapUpperRight;
    private final List<Animal> animals;
    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height, int leftX, int leftY) {
        this.mapUpperRight = new Vector2d(width, height);
        this.mapLowerLeft = new Vector2d(leftX, leftY);
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    public RectangularMap(int mapWidth, int mapHeight) {
        this(mapWidth, mapHeight, 0, 0);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(mapLowerLeft, mapUpperRight);
    }


    public boolean canMoveTo(Vector2d position) {
        return position.follows(mapLowerLeft) && position.precedes(mapUpperRight) && !isOccupied(position);
    }


    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }


    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }


    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return animal;
            }
        }
        return null;
    }
}

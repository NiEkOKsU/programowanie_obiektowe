package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrassField implements IWorldMap{
    private int grassAmount;
    private List<Vector2d> grassList;
    private Vector2d mapLowerLeft;
    private Vector2d mapUpperRight;
    private final List<Animal> animals;
    private final MapVisualizer mapVisualizer;
    public GrassField(int grassAmount, int width, int height, int leftX, int leftY) {
        this.grassAmount = grassAmount;
        this.grassList = new ArrayList<>();
        placeGrass();
        this.mapUpperRight = new Vector2d(width, height);
        this.mapLowerLeft = new Vector2d(leftX, leftY);
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    public GrassField(int grassAmount) {
        this(grassAmount, (int) Math.sqrt(10*grassAmount), (int) Math.sqrt(10*grassAmount), 0, 0);
    }

    private int genRandomInt(double max){
        return (int)Math.floor(Math.random()*(max +1));
    }

    public void placeGrass(){
        Vector2d grass = new Vector2d(genRandomInt(Math.sqrt(10*grassAmount)), genRandomInt(Math.sqrt(10*grassAmount)));
        for(int i=0;i<grassAmount;++i){
            while(!placeGrassOnCoordinates(grass)){
                grass=new Vector2d(genRandomInt(Math.sqrt(10*grassAmount)), genRandomInt(Math.sqrt(10*grassAmount)));
            }
        }
    }

    public boolean placeGrassOnCoordinates(Vector2d grassPosition){
        if(!isOccupiedByGrass(grassPosition)){
            grassList.add(grassPosition);
            return true;
        }
        return false;
    }

    private boolean isOccupiedByGrass(Vector2d grassPosition){
        return this.grassList.stream().anyMatch(el -> el.equals(grassPosition));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)){
            this.mapLowerLeft = position.lowerLeft(this.mapLowerLeft);
            this.mapUpperRight = position.upperRight(this.mapUpperRight);
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
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

    @Override
    public String toString() {
        return mapVisualizer.draw(mapLowerLeft, mapUpperRight);
    }
}

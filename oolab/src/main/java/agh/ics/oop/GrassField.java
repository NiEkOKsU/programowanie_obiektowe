package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grassList = new HashMap<>();

    public GrassField(int grassAmmount) {
        placeGrass(grassAmmount);
    }

    private int genRandomInt(double max){
        return (int)Math.floor(Math.random()*(max +1));
    }

    public void placeGrass(int grassAmmount){
        Vector2d grass = new Vector2d(genRandomInt(Math.sqrt(10*grassAmmount)), genRandomInt(Math.sqrt(10*grassAmmount)));
        for(int i=0;i<grassAmmount;++i){
            while(!placeGrassOnCoordinates(grass)){
                grass=new Vector2d(genRandomInt(Math.sqrt(10*grassAmmount)), genRandomInt(Math.sqrt(10*grassAmmount)));
            }
        }
    }

    public boolean placeGrassOnCoordinates(Vector2d grassPosition){
        if(!isOccupiedByGrass(grassPosition)){
            grassList.put(grassPosition, new Grass(grassPosition));
            return true;
        }
        return false;
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        return grassList.containsKey(position);
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    public Object objectAt(Vector2d position) {
        if(isOccupiedByGrass(position)){
            return grassList.get(position);
        }
        return animals.get(position);
    }

    @Override
    public Vector2d calcLowerBound() {
        return this.mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d calcUpperBound() {
        return this.mapBoundary.getUpperRight();
    }


}

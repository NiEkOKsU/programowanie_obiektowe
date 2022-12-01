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

    private boolean placeGrassOnCoordinates(Vector2d grassPosition){
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
        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Vector2d position : grassList.keySet()) {
            lowerBound = lowerBound.lowerLeft(position);
        }
        for(Vector2d position : animals.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }
        return lowerBound;
    }

    @Override
    public Vector2d calcUpperBound() {
        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d position : grassList.keySet()) {
            upperBound = upperBound.upperRight(position);
        }
        for(Vector2d position : animals.keySet()){
            upperBound = upperBound.upperRight(position);
        }
        return upperBound;
    }


}

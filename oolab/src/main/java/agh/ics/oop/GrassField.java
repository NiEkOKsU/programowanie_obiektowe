package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrassField extends AbstractWorldMap{
    private List<Vector2d> grassList = new ArrayList<>();

    public GrassField(int grassAmmount) {
        super(new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE),new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE));
        placeGrass(grassAmmount);
        updateMapSize();
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
            grassList.add(grassPosition);
            return true;
        }
        return false;
    }

    public boolean isOccupiedByGrass(Vector2d position) {

        return grassList.stream().anyMatch(el -> el.equals(position));
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.stream().anyMatch(el -> el.getPosition().equals(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return animal;
            }
        }
        for (Vector2d grass : grassList) {
            if (Objects.equals(grass, position)) {
                return grass;
            }
        }
        return null;
    }
    private void updateMapSize(){
        for (Vector2d position : grassList) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
            mapUpperRight = mapUpperRight.upperRight(position);
        }
        for (Animal animal : animals) {
            mapLowerLeft = mapLowerLeft.lowerLeft(animal.getPosition());
            mapUpperRight = mapUpperRight.upperRight(animal.getPosition());
        }
    }

}

package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrassField extends AbstractWorldMap{
    private List<Grass> grassList = new ArrayList<>();

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

    private boolean placeGrassOnCoordinates(Vector2d grassPosition){
        if(!isOccupiedByGrass(grassPosition)){
            grassList.add(new Grass(grassPosition));
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
        updateMapSize();
        return !isOccupiedByAnimal(position);
    }

    public Object objectAt(Vector2d position) {
        updateMapSize();
        for (Animal animal : animals) {
            if (Objects.equals(animal.getPosition(), position)) {
                return animal;
            }
        }
        for (Grass grass : grassList) {
            if (Objects.equals(grass.getPosition(), position)) {
                return grass;
            }
        }
        return null;
    }

    private void updateMapSize(){
        for (Grass grass : grassList) {
            mapLowerLeft = mapUpperRight.lowerLeft(grass.getPosition());
            mapUpperRight = mapLowerLeft.upperRight(grass.getPosition());
        }
        for (Animal animal : animals) {
            mapLowerLeft = mapUpperRight.lowerLeft(animal.getPosition());
            mapUpperRight = mapLowerLeft.upperRight(animal.getPosition());
        }
    }

}

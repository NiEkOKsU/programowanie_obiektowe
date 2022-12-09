package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements IMapElement {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d position) {
        this.direction = MapDirection.NORTH;
        this.position = position;
        this.map = map;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }


    @Override
    public String toString() {
        return Character.toString(direction.name().charAt(0));
    }
    public String getImagePath(){
        return toString();
    }
    public String getDesc(){
        return "Z " + position.toString();
    }
    public boolean isAt(Vector2d checkPosition){
        return Objects.equals(position, checkPosition);
    }


    public void move(MoveDirection direction){
        Vector2d newVector = position;
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> newVector = position.add(this.direction.toUnitVector());
            case BACKWARD -> newVector = position.substract(this.direction.toUnitVector());
            default -> {}
        }
        if(map.canMoveTo(newVector)){
            positionChanged(position, newVector);
            position = newVector;
        }
    }
    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}

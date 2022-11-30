package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    public Animal(){
        this(new RectangularMap(4,4));
    }

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
            position = newVector;
            map.place(this);
        }
    }

}

package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal(IWorldMap map){

    }


    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "direction = " + direction +
                ", position = " + position;
    }


    public boolean isAt(Vector2d checkPosition){
        return Objects.equals(position, checkPosition);
    }


    public void move(MoveDirection direction){
        Vector2d upright = new Vector2d(4, 4);
        Vector2d downleft = new Vector2d(0, 0);
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> this.position = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> this.position = this.position.substract(this.direction.toUnitVector());
        }
        this.position = this.position.upperRight(downleft);
        this.position = this.position.lowerLeft(upright);
    }

}

package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;


    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString(){
        return "(%d,%d)".formatted(this.x, this.y);
    }


    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }


    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }


    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }


    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }


    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }


    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Vector2d vector2dOther) {
            return (x == vector2dOther.x && y == vector2dOther.y);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }

}

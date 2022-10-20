package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

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


    public boolean isAt(Vector2d position){
        return this.position.x == position.x && this.position.y == position.y;
    }


    public void move(MoveDirection direction){
        Vector2d newVector = null;
        Vector2d upright = new Vector2d(4, 4);
        Vector2d downleft = new Vector2d(0, 0);
        if (direction == MoveDirection.FORWARD) {
            switch (this.direction) {
                case NORTH -> {
                    newVector = new Vector2d(this.position.x + MapDirection.NORTH.toUnitVector()[0], this.position.y + MapDirection.NORTH.toUnitVector()[1]);
                }
                case SOUTH -> {
                    newVector = new Vector2d(this.position.x + MapDirection.SOUTH.toUnitVector()[0], this.position.y + MapDirection.SOUTH.toUnitVector()[1]);
                }
                case WEST -> {
                    newVector = new Vector2d(this.position.x + MapDirection.WEST.toUnitVector()[0], this.position.y + MapDirection.WEST.toUnitVector()[1]);
                }
                case EAST -> {
                    newVector = new Vector2d(this.position.x + MapDirection.EAST.toUnitVector()[0], this.position.y + MapDirection.EAST.toUnitVector()[1]);
                }
            }
        }
        else if (direction == MoveDirection.BACKWARD){
            switch (this.direction) {
                case NORTH -> {
                    newVector = new Vector2d(this.position.x + MapDirection.SOUTH.toUnitVector()[0], this.position.y + MapDirection.SOUTH.toUnitVector()[1]);
                }
                case SOUTH -> {
                    newVector = new Vector2d(this.position.x + MapDirection.NORTH.toUnitVector()[0], this.position.y + MapDirection.NORTH.toUnitVector()[1]);
                }
                case WEST -> {
                    newVector = new Vector2d(this.position.x + MapDirection.EAST.toUnitVector()[0], this.position.y + MapDirection.EAST.toUnitVector()[1]);
                }
                case EAST -> {
                    newVector = new Vector2d(this.position.x + MapDirection.WEST.toUnitVector()[0], this.position.y + MapDirection.WEST.toUnitVector()[1]);
                }
            }
        }
        else if (direction == MoveDirection.LEFT || direction == MoveDirection.RIGHT){
            newVector = new Vector2d(this.position.x, this.position.y);
        }
        switch (this.direction){
            case NORTH, EAST -> checkBound(direction, newVector, newVector.precedes(upright), newVector.follows(downleft));
            case SOUTH, WEST -> checkBound(direction, newVector, newVector.follows(downleft), newVector.precedes(upright));
        }
    }


    public void checkBound(MoveDirection direction, Vector2d newVector, boolean precedes, boolean follows) {
        if (direction == MoveDirection.FORWARD && precedes){
            setPosition(new Vector2d(newVector.x, newVector.y));
        }
        else if (direction == MoveDirection.BACKWARD && follows) {
            setPosition(new Vector2d(newVector.x, newVector.y));
        }
        else if (direction.equals(MoveDirection.RIGHT)) {
            setDirection(this.direction.next());
        }
        else if (direction.equals(MoveDirection.LEFT)){
            setDirection(this.direction.previous());
        }
    }
}

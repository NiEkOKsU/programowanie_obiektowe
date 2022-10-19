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
        if (this.direction.equals(MapDirection.NORTH)){
            if (direction == MoveDirection.FORWARD && this.position.y < 4){
                setPosition(new Vector2d(this.position.x, this.position.y + 1));
            }
            else if (direction == MoveDirection.BACKWARD && this.position.y > 0) {
                setPosition(new Vector2d(this.position.x, this.position.y - 1));
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                setDirection(MapDirection.EAST);
            }
            else if (direction.equals(MoveDirection.LEFT)){
                setDirection(MapDirection.WEST);
            }
        }
        else if (this.direction.equals(MapDirection.SOUTH)){
            if (direction == MoveDirection.FORWARD && this.position.y > 0){
                setPosition(new Vector2d(this.position.x, this.position.y - 1));
            }
            else if (direction == MoveDirection.BACKWARD && this.position.y < 4) {
                setPosition(new Vector2d(this.position.x, this.position.y + 1));
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                setDirection(MapDirection.WEST);
            }
            else if (direction.equals(MoveDirection.LEFT)){
                setDirection(MapDirection.EAST);
            }
        }
        else if (this.direction.equals(MapDirection.WEST)) {
            if (direction == MoveDirection.FORWARD && this.position.x > 0){
                setPosition(new Vector2d(this.position.x - 1, this.position.y));
            }
            else if (direction == MoveDirection.BACKWARD && this.position.x < 4) {
                setPosition(new Vector2d(this.position.x + 1, this.position.y));
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                setDirection(MapDirection.NORTH);
            }
            else if (direction.equals(MoveDirection.LEFT)){
                setDirection(MapDirection.SOUTH);
            }
        }
        else if (this.direction.equals(MapDirection.EAST)) {
            if (direction == MoveDirection.FORWARD && this.position.x < 4){
                setPosition(new Vector2d(this.position.x + 1, this.position.y));
            }
            else if (direction == MoveDirection.BACKWARD && this.position.x > 0) {
                setPosition(new Vector2d(this.position.x - 1, this.position.y));
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                setDirection(MapDirection.SOUTH);
            }
            else if (direction.equals(MoveDirection.LEFT)){
                setDirection(MapDirection.NORTH);
            }
        }
    }
}

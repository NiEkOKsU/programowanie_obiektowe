package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);


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
            if (direction == MoveDirection.FORWARD && this.position.x < 4){
                this.position = new Vector2d(this.position.x + 1, this.position.y);
            }
            else if (direction == MoveDirection.BACKWARD && this.position.x > 0) {
                this.position = new Vector2d(this.position.x - 1, this.position.y);
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                this.direction = MapDirection.valueOf(this.direction.next());
            }
            else{
                this.direction = MapDirection.valueOf(this.direction.previous());
            }
        }
        else if (this.direction.equals(MapDirection.SOUTH)){
            if (direction == MoveDirection.FORWARD && this.position.x > 0){
                this.position = new Vector2d(this.position.x - 1, this.position.y);
            }
            else if (direction == MoveDirection.BACKWARD && this.position.x < 4) {
                this.position = new Vector2d(this.position.x + 1, this.position.y);
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                this.direction = MapDirection.valueOf(this.direction.next());
            }
            else{
                this.direction = MapDirection.valueOf(this.direction.previous());
            }
        }
        else if (this.direction.equals(MapDirection.WEST)) {
            if (direction == MoveDirection.FORWARD && this.position.y > 0){
                this.position = new Vector2d(this.position.x, this.position.y - 1);
            }
            else if (direction == MoveDirection.BACKWARD && this.position.y < 4) {
                this.position = new Vector2d(this.position.x, this.position.y + 1);
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                this.direction = MapDirection.valueOf(this.direction.next());
            }
            else{
                this.direction = MapDirection.valueOf(this.direction.previous());
            }
        }
        else {
            if (direction == MoveDirection.FORWARD && this.position.y < 4){
                this.position = new Vector2d(this.position.x, this.position.y + 1);
            }
            else if (direction == MoveDirection.BACKWARD && this.position.y > 0) {
                this.position = new Vector2d(this.position.x, this.position.y - 1);
            }
            else if (direction.equals(MoveDirection.RIGHT)) {
                this.direction = MapDirection.valueOf(this.direction.next());
            }
            else{
                this.direction = MapDirection.valueOf(this.direction.previous());
            }
        }
    }
}

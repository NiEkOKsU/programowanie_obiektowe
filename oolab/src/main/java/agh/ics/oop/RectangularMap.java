package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d lowerLeft;

    private final Vector2d upperRight;

    public RectangularMap(int width, int height, int leftX, int leftY) {
        super();
        lowerLeft = new Vector2d(leftX,leftY);
        upperRight = new Vector2d(width,height);
    }

    public RectangularMap(int mapWidth, int mapHeight) {
        this(mapWidth, mapHeight, 0, 0);
    }


    public boolean canMoveTo(Vector2d position) {
        return (lowerLeft.equals(lowerLeft.lowerLeft(position))
                && upperRight.equals(upperRight.upperRight(position))
                && !animals.containsKey(position));
    }

    public Vector2d calcLowerBound(){
        return this.lowerLeft;
    }

    public Vector2d calcUpperBound(){
        return this.upperRight;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (lowerLeft.equals(lowerLeft.lowerLeft(position))
                && upperRight.equals(upperRight.upperRight(position))
                && super.isOccupied(position));
    }

    public IMapElement objectAt(Vector2d position) {
        return animals.get(position);
    }

}

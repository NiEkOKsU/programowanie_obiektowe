package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int amountOfGrass) {
        placeInitGrass(amountOfGrass);
    }

    private void placeInitGrass(int amount) {
        ArrayList<Vector2d> grassPositions = new ArrayList<>();
        int bound = (int) Math.sqrt(10 * amount);
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                grassPositions.add(new Vector2d(i, j));
                mapBoundary.updateMapBoundary(new Vector2d(i, j));
            }
        }

        Random random = new Random();
        for (int i = 0; i < amount; ++i) {
            int randomIndex = random.nextInt(grassPositions.size());
            Vector2d grassPosition = grassPositions.get(randomIndex);
            grassMap.put(grassPosition, new Grass(grassPosition));
            mapBoundary.updateMapBoundary(grassPosition);
            grassPositions.remove(grassPosition);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (isOccupiedByGrass(position) || super.isOccupied(position));
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        return (grassMap.containsKey(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        if (super.objectAt(position) == null) {
            return grassMap.get(position);
        }
        return super.objectAt(position);
    }

    public Vector2d calcLowerBound() {
        return this.mapBoundary.getLowerLeft();
    }

    public Vector2d calcUpperBound() {
        return this.mapBoundary.getUpperRight();
    }

    public void eatGrass(Vector2d position) {
        grassMap.remove(position);
        placeInitGrass(1);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition,newPosition);
        if(isOccupiedByGrass(newPosition)){
            eatGrass(newPosition);
        }
    }

    @Override
    public boolean place(Animal animal) {
        eatGrass(animal.getPosition());
        return super.place(animal);
    }

}

package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grassList = new HashMap<>();

    public GrassField(int grassAmmount) {
        placeGrass(grassAmmount);
    }


    private void placeGrass(int grassAmmount){
        ArrayList<Vector2d> grassPositions = new ArrayList<>();
        int bound = (int) Math.sqrt(10 * grassAmmount);
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                grassPositions.add(new Vector2d(i, j));
                mapBoundary.updateMapBoundary(new Vector2d(i, j));
            }
        }

        Random random = new Random();
        for (int i = 0; i < grassAmmount; ++i) {
            int randomIndex = random.nextInt(grassPositions.size());
            Vector2d grassPosition = grassPositions.get(randomIndex);
            grassList.put(grassPosition, new Grass(grassPosition));
            grassPositions.remove(grassPosition);
        }
    }

    public boolean isOccupiedByGrass(Vector2d position) {
        return grassList.containsKey(position);
    }

    public boolean isOccupiedByAnimal(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedByAnimal(position);
    }

    public Object objectAt(Vector2d position) {
        if(isOccupiedByGrass(position)){
            return grassList.get(position);
        }
        return animals.get(position);
    }

    @Override
    public Vector2d calcLowerBound() {
        return mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d calcUpperBound() {
        return mapBoundary.getUpperRight();
    }


}

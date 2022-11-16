package agh.ics.oop;

public class GrassField implements IWorldMap{
    private int grassAmount;

    public GrassField(int grassAmount) {
        this.grassAmount = grassAmount;
        placeGrass();
    }

    private int genRandomInt(double max){
        return (int)Math.floor(Math.random()*(max +1));
    }

    public void placeGrass(){
        Vector2d grass = new Vector2d(genRandomInt(Math.sqrt(10*grassAmount)), genRandomInt(Math.sqrt(10*grassAmount)));
        for(int i=0;i<grassAmount;++i){
            while(!placeGrassOnCoordinates(grass)){
                grass=new Vector2d(genRandomInt(Math.sqrt(10*grassAmount)), genRandomInt(Math.sqrt(10*grassAmount)));
            }
        }
    }

    public boolean placeGrassOnCoordinates(Vector2d grassPosition){
        if(!isOccupiedByGrass(grassPosition)){
            grassMap.put(grassPosition,new Grass(grassPosition));
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}

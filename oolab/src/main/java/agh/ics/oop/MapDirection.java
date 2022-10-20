package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public String toString(){
        return switch (this) {
            case NORTH -> "Polnoc";
            case SOUTH -> "Poludnie";
            case WEST -> "Zachod";
            case EAST -> "Wschod";
        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH -> MapDirection.EAST;
            case SOUTH -> MapDirection.WEST;
            case WEST -> MapDirection.NORTH;
            case EAST -> MapDirection.SOUTH;
        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH -> MapDirection.WEST;
            case SOUTH -> MapDirection.EAST;
            case WEST -> MapDirection.SOUTH;
            case EAST -> MapDirection.NORTH;
        };
    }

    public int[] toUnitVector(){
        return switch (this) {
            case NORTH -> new int[] {0, 1};
            case SOUTH -> new int[] {0, -1};
            case WEST -> new int[] {-1, 0};
            case EAST -> new int[] {1, 0};
        };
    }


    public static void main(String[] args){
    }
}

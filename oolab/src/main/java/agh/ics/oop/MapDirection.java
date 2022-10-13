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
    public String next(){
        return switch (this) {
            case NORTH -> "Wschod";
            case SOUTH -> "Zachod";
            case WEST -> "Polnoc";
            case EAST -> "Poludnie";
        };
    }
    public String previous(){
        return switch (this) {
            case NORTH -> "Zachod";
            case SOUTH -> "Wschod";
            case WEST -> "Poludnie";
            case EAST -> "Polnoc";
        };
    }

    public int[] toUnitVector(){
        return switch (this) {
            case NORTH -> new int[] {0, 1};
            case SOUTH -> new int[] {0, -1};
            case WEST -> new int[] {1, 0};
            case EAST -> new int[] {-1, 0};
        };
    }


    public static void main(String[] args){
    }
}

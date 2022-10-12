package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }
    public String next(){
        return switch (this) {
            case NORTH -> "Wschód";
            case SOUTH -> "Zachód";
            case WEST -> "Północ";
            case EAST -> "Południe";
        };
    }
    public String previous(){
        return switch (this) {
            case NORTH -> "Zachód";
            case SOUTH -> "Wschód";
            case WEST -> "Południe";
            case EAST -> "Północ";
        };
    }
}

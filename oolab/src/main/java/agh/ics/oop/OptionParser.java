package agh.ics.oop;

public class OptionParser {
    public MoveDirection[] parser(String[] moves){
        MoveDirection[] moves2 = new MoveDirection[moves.length];
        int i = 0;
        for (String move: moves){
            switch (move) {
                case "b", "backward" -> moves2[i] = MoveDirection.BACKWARD;
                case "f", "forward" -> moves2[i] = MoveDirection.FORWARD;
                case "l", "left" -> moves2[i] = MoveDirection.LEFT;
                case "r", "right" -> moves2[i] = MoveDirection.RIGHT;
            };
            i += 1;
        }
        return moves2;
    }

}

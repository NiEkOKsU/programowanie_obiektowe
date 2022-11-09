package agh.ics.oop;

import java.util.Arrays;

public class OptionParser {
    public MoveDirection[] parser(String[] moves){
        MoveDirection[] moves2 = new MoveDirection[moves.length];
        int i = 0;
        for (String move: moves){
            switch (move) {
                case "b", "backward" ->{
                    moves2[i] = MoveDirection.BACKWARD;
                    i += 1;
                }
                case "f", "forward" -> {
                    moves2[i] = MoveDirection.FORWARD;
                    i += 1;
                }
                case "l", "left" -> {
                    moves2[i] = MoveDirection.LEFT;
                    i += 1;
                }
                case "r", "right" -> {
                    moves2[i] = MoveDirection.RIGHT;
                    i += 1;
                }
            }

        }
        return Arrays.copyOf(moves2, i);
    }

}

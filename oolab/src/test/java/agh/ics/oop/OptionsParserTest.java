package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void correctParsing() {
        String[] moves = {"left", "b", "f", "r", "left", "l", "f", "backward", "l", "forward", "b", "left", "right"};
        MoveDirection f = MoveDirection.FORWARD;
        MoveDirection l = MoveDirection.LEFT;
        MoveDirection r = MoveDirection.RIGHT;
        MoveDirection b = MoveDirection.BACKWARD;
        MoveDirection[] correct = {l, b, f, r, l, l, f, b, l, f, b, l, r};
        assertArrayEquals(correct, OptionsParser.parse(moves));
    }


    @Test
    void incorrectTestValues() {
        String[] moves = {"hsxgvxhg", "hjbgaw", "r", "f", "b", "lft", "rigth", "forword", "forward", "wstecz", "d"};
        MoveDirection f = MoveDirection.FORWARD;
        MoveDirection b = MoveDirection.BACKWARD;
        MoveDirection l = MoveDirection.LEFT;
        MoveDirection r = MoveDirection.RIGHT;
        MoveDirection[] correct = {r, f, b, f};
        MoveDirection[] ans = OptionsParser.parse(moves);
        assertArrayEquals(correct, ans);

    }
}
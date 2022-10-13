package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void nextCheck(){
        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.next(), "Zachod");
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.next(), "Wschod");
        MapDirection east = MapDirection.EAST;
        assertEquals(east.next(), "Poludnie");
        MapDirection west = MapDirection.WEST;
        assertEquals(west.next(), "Polnoc");
    }


    @Test
    void prevCheck(){
        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.previous(), "Wschod");
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.previous(), "Zachod");
        MapDirection east = MapDirection.EAST;
        assertEquals(east.previous(), "Polnoc");
        MapDirection west = MapDirection.WEST;
        assertEquals(west.previous(), "Poludnie");
    }
}
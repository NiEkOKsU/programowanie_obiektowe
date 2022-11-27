package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void nextCheck(){
        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.next(), MapDirection.WEST);
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.next(), MapDirection.EAST);
        MapDirection east = MapDirection.EAST;
        assertEquals(east.next(), MapDirection.SOUTH);
        MapDirection west = MapDirection.WEST;
        assertEquals(west.next(), MapDirection.NORTH);
    }


    @Test
    void prevCheck(){
        MapDirection south = MapDirection.SOUTH;
        assertEquals(south.previous(), MapDirection.EAST);
        MapDirection north = MapDirection.NORTH;
        assertEquals(north.previous(), MapDirection.WEST);
        MapDirection east = MapDirection.EAST;
        assertEquals(east.previous(), MapDirection.NORTH);
        MapDirection west = MapDirection.WEST;
        assertEquals(west.previous(), MapDirection.SOUTH);
    }
}
package Tests;

import Code.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTests{

    @Test
    void TestNorthFrameLine(){
        assertEquals(3, Direction.NORTH.getFrameLineNumber());
    }

    @Test
    void TestSouthFrameLine(){
        assertEquals(2, Direction.SOUTH.getFrameLineNumber());
    }

    @Test
    void TestEastFrameLine(){
        assertEquals(1, Direction.EAST.getFrameLineNumber());
    }

    @Test
    void TestWestFrameLine(){
        assertEquals(0, Direction.WEST.getFrameLineNumber());
    }
}
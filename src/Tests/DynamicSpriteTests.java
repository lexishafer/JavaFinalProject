package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicSpriteTests{

    @Test
    void TestMoveEast(){
        Pacman p = TestHelpers.createPacman();
        double oldX = p.getX();
        p.setDirection(Direction.EAST);
        p.moveIfPossible(new ArrayList<>());
        assertTrue(p.getX() > oldX);
    }

    @Test
    void TestMoveWest(){
        Pacman p = TestHelpers.createPacman();
        double oldX = p.getX();
        p.setDirection(Direction.WEST);
        p.moveIfPossible(new ArrayList<>());
        assertTrue(p.getX() < oldX);
    }

    @Test
    void TestMoveNorth(){
        Pacman p = TestHelpers.createPacman();
        double oldY = p.getY();
        p.setDirection(Direction.NORTH);
        p.moveIfPossible(new ArrayList<>());
        assertTrue(p.getY() < oldY);
    }

    @Test
    void TestMoveSouth(){
        Pacman p = TestHelpers.createPacman();
        double oldY = p.getY();
        p.setDirection(Direction.SOUTH);
        p.moveIfPossible(new ArrayList<>());
        assertTrue(p.getY() > oldY);
    }

    @Test
    void TestSetSpeed(){
        Pacman p = TestHelpers.createPacman();
        p.setSpeed(20);
        assertEquals(20, p.getSpeed());
    }

    @Test
    void TestSetDirection(){
        Pacman p = TestHelpers.createPacman();
        p.setDirection(Direction.NORTH);
        assertEquals(Direction.NORTH, p.getDirection());
    }
}
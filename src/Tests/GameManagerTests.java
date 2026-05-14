package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GameManagerTests{

    @Test
    void TestPelletCollision(){
        Pacman p = TestHelpers.createPacman();
        Pellet pellet = new Pellet(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        GameManager gm = TestHelpers.createGameManager(p);
        gm.onCollision(p, pellet);
        assertEquals(10, p.getScore());
        assertTrue(pellet.isCollected());
    }

    @Test
    void TestPowerPelletCollision(){
        Pacman p = TestHelpers.createPacman();
        PowerPellet pp = new PowerPellet(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        GameManager gm = TestHelpers.createGameManager(p);
        gm.onCollision(p, pp);
        assertTrue(p.isPoweredUp());
    }

    @Test
    void TestGhostCollision(){
        Pacman p = TestHelpers.createPacman();
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        GameManager gm = TestHelpers.createGameManager(p);
        gm.onCollision(p, g);
        assertEquals(2, p.getLives());
    }

    @Test
    void TestPowerPacmanEatsGhost(){
        Pacman p = TestHelpers.createPacman();
        p.activatePowerMode(1000);
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        GameManager gm = TestHelpers.createGameManager(p);
        gm.onCollision(p, g);
        assertEquals(200, p.getScore());
    }

    @Test
    void TestInvisiblePacmanNoDie(){
        Pacman p = TestHelpers.createPacman();
        p.activateInvisibility(1000);
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        GameManager gm = TestHelpers.createGameManager(p);
        gm.onCollision(p, g);
        assertEquals(3, p.getLives());
    }
}
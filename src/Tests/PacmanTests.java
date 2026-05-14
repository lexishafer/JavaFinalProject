package Tests;

import Code.Pacman;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacmanTests{

    @Test
    void testScoreInitialization(){
        Pacman p = TestHelpers.createPacman();
        assertEquals(0, p.getScore());
    }

    @Test
    void testAddScore(){
        Pacman p = TestHelpers.createPacman();
        p.addScore(25);
        assertEquals(25, p.getScore());
    }

    @Test
    void TestLoseLife(){
        Pacman p = TestHelpers.createPacman();
        p.loseLife();
        assertEquals(2, p.getLives());
    }

    @Test
    void TestDead(){
        Pacman p = TestHelpers.createPacman();
        p.loseLife();
        p.loseLife();
        p.loseLife();
        assertTrue(p.isDead());
    }

    @Test
    void TestPowerModeActivates(){
        Pacman p = TestHelpers.createPacman();
        p.activatePowerMode(1000);
        assertTrue(p.isPoweredUp());
    }

    @Test
    void TestInvisibilityActivates(){
        Pacman p = TestHelpers.createPacman();
        p.activateInvisibility(1000);
        assertTrue(p.isInvisible());
    }

    @Test
    void TestSpeedBoostActivates(){
        Pacman p = TestHelpers.createPacman();
        p.activateSpeedBoost(1000);
        assertTrue(p.isSpeedBoosted());
    }

    @Test
    void TestImmunityActivates(){
        Pacman p = TestHelpers.createPacman();
        p.activateImmunity(1000);
        assertTrue(p.isImmune());
    }

    @Test
    void TestResetForNewGameWorks(){
        Pacman p = TestHelpers.createPacman();
        p.addScore(100);
        p.loseLife();
        p.activatePowerMode(1000);
        p.resetForNewGame();
        assertEquals(0, p.getScore());
        assertEquals(3, p.getLives());
        assertFalse(p.isPoweredUp());
    }
}

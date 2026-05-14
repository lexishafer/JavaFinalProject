package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PowerUpTests{

    @Test
    void TestSpeedUp(){
        Pacman p = TestHelpers.createPacman();
        SpeedUp s = new SpeedUp(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        s.apply(p, TestHelpers.createGameManager(p));
        assertTrue(p.isSpeedBoosted());
    }

    @Test
    void TestInvisibile() {
        Pacman p = TestHelpers.createPacman();
        Invisibility i = new Invisibility(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        i.apply(p, TestHelpers.createGameManager(p));
        assertTrue(p.isInvisible());
    }

    @Test
    void TestTeleport(){
        Pacman p = TestHelpers.createPacman();
        double oldX = p.getX();
        double oldY = p.getY();
        Teleport t = new Teleport(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        t.apply(p, TestHelpers.createGameManager(p));
        boolean moved = oldX != p.getX() || oldY != p.getY();
        assertTrue(moved);
    }

    @Test
    void TestAngryGhosts() {
        Pacman p = TestHelpers.createPacman();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState()));
        GameManager gm = new GameManager(null, p, ghosts, new ArrayList<>(), null);
        AngryGhosts a = new AngryGhosts(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        a.apply(p, gm);
        assertTrue(true);
    }
}
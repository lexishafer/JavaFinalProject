package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GhostTests{

    @Test
    void TestFrightenedStateActive(){
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        g.setFrightened(1000);
        assertNotNull(g.getBaseState());
    }

    @Test
    void TestGhostUpdate(){
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        Pacman p = TestHelpers.createPacman();
        g.update(new ArrayList<>(), p);
        assertNotNull(g.getDirection());
    }

    @Test
    void TestChangingState(){
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        g.setState(new AggressiveState());
        Pacman p = TestHelpers.createPacman();
        g.update(new ArrayList<>(), p);
        assertNotNull(g.getDirection());
    }

    @Test
    void TestSetLastDirectionChange(){
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        g.setLastDirectionChange(500);
        assertEquals(500, g.getLastDirectionChange());
    }
}
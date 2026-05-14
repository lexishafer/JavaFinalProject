package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GhostStateTests{

    @Test
    void TestAggressiveStateDirection(){
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggressiveState());
        Pacman p = TestHelpers.createPacman();
        AggressiveState a = new AggressiveState();
        a.update(g, new ArrayList<>(), p);
        assertNotNull(g.getDirection());
    }

    @Test
    void TestFrightenedState() {
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        FrightenedState f = new FrightenedState();
        f.update(g, new ArrayList<>(), TestHelpers.createPacman());
        assertNotNull(g.getDirection());
    }

    @Test
    void TestRandomState() {
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new RandomState());
        RandomState r = new RandomState();
        r.update(g, new ArrayList<>(), TestHelpers.createPacman());
        assertNotNull(g.getDirection());
    }

    @Test
    void TestAggClose() {
        Ghost g = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggCloseState(100));
        AggCloseState a = new AggCloseState(100);
        a.update(g, new ArrayList<>(), TestHelpers.createPacman());
        assertNotNull(g.getDirection());
    }
}
package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AggCloseTests{

    @Test
    void TestCloseGhost(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggCloseState(200));
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 50.0,0.0,10.0,10.0, "mr");
        AggCloseState state = new AggCloseState(200);
        state.update(ghost, new ArrayList<>(), pacman);
        assertEquals(Direction.EAST, ghost.getDirection());
    }

    @Test
    void TestFarGhost(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggCloseState(50));
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 500.0,500.0,10.0,10.0, "mr");
        AggCloseState state = new AggCloseState(50);
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }

    @Test
    void TestInvisiblePacman(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggCloseState(200));
        Pacman pacman = TestHelpers.createPacman();
        pacman.activateInvisibility(5000);
        AggCloseState state = new AggCloseState(200);
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }
}
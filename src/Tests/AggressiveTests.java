package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AggressiveTests{

    @Test
    void TestAggEast(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggressiveState());
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 100.0,0.0,10.0,10.0, "mr");
        AggressiveState state = new AggressiveState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertEquals(Direction.EAST, ghost.getDirection());
    }

    @Test
    void TestAggWest(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 100.0,0.0,10.0,10.0, new AggressiveState());
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, "mr");
        AggressiveState state = new AggressiveState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertEquals(Direction.WEST, ghost.getDirection());
    }

    @Test
    void TestAggSouth(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggressiveState());
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 0.0,100.0,10.0,10.0, "mr");
        AggressiveState state = new AggressiveState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertEquals(Direction.SOUTH, ghost.getDirection());
    }

    @Test
    void TestAggNorth(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,100.0,10.0,10.0, new AggressiveState());
        Pacman pacman = new Pacman(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, "mr");
        AggressiveState state = new AggressiveState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertEquals(Direction.NORTH, ghost.getDirection());
    }

    @Test
    void TestAggRandomInvisible(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0,0.0,10.0,10.0, new AggressiveState());
        Pacman pacman = TestHelpers.createPacman();
        pacman.activateInvisibility(5000);
        AggressiveState state = new AggressiveState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }
}
package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RandomStateTests{

    @Test
    void TestUpdate(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0, 0.0, 10.0, 10.0, new RandomState());
        Pacman pacman = TestHelpers.createPacman();
        RandomState state = new RandomState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }

    @Test
    void TestDirectionChange(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0, 0.0, 10.0, 10.0, new RandomState());
        Pacman pacman = TestHelpers.createPacman();
        ghost.setLastDirectionChange(0);
        RandomState state = new RandomState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }

    @Test
    void TestWithWalls(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0, 0.0, 10.0, 10.0, new RandomState());
        Pacman pacman = TestHelpers.createPacman();
        ArrayList<Sprite> env = new ArrayList<>();
        env.add(new SolidSprite(TestHelpers.dummyImage(), 10.0, 0.0, 10.0, 10.0));
        RandomState state = new RandomState();
        state.update(ghost, env, pacman);
        assertNotNull(ghost.getDirection());
    }

    @Test
    void TestBlocked(){
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0, 0.0, 10.0, 10.0, new RandomState());
        ghost.setDirection(Direction.EAST);
        Pacman pacman = TestHelpers.createPacman();
        ArrayList<Sprite> env = new ArrayList<>();
        env.add(new SolidSprite(TestHelpers.dummyImage(), 2.0, 0.0, 10.0, 10.0));
        RandomState state = new RandomState();
        state.update(ghost, env, pacman);
        assertNotNull(ghost.getDirection());
    }

    @Test
    void TestCoolDown() {
        Ghost ghost = new Ghost(TestHelpers.dummyImage(), 0.0, 0.0, 10.0, 10.0, new RandomState());
        Pacman pacman = TestHelpers.createPacman();
        ghost.setLastDirectionChange(System.currentTimeMillis());
        RandomState state = new RandomState();
        state.update(ghost, new ArrayList<>(), pacman);
        assertNotNull(ghost.getDirection());
    }
}
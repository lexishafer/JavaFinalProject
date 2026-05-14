package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PhysicEngineTests{

    @Test
    void TestAddMovingSprite(){
        PhysicEngine p = new PhysicEngine();
        Pacman pacman = TestHelpers.createPacman();
        p.addToMovingSpriteList(pacman);
        assertTrue(true);
    }

    @Test
    void TestSetEnvironment(){
        PhysicEngine p = new PhysicEngine();
        ArrayList<Sprite> env = new ArrayList<>();
        p.setEnvironment(env);
        assertTrue(true);
    }

    @Test
    void TestSetCollisionListener(){
        PhysicEngine p = new PhysicEngine();
        p.setCollisionListener(new CollisionListener() {
            @Override
            public void onCollision(DynamicSprite mover, Sprite object) {}
        });
        assertTrue(true);
    }

//tests that there si no crash in update
    @Test
    void TestUpdate(){
        PhysicEngine p = new PhysicEngine();
        Pacman pacman = TestHelpers.createPacman();
        p.addToMovingSpriteList(pacman);
        p.setEnvironment(new ArrayList<>());
        p.update();
        assertTrue(true);
    }

    @Test
    void TestCollisionsOccur(){
        PhysicEngine p = new PhysicEngine();
        Pacman pacman = TestHelpers.createPacman();
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,10);
        ArrayList<Sprite> env = new ArrayList<>();
        env.add(s);
        p.addToMovingSpriteList(pacman);
        p.setEnvironment(env);
        final boolean[] collided = {false};
        p.setCollisionListener(new CollisionListener() {
            @Override
            public void onCollision(DynamicSprite mover, Sprite object) {
                collided[0] = true;
            }
        });
        p.update();
        assertTrue(collided[0]);
    }
}
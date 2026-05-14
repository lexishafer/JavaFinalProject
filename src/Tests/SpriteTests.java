package Tests;

import Code.Sprite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpriteTests{

    @Test
    void TestSetX(){
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,10);
        s.setX(50);
        assertEquals(50, s.getX());
    }

    @Test
    void TestSetY(){
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,10);
        s.setY(75);
        assertEquals(75, s.getY());
    }

    @Test
    void TestSetImage(){
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,10);
        s.setImage(TestHelpers.dummyImage());
        assertNotNull(s.getImage());
    }

    @Test
    void TestGetWidth(){
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,15);
        assertEquals(10, s.getWidth());
    }

    @Test
    void TestGetHeight(){
        Sprite s = new Sprite(TestHelpers.dummyImage(), 0,0,10,15);
        assertEquals(15, s.getHeight());
    }
}
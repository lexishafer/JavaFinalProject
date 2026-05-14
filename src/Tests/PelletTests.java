package Tests;

import Code.Pellet;
import Code.PowerPellet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PelletTests{

    @Test
    void TestPelletsCollect(){
        Pellet p = new Pellet(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        p.collect();
        assertTrue(p.isCollected());
    }

    @Test
    void TestPelletsReset(){
        Pellet p = new Pellet(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        p.collect();
        p.reset();
        assertFalse(p.isCollected());
    }

    @Test
    void TestPowerPelletPoints(){
        PowerPellet p = new PowerPellet(TestHelpers.dummyImage(), TestHelpers.dummyImage(), 0,0,10,10);
        assertEquals(50, p.getPoints());
    }
}
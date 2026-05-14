package Tests;

import Code.Pacman;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimerTests{

    @Test
    void TestPowerModeExpire() throws Exception{
        Pacman p = TestHelpers.createPacman();
        p.activatePowerMode(1);
        Thread.sleep(5);
        p.updatePowerTimers();
        assertFalse(p.isPoweredUp());
    }

    @Test
    void TestInvisibilityExpire() throws Exception{
        Pacman p = TestHelpers.createPacman();
        p.activateInvisibility(1);
        Thread.sleep(5);
        p.updatePowerTimers();
        assertFalse(p.isInvisible());
    }

    @Test
    void TestSpeedUpExpire() throws Exception{
        Pacman p = TestHelpers.createPacman();
        p.activateSpeedBoost(1);
        Thread.sleep(5);
        p.updatePowerTimers();
        assertFalse(p.isSpeedBoosted());
    }

    @Test
    void TestImmunityExpire() throws Exception{
        Pacman p = TestHelpers.createPacman();
        p.activateImmunity(1);
        Thread.sleep(5);
        p.updatePowerTimers();
        assertFalse(p.isImmune());
    }
}
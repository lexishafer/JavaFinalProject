package Tests;

import Code.GameState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTests{

    @Test
    void TestMenu(){
        assertEquals("MENU", GameState.MENU.name());
    }

    @Test
    void TestCS(){
        assertEquals("CHARACTER_SELECT", GameState.CHARACTER_SELECT.name());
    }

    @Test
    void TestPlaying(){
        assertEquals("PLAYING", GameState.PLAYING.name());
    }

    @Test
    void TestGameOver(){
        assertEquals("GAME_OVER", GameState.GAME_OVER.name());
    }
}
package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTests{

    @Test
    void TestRightKey(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        GameEngine engine = new GameEngine(p, game);
        game.setCurrentState(GameState.PLAYING);
        KeyEvent e = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, ' ');
        engine.keyPressed(e);
        assertEquals(Direction.EAST, p.getDirection());
    }

    @Test
    void TestLeftKey(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        GameEngine engine = new GameEngine(p, game);
        game.setCurrentState(GameState.PLAYING);
        KeyEvent e = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, ' ');
        engine.keyPressed(e);
        assertEquals(Direction.WEST, p.getDirection());
    }

    @Test
    void TestUpKey(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        GameEngine engine = new GameEngine(p, game);
        game.setCurrentState(GameState.PLAYING);
        KeyEvent e = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, ' ');
        engine.keyPressed(e);
        assertEquals(Direction.NORTH, p.getDirection());
    }

    @Test
    void TestDownKey(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        GameEngine engine = new GameEngine(p, game);
        game.setCurrentState(GameState.PLAYING);
        KeyEvent e = new KeyEvent(new java.awt.Canvas(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, ' ');
        engine.keyPressed(e);
        assertEquals(Direction.SOUTH, p.getDirection());
    }
}
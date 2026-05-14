package Tests;

import Code.*;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

public class RenderEngineTests{

    @Test
    void TestUpdate(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        RenderEngine r = new RenderEngine(game, p);
        r.update();
        assertTrue(true);
    }

    @Test
    void TestPaintMenu(){
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        RenderEngine r = new RenderEngine(game, p);
        game.setCurrentState(GameState.MENU);
        Graphics g = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        r.paint(g);
        assertTrue(true);
    }

    @Test
    void TestPaintCS() {
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        RenderEngine r = new RenderEngine(game, p);
        game.setCurrentState(GameState.CHARACTER_SELECT);
        Graphics g = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        r.paint(g);
        assertTrue(true);
    }

    @Test
    void TestPaintPlaying() {
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        RenderEngine r = new RenderEngine(game, p);
        game.setCurrentState(GameState.PLAYING);
        Graphics g = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        r.paint(g);
        assertTrue(true);
    }

    @Test
    void TestPaintGameOver() {
        Game game = new Game();
        Pacman p = TestHelpers.createPacman();
        RenderEngine r = new RenderEngine(game, p);
        game.setCurrentState(GameState.GAME_OVER);
        Graphics g = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        r.paint(g);
        assertTrue(true);
    }
}
package Tests;

import Code.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TestHelpers{
    public static Image dummyImage(){
        return new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    }

    public static Pacman createPacman(){
        return new Pacman(dummyImage(), 0.0, 0.0, 10.0, 10.0, "mr");
    }

    public static GameManager createGameManager(Pacman p){
        Game game = new Game();
        game.setCurrentState(GameState.PLAYING);
        ArrayList<Pellet> pellets = new ArrayList<>();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Playground playground = new Playground("assets/level/level.txt", pellets, ghosts, p);
        return new GameManager(game, p, ghosts, pellets, playground);
    }
}

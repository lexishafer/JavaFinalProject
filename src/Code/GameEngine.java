package Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener{
    //the game engine has a pacman
    private Game game;
    private final DynamicSprite pacman;

    public GameEngine(DynamicSprite pacman, Game game){
        this.pacman = pacman;
        this.game = game;
    }

    @Override
    public void update(){}

    //checks for if a key is pressed, and dependign on the game state, does what is intended.
    @Override
    public void keyPressed(KeyEvent e){
        switch (game.getCurrentState()){
            case MENU:
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    game.setCurrentState(GameState.CHARACTER_SELECT);
                }
                break;

            case CHARACTER_SELECT:
                if(e.getKeyCode() == KeyEvent.VK_1){
                    game.setPacmanCharacter("mr");
                    game.setCurrentState(GameState.PLAYING);
                }else if(e.getKeyCode() == KeyEvent.VK_2){
                    game.setPacmanCharacter("mrs");
                    game.setCurrentState(GameState.PLAYING);
                }
                break;

            case PLAYING:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        pacman.setDirection(Direction.NORTH);
                        break;
                    case KeyEvent.VK_DOWN:
                        pacman.setDirection(Direction.SOUTH);
                        break;
                    case KeyEvent.VK_LEFT:
                        pacman.setDirection(Direction.WEST);
                        break;
                    case KeyEvent.VK_RIGHT:
                        pacman.setDirection(Direction.EAST);
                        break;
                }
                break;

            case GAME_OVER:
                if(e.getKeyCode() == KeyEvent.VK_R){
                    game.restartGame();
                }
                break;
        }
    }

    //these need to be overriden because it implements KeyListener
    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}
}

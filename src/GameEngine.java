import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener {
    //the game engine has a pacman
    private final DynamicSprite pacman;

    public GameEngine(DynamicSprite pacman){
        this.pacman = pacman;
    }

    @Override
    public void update() {}

    //checks for if a key is pressed, and sets the direction accordingly
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
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
    }

    //these need to be overriden because it implements KeyListener
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    
}

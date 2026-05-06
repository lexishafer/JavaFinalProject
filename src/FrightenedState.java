import java.util.ArrayList;

public class FrightenedState implements GhostState {
    @Override
    public void update(Ghost ghost, ArrayList<Sprite> env, Sprite pacman) {
        Direction[] dirs = Direction.values();
        ghost.setDirection(dirs[(int)(Math.random() * dirs.length)]);
    }
}
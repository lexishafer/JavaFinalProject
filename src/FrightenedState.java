import java.util.ArrayList;

public class FrightenedState implements GhostState{
    //I know this motion isn't very good, it is how I implemented the random state before making it smoother, but I kind of like how it looks for the frightened state
    @Override
    public void update(Ghost ghost, ArrayList<Sprite> env, Sprite pacman){
        Direction[] dirs = Direction.values();
        ghost.setDirection(dirs[(int)(Math.random() * dirs.length)]);
    }
}
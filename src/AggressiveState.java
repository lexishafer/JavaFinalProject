import java.util.ArrayList;

public class AggressiveState implements GhostState {
    @Override
    public void update(Ghost ghost, ArrayList<Sprite> env, Sprite pacman) {

        double dx = pacman.getX() - ghost.getX();
        double dy = pacman.getY() - ghost.getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            ghost.setDirection(dx > 0 ? Direction.EAST : Direction.WEST);
        } else {
            ghost.setDirection(dy > 0 ? Direction.SOUTH : Direction.NORTH);
        }
    }
}

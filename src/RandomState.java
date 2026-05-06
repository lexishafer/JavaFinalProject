import java.util.ArrayList;

public class RandomState implements GhostState {
    @Override
    public void update(Ghost ghost, ArrayList<Sprite> env, Sprite pacman) {
        long now = System.currentTimeMillis();

        if (now - ghost.getLastDirectionChange() > 300) {
            Direction[] dirs = Direction.values();
            for (int i = 0; i < dirs.length; i++) {
                Direction tryDir = dirs[(int)(Math.random() * dirs.length)];
                ghost.setDirection(tryDir);
                if (ghost.canMove(env)) {
                    ghost.setLastDirectionChange(now);
                    break;
                }
            }
        }
    }
}

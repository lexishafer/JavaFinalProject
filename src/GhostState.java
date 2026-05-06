import java.util.ArrayList;

public interface GhostState {
    void update(Ghost ghost, ArrayList<Sprite> environment, Sprite pacman);
}

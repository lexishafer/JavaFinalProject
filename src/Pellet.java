import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pellet extends Sprite {

    private boolean collected = false;
    private int points = 10;

    public Pellet(Image image, double x, double y, double width, double height) {
        super(image, x, y, width, height);
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        if (!collected) {
            collected = true;
            try {
                super.setImage(ImageIO.read(new File("assets/img/floor.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getPoints() {
        return points;
    }

    public void reset() {
        collected = false;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
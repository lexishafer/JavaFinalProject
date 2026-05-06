import java.awt.*;

public class PowerPellet extends Pellet {
    private long duration = 8000;

    public PowerPellet(Image image, double x, double y, double width, double height) {
        super(image, x, y, width, height);
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public int getPoints() {
        return 50;
    }
}
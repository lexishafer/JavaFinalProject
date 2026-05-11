import java.awt.*;

public class PowerPellet extends Pellet{
    private long duration = 8000;

    public PowerPellet(Image imagePowerPellet, Image imageFloor, double x, double y, double width, double height){
        super(imagePowerPellet, imageFloor, x, y, width, height);
    }

    public long getDuration(){
        return duration;
    }

    @Override
    public int getPoints(){
        return 50;
    }
}
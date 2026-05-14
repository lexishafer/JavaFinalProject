package Code;

import java.awt.*;

public abstract class PowerUp extends Pellet{
    private long duration;

    public PowerUp(Image image, Image floor, double x, double y, double w, double h, long duration){
        super(image, floor, x, y, w, h);
        this.duration = duration;
    }

    public long getDuration(){
        return duration;
    }

    public abstract void apply(Pacman pacman, GameManager manager);
}
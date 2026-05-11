import java.awt.*;

public class SpeedUp extends PowerUp{
    public SpeedUp(Image img, Image floor, double x, double y, double w, double h){
        super(img, floor, x, y, w, h, 6000);
    }

    @Override
    public void apply(Pacman pacman, GameManager manager){
        pacman.activateSpeedBoost(getDuration());
    }
}
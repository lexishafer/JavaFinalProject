package Code;

import java.awt.*;

public class Teleport extends PowerUp{
    public Teleport(Image img, Image floor, double x, double y, double w, double h){
        super(img, floor, x, y, w, h, 1); // instant effect
    }

    @Override
    public void apply(Pacman pacman, GameManager manager){
        manager.teleportPacman();
    }
}
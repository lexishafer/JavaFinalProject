import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pellet extends Sprite{
    private Image pelletImage;
    private Image floorImage;
    private boolean collected = false;
    private int points = 10;

    public Pellet(Image pelletImage, Image floorImage, double x, double y, double width, double height){
        super(pelletImage, x, y, width, height);
        this.pelletImage = pelletImage;
        this.floorImage = floorImage;
    }

    public boolean isCollected(){
        return collected;
    }

    public void collect(){
        if (!collected){
            collected = true;
            setImage(floorImage);
        }
    }

    public int getPoints(){
        return points;
    }

    public void reset(){
        collected = false;
        setImage(pelletImage);
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
    }
}
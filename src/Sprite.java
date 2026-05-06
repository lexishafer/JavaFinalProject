import java.awt.*;

public class Sprite implements Displayable{
    //sprites have a displayable image, a location, and dimensions
    private Image image;
    private double x;
    private double y;
    private double width;
    private double height;

    //constructor takes all of the variables in during creation of sprite
    public Sprite(Image image, double x, double y, double width, double height){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //override draw method
    @Override
    public void draw(Graphics g){
        g.drawImage(image,(int)x,(int)y,(int)width,(int)height,null);
    }

    //getters for all of the sprite attributes
    public Image getImage(){
        return this.image;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    //setters for x and y, used when moving or teleporting the dynmaic sprite
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
}

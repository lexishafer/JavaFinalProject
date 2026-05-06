import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite {
    private boolean isWalking = true;
    protected double speed = 5;
    protected int spriteSheetNumberOfColumn = 4;
    private int timeBetweenFrame = 300;
    private Direction direction = Direction.SOUTH;

    DynamicSprite(Image image, Double x, Double y, Double width, Double height) {
        super(image,x,y,width,height);
    }

    //direction setting method, used with key read
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //override of draw method,
    @Override
    public void draw(Graphics g){
        //calculate how many images to display, get row number from direction, and draw the image, created getters in the sprite class for this
        int index = (int)((System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumn);
        int attitude = direction.getFrameLineNumber();
        g.drawImage(super.getImage(), (int)super.getX(), (int)super.getY(), (int)(super.getX() + super.getWidth()), (int)(super.getY() + super.getHeight()), index * (int)super.getWidth(), attitude * (int)super.getHeight(), (index + 1) * (int)super.getWidth(), (attitude + 1) * (int)super.getHeight(), null);
    }

    //set a new position based on the direction and speed of the hero
    protected void move() {
        switch (direction) {
            case NORTH:
                setY(getY() - speed);
                break;
            case SOUTH:
                setY(getY() + speed);
                break;
            case EAST:
                setX(getX() + speed);
                break;
            case WEST:
                setX(getX() - speed);
                break;
        }
    }

    //check if the hero can move by checking if the hypothetical new position intersects with a solid sprite
    private boolean isMovingPossible(ArrayList<Sprite> environment){
        double xNew = getX();
        double yNew = getY();

        switch (direction) {
            case NORTH:
                yNew -= speed;
                break;
            case SOUTH:
                yNew += speed;
                break;
            case EAST:
                xNew += speed;
                break;
            case WEST:
                xNew -= speed;
                break;
        }

        Rectangle2D.Double hitBox = new Rectangle2D.Double(xNew, yNew, super.getWidth(), super.getHeight());

        for (Sprite sprite : environment) {
            if (sprite instanceof SolidSprite && sprite != this) {
                Rectangle2D.Double otherHitBox = new Rectangle2D.Double(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

                if (hitBox.intersects(otherHitBox)) {
                    return false;
                }
            }
        }
        return true;
    }

    //move the sprite if you can
    public void moveIfPossible(ArrayList<Sprite> environment) {
        if (isMovingPossible(environment)) {
            move();
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean canMove(ArrayList<Sprite> environment) {
        return isMovingPossible(environment);
    }

    public Direction getDirection() {
        return this.direction;
    }
}
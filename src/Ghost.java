import java.awt.*;
import java.util.ArrayList;

public class Ghost extends DynamicSprite{
    private GhostState state;
    private boolean frightened = false;
    private long frightenedEndTime;
    private long lastDirectionChange = 0;
    private long directionCooldown = 300;

    public Ghost(Image image, Double x, Double y, Double width, Double height) {
        super(image, x, y, width, height);
        this.state = new RandomState();
        super.spriteSheetNumberOfColumn = 1;
    }

    public void setState(GhostState state) {
        this.state = state;
    }

    public void update(ArrayList<Sprite> environment, Sprite pacman) {
        if (frightened && System.currentTimeMillis() > frightenedEndTime) {
            frightened = false;
            this.setState(new RandomState());
        } else {
            state.update(this, environment, pacman);
        }

        double distance = Math.hypot(
                pacman.getX() - getX(),
                pacman.getY() - getY()
        );

        if (!frightened) {
            if (distance < 150) {
                setState(new AggressiveState());
            } else {
                setState(new RandomState());
            }
        }
    }

    public void setFrightened(long duration) {
        frightened = true;
        frightenedEndTime = System.currentTimeMillis() + duration;
        this.setState(new FrightenedState());
    }

    public long getLastDirectionChange() {
        return lastDirectionChange;
    }

    public void setLastDirectionChange(long time) {
        this.lastDirectionChange = time;
    }

    @Override
    public void draw(Graphics g) {
        int attitude = getDirection().getFrameLineNumber();

        g.drawImage(
                getImage(),
                (int)getX(),
                (int)getY(),
                (int)(getX() + getWidth()),
                (int)(getY() + getHeight()),
                0,
                attitude * (int)getHeight(),
                (int)getWidth(),
                (attitude + 1) * (int)getHeight(),
                null
        );
    }

}

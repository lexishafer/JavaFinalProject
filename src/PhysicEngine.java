import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PhysicEngine implements Engine {
    private ArrayList<DynamicSprite> movingSpriteList;
    private ArrayList<Sprite> environment;
    private CollisionListener listener;

    public PhysicEngine() {
        movingSpriteList = new ArrayList<>();
        environment = new ArrayList<>();
    }

    public void addToMovingSpriteList(DynamicSprite sprite) {
        movingSpriteList.add(sprite);
    }

    public void setEnvironment(ArrayList<Sprite> environment) {
        this.environment = environment;
    }

    public void setCollisionListener(CollisionListener listener) {
        this.listener = listener;
    }

    @Override
    public void update() {
        for (DynamicSprite sprite : movingSpriteList) {
            sprite.moveIfPossible(environment);
            for (Sprite s : environment) {
                Rectangle2D.Double spriteBox = new Rectangle2D.Double(
                        sprite.getX(), sprite.getY(),
                        sprite.getWidth(), sprite.getHeight()
                );
                Rectangle2D.Double objectBox = new Rectangle2D.Double(
                        s.getX(), s.getY(),
                        s.getWidth(), s.getHeight()
                );
                if (spriteBox.intersects(objectBox)) {
                    if (listener != null) {
                        listener.onCollision(sprite, s);
                    }
                }
            }
        }
    }
}
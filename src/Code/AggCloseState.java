package Code;

import java.util.ArrayList;
import java.util.Random;

public class AggCloseState implements GhostState{
    private double aggDistance;
    private final Random random = new Random();
    private static final long CHANGE_INTERVAL = 400;

    public AggCloseState(double aggDistance){
        this.aggDistance = aggDistance;
    }

    @Override
    public void update(Ghost ghost, ArrayList<Sprite> env, Sprite pacman){
        if(pacman instanceof Pacman p && p.isInvisible()){
            long now = System.currentTimeMillis();
            if(!ghost.canMove(env)){
                setRandomValidDirection(ghost, env);
                ghost.setLastDirectionChange(now);
                return;
            }
            if(now - ghost.getLastDirectionChange() < CHANGE_INTERVAL){
                return;
            }
            if(random.nextDouble() < 0.7){
                return;
            }
            setRandomValidDirection(ghost, env);
            ghost.setLastDirectionChange(now);
            return;
        }

        double distance = Math.hypot(pacman.getX() - ghost.getX(), pacman.getY() - ghost.getY());
        if(distance < aggDistance){
            double dx = pacman.getX() - ghost.getX();
            double dy = pacman.getY() - ghost.getY();
            if(Math.abs(dx) > Math.abs(dy)){
                if(dx>0){
                    ghost.setDirection(Direction.EAST);
                } else{
                    ghost.setDirection(Direction.WEST);
                }
            } else{
                if(dy>0){
                    ghost.setDirection(Direction.SOUTH);
                } else{
                    ghost.setDirection(Direction.NORTH);
                }
            }
        } else{
            long now = System.currentTimeMillis();
            if(!ghost.canMove(env)){
                setRandomValidDirection(ghost, env);
                ghost.setLastDirectionChange(now);
                return;
            }
            if(now - ghost.getLastDirectionChange() < CHANGE_INTERVAL){
                return;
            }
            if(random.nextDouble() < 0.7){
                return;
            }
            setRandomValidDirection(ghost, env);
            ghost.setLastDirectionChange(now);
        }
    }

    private void setRandomValidDirection(Ghost ghost, ArrayList<Sprite> env){
        Direction current = ghost.getDirection();
        Direction[] directions = Direction.values();
        ArrayList<Direction> valid = new ArrayList<>();
        for(Direction dir : directions){
            ghost.setDirection(dir);
            if(ghost.canMove(env)){
                valid.add(dir);
            }
        }

        ghost.setDirection(current);

        if(valid.isEmpty()){
            return;
        }
        Direction opposite = getOpposite(current);
        valid.remove(opposite);

        if(valid.isEmpty()){
            valid.add(opposite);
        }
        Direction chosen = valid.get(random.nextInt(valid.size()));
        ghost.setDirection(chosen);
    }

    private Direction getOpposite(Direction d){
        Direction opposite = Direction.NORTH;
        switch (d){
            case NORTH -> opposite = Direction.SOUTH;
            case SOUTH -> opposite = Direction.NORTH;
            case EAST  -> opposite = Direction.WEST;
            case WEST  -> opposite = Direction.EAST;
        };
        return opposite;
    }
}

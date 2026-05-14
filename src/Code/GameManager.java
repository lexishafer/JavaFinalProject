package Code;

import java.util.ArrayList;

//I added this class to handle part of what the physics engine was doing before. I was trying to implement too many collisions there and it started getting confusing so this was added to handle the collisions.
public class GameManager implements Engine, CollisionListener{
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private ArrayList<Pellet> pellets;
    private long lastHitTime = 0;
    private final long hitCooldown = 1000;
    private Playground playground;
    private Game game;

    public GameManager(Game game, Pacman pacman, ArrayList<Ghost> ghosts, ArrayList<Pellet> pellets, Playground playground){
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.pellets = pellets;
        this.game = game;
        this.playground = playground;
    }

    @Override
    public void update(){
        if (game.getCurrentState() != GameState.PLAYING){
            return;
        }
        pacman.updatePowerTimers();
        if (pacman.isDead()){
            game.setCurrentState(GameState.GAME_OVER);
        }
        if (allPelletsCollected()){
            resetLevel();
        }
    }

    @Override
    public void onCollision(DynamicSprite mover, Sprite object){
        if(game.getCurrentState() != GameState.PLAYING){
            return;
        }

        if(mover instanceof Pacman p){
            if(object instanceof PowerPellet power && !power.isCollected()){
                power.collect();
                p.addScore(power.getPoints());
                p.activatePowerMode(power.getDuration());
                for(Ghost g : ghosts){
                    g.setFrightened(power.getDuration());
                }
            }
            else if(object instanceof PowerUp powerUp && !powerUp.isCollected()){
                powerUp.collect();
                p.addScore(powerUp.getPoints());
                powerUp.apply(p, this);
            }
            else if(object instanceof Pellet pellet && !pellet.isCollected()){
                pellet.collect();
                p.addScore(pellet.getPoints());
            }
            if(object instanceof Ghost ghost){
                long now = System.currentTimeMillis();
                if(now - lastHitTime < hitCooldown){
                    return;
                }

                lastHitTime = now;
                if(p.isPoweredUp()){
                    p.addScore(200);
                    respawnGhost(ghost);
                } else if(!p.isInvisible() && !p.isImmune()){
                    p.loseLife();
                    respawnPacman();
                }
            }
        }
    }

    private boolean allPelletsCollected(){
        for(Pellet p : pellets){
            if(!p.isCollected()){
                return false;
            }
        }
        return true;
    }

    private void setGhostsFrightened(){
        for(Ghost g : ghosts){
            g.setState(new FrightenedState());
        }
    }

    private void respawnPacman(){
        pacman.setX(playground.getPacmanSpawnX());
        pacman.setY(playground.getPacmanSpawnY());
        pacman.resetPowerStates();
        pacman.activateImmunity(2000);
    }

    private void respawnGhost(Ghost ghost){
        ghost.setX(playground.getGhostSpawnX());
        ghost.setY(playground.getGhostSpawnY());
        ghost.setState(ghost.getBaseState());
    }

    private void resetLevel(){
        for (Pellet p : pellets){
            p.reset();
        }
        pacman.setX(playground.getPacmanSpawnX());
        pacman.setY(playground.getPacmanSpawnY());
        pacman.resetPowerStates();
        for(Ghost g : ghosts){
            g.setX(playground.getGhostSpawnX());
            g.setY(playground.getGhostSpawnY());
            g.setState(g.getBaseState());
        }
    }

    public void setAllGhostStates(GhostState state){
        for(Ghost g : ghosts){
            g.setState(state);
        }
    }

    public void teleportPacman(){
        ArrayList<Sprite> walkable = playground.getWalkableTiles();
        if(walkable.isEmpty()){
            return;
        }
        Sprite randomTile = walkable.get((int)(Math.random() * walkable.size()));
        pacman.setX(randomTile.getX());
        pacman.setY(randomTile.getY());
    }
}
import java.util.ArrayList;

public class GameManager implements Engine, CollisionListener {
    private GameState state = GameState.PLAYING;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private ArrayList<Pellet> pellets;
    private long lastHitTime = 0;
    private final long hitCooldown = 1000;
    private Playground playground;

    public GameManager(Pacman pacman, ArrayList<Ghost> ghosts, ArrayList<Pellet> pellets, Playground playground) {
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.pellets = pellets;
        this.playground = playground;
    }

    @Override
    public void update() {
        switch (state) {
            case PLAYING -> {
                pacman.updatePowerTimers();
                if (pacman.isDead()) {
                    state = GameState.GAME_OVER;
                }
                if (allPelletsCollected()) {
                    state = GameState.WIN;
                }
            }
            case WIN -> {
                // later: regenerate level
            }
            case GAME_OVER -> {
                // freeze game
            }
            default -> {}
        }
    }

    @Override
    public void onCollision(DynamicSprite mover, Sprite object) {
        if (state != GameState.PLAYING) return;

        if (mover instanceof Pacman p) {
            if (object instanceof PowerPellet power && !power.isCollected()) {
                power.collect();
                p.addScore(power.getPoints());
                p.activatePowerMode(power.getDuration());
                for (Ghost g : ghosts) {
                    g.setFrightened(power.getDuration());
                }
            }
            else if (object instanceof Pellet pellet && !pellet.isCollected()) {
                pellet.collect();
                p.addScore(pellet.getPoints());
            }
            if (object instanceof Ghost ghost) {
                long now = System.currentTimeMillis();
                if (now - lastHitTime < hitCooldown) return;

                lastHitTime = now;
                if (p.isPoweredUp()) {
                    p.addScore(200);
                    respawnGhost(ghost);
                } else if (!p.isInvisible()) {
                    p.loseLife();
                    respawnPacman();
                }
            }
        }
    }

    private boolean allPelletsCollected() {
        for (Pellet p : pellets) {
            if (!p.isCollected()) return false;
        }
        return true;
    }

    private void setGhostsFrightened() {
        for (Ghost g : ghosts) {
            g.setState(new FrightenedState());
        }
    }

    private void respawnPacman() {
        pacman.setX(playground.getPacmanSpawnX());
        pacman.setY(playground.getPacmanSpawnY());
        pacman.resetPowerStates();
    }

    private void respawnGhost(Ghost ghost) {
        ghost.setX(playground.getGhostSpawnX());
        ghost.setY(playground.getGhostSpawnY());
        ghost.setState(new RandomState());
    }
}
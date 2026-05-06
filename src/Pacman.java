import java.awt.*;

public class Pacman extends DynamicSprite{
    private int score;
    private int lives;
    private boolean poweredUp;
    private long powerModeEndTime;
    private boolean invisible;
    private long invisibleEndTime;
    private boolean speedBoosted;
    private long speedBoostEndTime;
    private String characterType;
    private final double normalSpeed = 5.0;
    private final double boostedSpeed = 10.0;

    public Pacman(Image image, Double x, Double y, Double width, Double height, String characterType) {
        super(image, x, y, width, height);

        this.score = 0;
        this.lives = 3;
        this.poweredUp = false;
        this.invisible = false;
        this.speedBoosted = false;
        this.characterType = characterType;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void resetScore() {
        score = 0;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }

    public void gainLife() {
        lives++;
    }

    public boolean isDead() {
        return (lives <= 0);
    }

    public void activatePowerMode(long durationMillis) {
        poweredUp = true;
        powerModeEndTime = System.currentTimeMillis() + durationMillis;
    }

    public boolean isPoweredUp() {
        return poweredUp;
    }

    public void activateInvisibility(long durationMillis) {
        invisible = true;
        invisibleEndTime = System.currentTimeMillis() + durationMillis;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void activateSpeedBoost(long durationMillis) {
        speedBoosted = true;
        speedBoostEndTime = System.currentTimeMillis() + durationMillis;
        setSpeed(boostedSpeed);
    }

    public boolean isSpeedBoosted() {
        return speedBoosted;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public void updatePowerTimers() {
        long currentTime = System.currentTimeMillis();

        if (poweredUp && currentTime > powerModeEndTime) {
            poweredUp = false;
        }

        if (invisible && currentTime > invisibleEndTime) {
            invisible = false;
        }

        if (speedBoosted && currentTime > speedBoostEndTime) {
            speedBoosted = false;
            setSpeed(normalSpeed);
        }
    }

    public void resetPowerStates() {
        poweredUp = false;
        invisible = false;
        speedBoosted = false;
        setSpeed(normalSpeed);
    }

    public void resetForNewGame() {
        score = 0;
        lives = 3;
        resetPowerStates();
    }

}

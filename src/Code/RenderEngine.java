package Code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderEngine extends JPanel implements Engine{
    //has a list of items to be rendered
    private List<Displayable> renderList;
    private Game game;
    private Pacman pacman;

    public RenderEngine(Game game, Pacman pacman){
        this.game = game;
        this.pacman = pacman;
        renderList = new ArrayList<>();
    }

    //set and add methods as described
    public void setRenderList(List<Displayable> renderList){
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable){
        renderList.add(displayable);
    }

    //overriden to repaint
    @Override
    public void update(){
        repaint();
    }

    //This was updated so that the correct thing is drawn based on the game state
    @Override
    public void paint(Graphics g){
        super.paint(g);
        switch(game.getCurrentState()){
            case MENU -> drawMenu(g);
            case CHARACTER_SELECT -> drawCharacterSelect(g);
            case PLAYING -> drawGame(g);
            case GAME_OVER -> drawGameOver(g);
        }
    }

    private void drawMenu(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("PACMAN", 220, 200);
        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.drawString("Press ENTER to Start", 220, 350);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Arrow Keys to Move", 270, 450);
    }

    private void drawCharacterSelect(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 42));
        g.drawString("SELECT CHARACTER", 150, 180);
        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.drawString("Press 1 for PACMAN", 220, 320);
        g.drawString("Press 2 for MRS PACMAN", 180, 400);
    }

    private void drawGame(Graphics g){
        // draw all sprites
        for(Displayable d : renderList){
            d.draw(g);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + pacman.getScore(), 20, 25);
        g.drawString("Lives: " + pacman.getLives(), 20, 50);
        if(pacman.isPoweredUp()){
            g.drawString("POWER MODE", 600, 25);
        }
        if(pacman.isInvisible()){
            g.drawString("INVISIBLE", 600, 50);
        }
        if(pacman.isSpeedBoosted()){
            g.drawString("2X SPEED", 600, 75);
        }
    }

    private void drawGameOver(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("GAME OVER", 160, 250);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 28));
        g.drawString("Final Score: " + pacman.getScore(), 240, 360);
        g.drawString("Press R to Restart", 220, 430);
    }
}
package Code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//This class essentially replaces what the main did in Dungeon Crawler, mostly for neatness, but it also made it easier for me to use game states
public class Game{
    private PhysicEngine physics;
    private RenderEngine render;
    private GameManager manager;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private ArrayList<Pellet> pellets;
    private GameState currentState;

    private Playground playground;

    public Game(){
        init();
    }

    private void init(){
        try{
            pacman = new Pacman(ImageIO.read(new File("assets/img/pacmansprite.png")), 100.0, 300.0, 21.25, 21.25,"mr");
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        ghosts = new ArrayList<>();
        pellets = new ArrayList<>();

        playground = new Playground("level.txt", pellets, ghosts, pacman);

        physics = new PhysicEngine();
        render = new RenderEngine(this, pacman);

        physics.setEnvironment(playground.getAllSprites());

        manager = new GameManager(this, pacman, ghosts, pellets,playground);
        physics.setCollisionListener(manager);

        physics.addToMovingSpriteList(pacman);
        for(Ghost ghost : ghosts){
            physics.addToMovingSpriteList(ghost);
        }

        playground.setPelletList(pellets);
        playground.setGhostList(ghosts);
        playground.setPacman(pacman);

        render.setRenderList(playground.getSpriteList());
        render.addToRenderList(pacman);
        for(Ghost g : ghosts){
            render.addToRenderList(g);
        }

        currentState = GameState.MENU;
    }

    public void start(){
        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(870, 770);
        frame.add(render);
        frame.addKeyListener(new GameEngine(pacman, this));
        frame.setVisible(true);

        while(true){
            update();
            try{
                Thread.sleep(20); //game will not run without this
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void update(){
        manager.update();
        for(Ghost ghost : ghosts){
            ghost.update(playground.getSolidSpriteList(), pacman);
        }
        physics.update();
        render.update();
    }

    public GameState getCurrentState(){
        return currentState;
    }

    public void setCurrentState(GameState state){
        this.currentState = state;
    }

    public void setPacmanCharacter(String type){
        try{
            if(type.equals("mr")){
                pacman.setImage(ImageIO.read(new File("assets/img/pacmansprite.png")));
            } else{
                pacman.setImage(ImageIO.read(new File("assets/img/mspacmansprite.png")));
            }
            pacman.setCharacterType(type);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void restartGame(){
        pacman.resetForNewGame();
        pacman.setX(playground.getPacmanSpawnX());
        pacman.setY(playground.getPacmanSpawnY());
        for(Pellet p : pellets){
            p.reset();
        }
        for(Ghost g : ghosts){
            g.setX(playground.getGhostSpawnX());
            g.setY(playground.getGhostSpawnY());
            g.setState(g.getBaseState());
        }
        currentState = GameState.MENU;
    }
}

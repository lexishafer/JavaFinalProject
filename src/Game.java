import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private PhysicEngine physics;
    private RenderEngine render;
    private GameManager manager;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;
    private ArrayList<Pellet> pellets;

    private Playground playground;

    public Game() {
        init();
    }

    private void init() {
        try {
            pacman = new Pacman(ImageIO.read(new File("assets/img/pacmansprite.png")), 100.0, 300.0, 21.25, 21.25,"mr");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ghosts = new ArrayList<>();
        pellets = new ArrayList<>();

        playground = new Playground("level.txt", pellets, ghosts, pacman);

        physics = new PhysicEngine();
        render = new RenderEngine();

        physics.setEnvironment(playground.getAllSprites());

        manager = new GameManager(pacman, ghosts, pellets,playground);
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
        for (Ghost g : ghosts) {
            render.addToRenderList(g);
        }
    }

    public void start() {
        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 750);
        frame.add(render);
        frame.addKeyListener(new GameEngine(pacman));
        frame.setVisible(true);

        while (true) {
            update();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        manager.update();

        for (Ghost ghost : ghosts) {
            ghost.update(playground.getSolidSpriteList(), pacman);
        }

        physics.update();
        render.update();
    }
}

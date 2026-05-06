import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Playground {
    private ArrayList<Sprite> environment = new ArrayList<>();
    private List<Pellet> pellets;
    private List<Ghost> ghosts;
    private Pacman pacman;

    private double tileWidth;
    private double tileHeight;
    private double pacmanSpawnX;
    private double pacmanSpawnY;
    private double ghostSpawnX;
    private double ghostSpawnY;

    public Playground(String pathName, List<Pellet> pellets, List<Ghost> ghosts, Pacman pacman) {
        this.pellets = pellets;
        this.ghosts = ghosts;
        this.pacman = pacman;

        try {
            final Image imageWall = ImageIO.read(new File("assets/img/wall.png"));
            final Image imageFloor = ImageIO.read(new File("assets/img/floor.png"));
            final Image imagePellet = ImageIO.read(new File("assets/img/pellet.png"));
            final Image imagePower = ImageIO.read(new File("assets/img/powerpellet.png"));

            tileWidth = imageFloor.getWidth(null);
            tileHeight = imageFloor.getHeight(null);


            BufferedReader bufferedReader = new BufferedReader(new FileReader("assets/level/level.txt"));

            String line;
            int row = 0;
            int ghostCount = 0;
            while ((line = bufferedReader.readLine()) != null) {

                for (int col = 0; col < line.length(); col++) {
                    char element = line.charAt(col);
                    double x = col * tileWidth;
                    double y = row * tileHeight;
                    switch (element) {
                        case '#':
                            environment.add(new SolidSprite(
                                    imageWall, x, y, tileWidth, tileHeight
                            ));
                            break;
                        case ' ':
                            environment.add(new Sprite(
                                    imageFloor, x, y, tileWidth, tileHeight
                            ));
                            break;
                        case '.':
                            Pellet p = new Pellet(imagePellet, x, y, tileWidth, tileHeight);
                            pellets.add(p);
                            environment.add(p);
                            break;

                        case 'o':
                            PowerPellet pp = new PowerPellet(imagePower, x, y, tileWidth, tileHeight);
                            pellets.add(pp);
                            environment.add(pp);
                            break;

                        case 'P':
                            pacmanSpawnX = x;
                            pacmanSpawnY = y;
                            pacman.setX(x);
                            pacman.setY(y);
                            break;

                        case 'G':
                            if(ghostCount==0){
                                ghostSpawnX = x;
                                ghostSpawnY = y;
                                Ghost g = new Ghost(ImageIO.read(new File("assets/img/grgh.png")), x, y, tileWidth, tileHeight);
                                ghostCount++;
                                ghosts.add(g);
                                environment.add(g);
                                break;
                            }
                            else if(ghostCount==1){
                                Ghost g = new Ghost(ImageIO.read(new File("assets/img/regh.png")), x, y, tileWidth, tileHeight);
                                ghostCount++;
                                ghosts.add(g);
                                environment.add(g);
                                break;
                            }
                            else if(ghostCount==2){
                                Ghost g = new Ghost(ImageIO.read(new File("assets/img/blgh.png")), x, y, tileWidth, tileHeight);
                                ghostCount++;
                                ghosts.add(g);
                                environment.add(g);
                                break;
                            } else{
                                break;
                            }

                        default:
                            environment.add(new Sprite(
                                    imageFloor, x, y, tileWidth, tileHeight
                            ));
                            break;
                    }
                }
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPelletList(List<Pellet> pellets) {
        this.pellets = pellets;
    }

    public void setGhostList(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }


    public ArrayList<Sprite> getSolidSpriteList() {
        ArrayList<Sprite> solids = new ArrayList<>();
        for (Sprite sprite : environment) {
            if (sprite instanceof SolidSprite) {
                solids.add(sprite);
            }
        }
        return solids;
    }

    public ArrayList<Displayable> getSpriteList() {
        ArrayList<Displayable> list = new ArrayList<>();
        list.addAll(environment);
        return list;
    }

    public ArrayList<Sprite> getAllSprites() {
        return environment;
    }

    public double getPacmanSpawnX() { return pacmanSpawnX; }
    public double getPacmanSpawnY() { return pacmanSpawnY; }

    public double getGhostSpawnX() { return ghostSpawnX; }
    public double getGhostSpawnY() { return ghostSpawnY; }
}
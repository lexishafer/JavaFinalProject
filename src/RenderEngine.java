import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderEngine extends JPanel implements Engine {
    //has a list of items to be rendered
    private List<Displayable> renderList;

    RenderEngine(){
        renderList = new ArrayList<>();
    }

    //set and add methods as described
    public void setRenderList(List<Displayable> renderList){
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        renderList.add(displayable);
    }

    //overriden to repaint
    @Override
    public void update(){
        repaint();
    }

    //draw all of the items decribed in the render list
    @Override
    public void paint(Graphics g){
        super.paint(g);

        for(Displayable d : renderList){
            d.draw(g);
        }
    }

}

import javax.swing.*;
import java.awt.*;

public class Tree {
    public Image image = (new ImageIcon("tree.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

    public Tree(){

    }
    public void draw(Graphics g) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        g.drawImage(image, (int)(Math.random()*900), (int)(Math.random()*900), null);
    }
}


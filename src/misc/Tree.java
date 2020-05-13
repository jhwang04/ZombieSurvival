package misc;

import javax.swing.*;
import java.awt.*;

public class Tree {
    public Image image = (new ImageIcon("tree.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    private int x;
    private int y;

    public Tree(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        //g.drawImage(image, (int)x - width/2, (int)y - height/2, null);
    }
}


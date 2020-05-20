/*
jeremy mills
5/10/2020
Rev: 02
Notes: not used in the final project, this was experimentation but was abandoned
 */

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
        //g.drawImage(image, (int)(Math.random()*900), (int)(Math.random()*900), null);
    }
}


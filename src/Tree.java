/*
jeremy mills
5/10/2020
Rev: 02
Notes: not used in the final project, this was experimentation but was abandoned
 */


import javax.swing.*;
import java.awt.*;

public class Tree {
    public Image image = (new ImageIcon("tree.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    private int x; //x coord of the tree
    private int y; //y coord of the tree

    //default constructor
    public Tree(int x, int y){
        this.x = x;
        this.y = y;
    }

    //draws the tree
    public void draw(Graphics g) {
        //g.drawImage(image, (int)(Math.random()*900), (int)(Math.random()*900), null);
    }
}


package misc.Items;

import java.awt.*;
import java.awt.event.KeyEvent;

import entities.*;

import javax.swing.*;

public class Armor {

    private int x;
    private int y;
    private Image image = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
    private int width;
    private int height;
    public Hitbox hitbox;
    public boolean pickedUp;

    public Armor(int x, int y) {
        this.x = x;
        this.y = y;


        hitbox = new Hitbox(x, y, width, height);
        pickedUp = false;
    }a


    public void draw(Graphics g) {
        width = image.getWidth(null);
        height = image.getHeight(null);


        g.drawImage(image, x - width / 2, y - height / 2, null);


    }

    public int getX() { return x; }

    public int getY() { return y; }

    public Image getImage() { return image; }

}

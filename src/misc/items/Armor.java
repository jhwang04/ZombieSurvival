package misc.items;

import java.awt.*;

import entities.*;

import javax.swing.*;

public class Armor extends Hitbox {

    private int x;
    private int y;
    private Image image = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
    private int width;
    private int height;
    public boolean pickedUp;

    public Armor(int x, int y) {
        super(x, y, 40, 40);
        this.x = x;
        this.y = y;

        pickedUp = false;
    }


    public void draw(Graphics g) {
        width = image.getWidth(null);
        height = image.getHeight(null);


        g.drawImage(image, x - width / 2, y - height / 2, null);


    }

    public void hide() {
        image = (new ImageIcon("empty.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
    }

    public void unHide() {
        image = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public Image getImage() { return image; }

}

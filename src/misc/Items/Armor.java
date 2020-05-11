package misc.Items;

import java.awt.*;
import java.awt.event.KeyEvent;

import entities.*;

public class Armor {

    private int x;
    private int y;
    private Image image;
    private int width;
    private int height;
    public Hitbox hitbox;
    public boolean pickedUp;

    public Armor(int x, int y, Image icon) {
        this.x = x;
        this.y = y;
        image = icon;

        int width = image.getWidth(null);
        int height = image.getHeight(null);

        hitbox = new Hitbox(x, y, width, height);
        pickedUp = false;
    }

    public void pickUp(Hitbox box, KeyEvent e) {
        if (hitbox.isTouching(box)) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                case KeyEvent.VK_F:
                    pickedUp = true;
                    break;
            }

        }
    }

    public void draw(Graphics g) {
        if (pickedUp = false) {
            g.drawImage(image, x - width / 2, y - height / 2, null);
        }
        else if (pickedUp = true) {

        }
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public Image getImage() { return image; }

}

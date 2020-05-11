package misc.Items;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import zombiesurvivalgame.*;

public class HealthKit {
    public Hitbox hitbox;
    private int x;
    private int y;
    private boolean pickedUp;
    public Image image = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private ZombieSurvivalGame game;

    public HealthKit(int x, int y) {
        this.x = x;
        this.y = y;
        pickedUp = false;

        Hitbox hitbox = new Hitbox(x - 15, y - 15, 70, 70);
    }

    public void pickUp(KeyEvent e, Hitbox box) {

        game.getPlayer().pickUp(box, e);
    }

    public void draw(Graphics g) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        g.drawImage(image, (int) x - width/2, (int) y - height/2, null);

    }


}

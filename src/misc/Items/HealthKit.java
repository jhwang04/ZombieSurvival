package misc.Items;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import zombiesurvivalgame.*;

public class HealthKit extends Hitbox{
    public Hitbox hitbox;
    private int x;
    private int y;
    private boolean pickedUp;
    public Image image = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private ZombieSurvivalGame game;

    public HealthKit(int x, int y) {
        super(x, y, 40, 40);

        pickedUp = false;


    }


    public void draw(Graphics g) {

        int width = image.getWidth(null);
        int height = image.getHeight(null);
        g.drawImage(image, (int) x - width / 2, (int) y - height / 2, null);

    }

    public void hide() {
        image = (new ImageIcon("empty.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        this.x = -1000;
        this.y = -1000;

    }

    public void unHide() {
        image = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
    }

    public void setPickedUp(boolean b) {
        this.pickedUp = true;
    }

    public boolean getPickedUp() {
        return this.pickedUp;
    }

}

/*
jeremy mills
5/12/2020
Rev: 01
 */

package misc.items;
import entities.*;

import javax.swing.*;
import java.awt.*;

import zombiesurvivalgame.*;

public class HealthKit extends Hitbox{
    private int x;
    private int y;
    private int hideCords;
    private int unHideCordsX;
    private int unHideCordsY;
    public boolean pickedUp;
    public Image image = (new ImageIcon("resources/medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private ZombieSurvivalGame game;

    public HealthKit(int x, int y) {
        super(x, y, 40, 40);

        pickedUp = false;

        hideCords = -10000;
        unHideCordsX = x;
        unHideCordsY = y;

        this.x = x;
        this.y = y;

    }


    public void draw(Graphics g) {

        g.drawImage(image, (int) x, (int) y, null);

        this.setHx(this.x);
        this.setHy(this.y);

    }

    public void hide() {
        image = (new ImageIcon("empty.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        this.x = hideCords;
        this.y = hideCords;
        pickedUp = true;

    }

    public void unHide() {
        image = (new ImageIcon("resources/medKit.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        pickedUp = false;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
    public void setPickedUp(boolean b) {
        this.pickedUp = true;
    }

    public boolean getPickedUp() {
        return this.pickedUp;
    }
*/
}

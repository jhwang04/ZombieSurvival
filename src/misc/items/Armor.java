/*
jeremy mills
5/12/2020
rev: 01
 */


package misc.items;

import java.awt.*;

import entities.*;

import javax.swing.*;

public class Armor extends Hitbox {

    private int x;
    private int y;
    private Image image = (new ImageIcon("resources/vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);
    private int hideCords;
    private int unHideCordsX;
    private int unHideCordsY;
    public boolean pickedUp;

    public Armor(int x, int y) {
        super(x, y, 40, 40);
        this.x = x;
        this.y = y;

        pickedUp = false;

        hideCords = -10000;
        unHideCordsX = x;
        unHideCordsY = y;
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
        image = (new ImageIcon("resources/vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        pickedUp = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}

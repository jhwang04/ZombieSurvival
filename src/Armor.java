/*
jeremy mills
5/12/2020
rev: 01
 */

import java.awt.*;

import javax.swing.*;

public class Armor extends Hitbox {

    private int x; //x coord of armor
    private int y; //y coord of armor
    private Image image = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH); //image of armor
    private int hideCords; //the coordinates that the armor goes to when it's hidden
    private int unHideCordsX; //coordinates that the armor is shown at
    private int unHideCordsY; //cordinates armor is shown at
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

    //draws the armor
    public void draw(Graphics g) {

        g.drawImage(image, (int) x, (int) y, null);

        this.setHx(this.x);
        this.setHy(this.y);

    }

    //hides the armor
    public void hide() {
        image = (new ImageIcon("empty.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;

        this.x = hideCords;
        this.y = hideCords;
        pickedUp = true;
    }

    //shows the armor
    public void unHide() {
        image = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        pickedUp = false;
    }

    //sets the X coordinate
    public void setX(int x) {
        this.x = x;
    }

    //sets the Y coordinate
    public void setY(int y) {
        this.y = y;
    }


}

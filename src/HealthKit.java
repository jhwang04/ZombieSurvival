/*
jeremy mills
5/12/2020
Rev: 01
 */

import javax.swing.*;
import java.awt.*;


public class HealthKit extends Hitbox{
    private int x; //x coordinate of the hitbox
    private int y; //y coordinate of the hitbox
    private int hideCords; //coordinates that the healthkit is hidden at
    private int unHideCordsX; //coordinates the healthkit is shown at
    private int unHideCordsY; //coordinates the helathkit is shown at
    public boolean pickedUp; //whether or not healthkit is picked up
    public Image image = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); //picture of the healthkit
    private ZombieSurvivalGame game; //game that the healthkit is inside of

    //default constructor
    public HealthKit(int x, int y) {
        super(x, y, 40, 40);

        pickedUp = false;

        hideCords = -10000;
        unHideCordsX = x;
        unHideCordsY = y;

        this.x = x;
        this.y = y;

    }

    //draws the healthkit
    public void draw(Graphics g) {

        g.drawImage(image, (int) x, (int) y, null);

        this.setHx(this.x);
        this.setHy(this.y);

    }

    //hides the healthkit
    public void hide() {
        image = (new ImageIcon("empty.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        this.x = hideCords;
        this.y = hideCords;
        pickedUp = true;

    }

    //shows the hitbox
    public void unHide() {
        image = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);;
        pickedUp = false;

    }

    //sets the x coordinate
    public void setX(int x) {
        this.x = x;
    }

    //sets the y coordinate
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

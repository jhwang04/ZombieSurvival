/*
Justin Hwang and jeremy
5/05/2020
Rev: 02
Notes:
  - Used for collisions, which includes bullets, players and zombies
  Jeremy: changed to not include the borders
 */

import java.awt.*;

public abstract class Hitbox {
    private double hx; //x coordinate of the top left corner of the hitbox
    private double hy; //y coordinate of the top left corner of the hitbox
    private int hw; //width of the hitbox
    private int hh; //height of the hitbox

    //default constructor
    public Hitbox(double x, double y, int w, int h) {
        this.hx = x;
        this.hy = y;
        this.hw = w;
        this.hh = h;
    }

    //the main collision detection method
    public boolean isTouching(Hitbox box) {
        double boxX = box.getHx();
        double boxY = box.getHy();
        int boxW = box.getHw();
        int boxH = box.getHh();

        if(boxX + boxW > hx && boxX < hx + hw && boxY + boxH > hy && boxY < hy + hh) {
            return true;
        } else {
            return false;
        }
    }

    //draw the hitbox method
    public void drawHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) hx, (int) hy, hw, hh);
    }

    //generic "get" methods
    //gets the x coord of the hitbox
    public double getHx() {
        return hx;
    }

    //gets the y coord of the hitbox
    public double getHy() {
        return hy;
    }

    //gets the width of the hitbox
    public int getHw() {
        return hw;
    }

    //gets the height of the hitbox
    public int getHh() {
        return hh;
    }

    //generic "set" methods
    //sets the x coord of the hitbox
    public void setHx(double x) {
        this.hx = x;
    }

    //sets the y coord of the hitbox
    public void setHy(double y) {
        this.hy = y;
    }

    //sets the width of the hitbox
    public void setHw(int w) {
        this.hw = w;
    }

    //sets the height of the hitbox
    public void setHh(int h) {
        this.hh = h;
    }
}

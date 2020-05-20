/*
Justin Hwang and jeremy
5/05/2020
Rev: 02
Notes:
  - Used for collisions, which includes bullets, players and zombies
  Jeremy: changed to not include the borders
 */

package entities;

import java.awt.*;

public abstract class Hitbox {
    private double hx; //x coordinate of the top left corner of the hitbox
    private double hy; //y coordinate of the top left corner of the hitbox
    private int hw; //width of the hitbox
    private int hh; //height of the hitbox

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
    public double getHx() {
        return hx;
    }

    public double getHy() {
        return hy;
    }

    public int getHw() {
        return hw;
    }

    public int getHh() {
        return hh;
    }

    //generic "set" methods
    public void setHx(double x) {
        this.hx = x;
    }

    public void setHy(double y) {
        this.hy = y;
    }

    public void setHw(int w) {
        this.hw = w;
    }

    public void setHh(int h) {
        this.hh = h;
    }
}

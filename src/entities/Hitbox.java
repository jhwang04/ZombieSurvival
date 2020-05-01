package entities;

public class Hitbox {
    private int hx; //x coordinate of the top left corner of the hitbox
    private int hy; //y coordinate of the top left corner of the hitbox
    private int hw; //width of the hitbox
    private int hh; //height of the hitbox

    public Hitbox(int x, int y, int w, int h) {
        this.hx = x;
        this.hy = y;
        this.hw = w;
        this.hh = h;
    }

    //the main collision detection method
    public boolean isTouching(Hitbox box) {
        int boxX = box.getHx();
        int boxY = box.getHy();
        int boxW = box.getHw();
        int boxH = box.getHh();

        if(boxX + boxW > hx && boxX < hx + hw && boxY + boxY > hy && boxY < hy + hh) {
            return true;
        } else {
            return false;
        }
    }

    //generic "get" methods
    public int getHx() {
        return hx;
    }

    public int getHy() {
        return hy;
    }

    public int getHw() {
        return hw;
    }

    public int getHh() {
        return hh;
    }
}

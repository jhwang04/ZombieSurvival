//Generic abstract ranged weapon class. Extend for pistol, rifle, etc.

package weapons;

import java.awt.*;

public abstract class Ranged {
    private int x; //x coordinate of the weapon itself
    private int y; //y coordinate of the weapon itself
    private Image weaponImage; //picture of the weapon itself. If we're doing animations, you're gonna have to change the whole image system.

    //default contructor
    public Ranged(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.weaponImage = image;
    }

    //useful methods
    public void shoot() {
        //placeholder, change anything you'd like
    }

    public void draw() {
        //placeholder, change anything you'd like
    }

    //generic "get" methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getWeaponImage() {
        return weaponImage;
    }
}

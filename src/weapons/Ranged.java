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

    public void draw(Graphics g) {
        int width = weaponImage.getWidth(null);
        int height = weaponImage.getHeight(null);
        g.drawImage(weaponImage, x - width/2, y - height/2, null);

        g.setColor(Color.RED);
        g.fillOval(x - 1, y-1, 3, 3);
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

    //generic "set" methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWeaponImage(Image image) {
        this.weaponImage = image;
    }
}

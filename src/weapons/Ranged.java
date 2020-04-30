//Generic abstract ranged weapon class. Extend for pistol, rifle, etc.

package weapons;

import java.awt.*;

public abstract class Ranged {
    private int range; //how far a bullet can go
    private double bulletSpeed; //how quickly a bullet/projectile can go.
    private double bulletDamage; //how much damage the bullet does on impact
    private Image bulletImage; //whatever picture we're using for the bullet
    private Image weaponImage; //picture of the weapon itself. If we're doing animations, you're gonna have to change the whole image system.

    //useful methods
    public void shoot() {
        //placeholder, change anything you'd like
    }

    public void draw() {
        //placeholder, change anything you'd like
    }

    //generic "get" methods
    public int getRange() { return range; }

    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public Image getBulletImage() {
        return bulletImage;
    }

    public Image getWeaponImage() {
        return weaponImage;
    }
}

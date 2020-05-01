package weapons.projectiles;

import java.awt.*;

public abstract class Projectile {
    private int x;
    private int y;
    private double speed;
    private double damage;
    private int range;
    private Image image;
    private double trajectory; //angle of the projectile, measured in degrees

    //default constructor
    public Projectile(int x, int y, double speed, double damage, int range, Image image, double trajectory) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.range = range;
        this.image = image;
        this.trajectory = trajectory;
    }

    //generic "get" methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public Image getImage() {
        return image;
    }
}

package weapons.projectiles;

import entities.Hitbox;

import java.awt.*;

public abstract class Projectile extends Hitbox {
    private int x;
    private int y;
    private double speed;
    private double damage;
    private int range;
    private Image image;
    private double trajectory; //angle of the projectile, measured in degrees

    //default constructor
    public Projectile(int x, int y, double speed, double damage, int range, Image image, double trajectory, int hx, int hy, int hw, int hh) {
        super(hx, hy, hw, hh);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.range = range;
        this.image = image;
        this.trajectory = trajectory;
    }

    //move and draw method
    public void draw(Graphics g) {
        //placeholder
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

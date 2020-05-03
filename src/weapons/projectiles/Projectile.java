package weapons.projectiles;

import entities.Hitbox;
import zombiesurvivalgame.ZombieSurvivalGame;

import java.awt.*;

public abstract class Projectile extends Hitbox {
    private double x;
    private double y;
    private double speed;
    private double damage;
    private int range;
    private double distanceTraveled;
    private boolean despawned = false;
    private Image image;
    private double trajectory; //angle of the projectile, measured in degrees
    private ZombieSurvivalGame game;

    //default constructor
    public Projectile(double x, double y, double speed, double damage, int range, Image image, double trajectory, ZombieSurvivalGame game, int hx, int hy, int hw, int hh) {
        super(hx, hy, hw, hh);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.range = range;
        this.image = image;
        this.trajectory = trajectory;
        this.distanceTraveled = 0.0;
        this.game = game;
    }

    //move and draw method
    public void move() {
        double changeX = speed * Math.cos(trajectory);
        double changeY = speed * Math.sin(trajectory);
        this.x += changeX;
        this.y -= changeY;
        distanceTraveled += this.speed;

        if(distanceTraveled >= this.range) {
            setDespawned(true);
        }
        for(int i = 0; i < game.monsters.length; i++) {
            if(this.isTouching(game.monsters[i])) {
                setDespawned(true);
                game.monsters[i].setHealth(game.monsters[i].getHealth() - damage);
            }
        }
    }

    public void draw(Graphics g) {
        move();
        if(this.despawned == false) {
            g.setColor(Color.BLACK);
            setHx(x - 10);
            setHy(y - 10);
            g.fillOval((int) x - 10, (int) y - 10, 20, 20);
        }
    }

    //generic "get" methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDamage() {
        return damage;
    }

    public double getDistanceTraveled() {return distanceTraveled;}

    public boolean getDespawned() {return despawned;};

    public int getRange() {
        return range;
    }

    public Image getImage() {
        return image;
    }

    public double getTrajectory() {
        return trajectory;
    }

    public void setDespawned(boolean b) {
        this.despawned = b;
    }
}

/*
Justin hwang
4/28/2020
Rev: 03
Notes:
  - Generic projectile class to be extended for different bullets
  - Added distance traveled and despawned fields, so the bullet won't fly off forever
  - Added actual moving/shooting functionality for the bullets themselves
 */
import java.awt.*;

public abstract class Projectile extends Hitbox {
    private double x; //x coordinate of the projectile
    private double y; //y coordinate of the projectile
    private double speed; //speed of the projectile
    private double damage; //damage of the projectile
    private int range; //range of the projectile
    private double distanceTraveled; //distance that the projectile has traveled
    private boolean despawned = false; //whether or not the projectile should disappear on the next frame
    private Image image; //image of the projectile
    private double trajectory; //angle of the projectile, measured in degrees
    private ZombieSurvivalGame game; //game the projectile is inside of

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

    //moves the projectile for the next frame
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

    //draws the projectile
    public void draw(Graphics g) {
        move(); //it needs to move first, move() is not called from outside this class
        if(this.despawned == false) {
            g.setColor(Color.BLACK);
            setHx(x - 10);
            setHy(y - 10);
            g.fillOval((int) x - 10, (int) y - 10, 20, 20);
        }
    }

    //generic "get" methods
    //gets the projectile x
    public double getX() {
        return x;
    }

    //gets the projectile y
    public double getY() {
        return y;
    }

    //gets the speed of the projectile
    public double getSpeed() {
        return speed;
    }

    //gets the damage of the projectile
    public double getDamage() {
        return damage;
    }

    //gets the distance the projectile has traveled
    public double getDistanceTraveled() {return distanceTraveled;}

    //gets whether or not the projectile has despawned
    public boolean getDespawned() {return despawned;};

    //gets the projectile range
    public int getRange() {
        return range;
    }

    //gets the image of the projectile
    public Image getImage() {
        return image;
    }

    //gets the trajectory of the projectile
    public double getTrajectory() {
        return trajectory;
    }


    //generic "set" methods
    //sets whether or not the projectile should disappear on the next frame
    public void setDespawned(boolean b) {
        this.despawned = b;
    }
}

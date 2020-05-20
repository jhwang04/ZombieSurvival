package entities;
/*
Justin Hwang
4/28/2020
Rev: 03
Notes:
  - Basic class to be extended by players and zombies
  - Added the movement speed variable
  - Added all the "set" commands
*/

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class LivingEntity extends Hitbox {
    private double maxHealth; //maximum health for the entity
    private double health; //current health for the entity
    private double movementSpeed; //speed, measured in some form. Not sure what units yet.
    private double x; //x-coordinate of entity
    private double y; //y-coordinate of entity

    //default constructor
    public LivingEntity(double x, double y, double maxHealth, double health, double movementSpeed, double hx, double hy, int hw, int hh) {
        super(hx, hy, hw, hh);
        this.x = x;
        this.y = y;
        this.maxHealth = maxHealth;
        this.health = health;
        this.movementSpeed = movementSpeed;
    }

    //useful methods
    public void draw(Graphics g) {
        //placeholder, this method is overriden by most classes
    }

    //Generic "get" methods
    public double getMaxHealth() {
        return maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    //generic "set" methods
    public void setMaxHealth(double maxHealth) {this.maxHealth = maxHealth;}

    public void setHealth(double health) {this.health = health;}

    public void setMovementSpeed(double movementSpeed) {this.movementSpeed = movementSpeed;}

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}


}

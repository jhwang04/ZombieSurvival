package entities;
/*
Savannah Bananas
04/28/2020
Generic class for a living entity, which both Monster and Player will extend
*/

import java.awt.*;

public abstract class LivingEntity {
    private double maxHealth; //maximum health for the entity
    private double health; //current health for the entity
    private double movementSpeed; //speed, measured in some form. Not sure what units yet.
    private int x; //x-coordinate of entity
    private int y; //y-coordinate of entity

    //default constructor
    public LivingEntity(int x, int y, double maxHealth, double health, double movementSpeed) {
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

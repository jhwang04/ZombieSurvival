
/*
Savannah Bananas
4/28/2020
This is the class of the main character that the user controls.
*/

package entities.friendlyEntities;

import entities.LivingEntity;
import weapons.Ranged;

import java.awt.*;

public class Player extends LivingEntity {
    private int points; //number of points the player has
    private int coins; //number of coins/currency the player has
    private Ranged gun; //player's equipped ranged weapon.

    private static final int PLAYER_HEIGHT = 100; //constant, for the default height of the player
    private static final int PLAYER_WIDTH = 50; //constant, for the default width of the player

    public Player(int x, int y, double maxHealth, double health, double movementSpeed) {
        super(x, y, maxHealth, health, movementSpeed, x - PLAYER_WIDTH/2, y-PLAYER_HEIGHT/2, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(this.getX() - 10, this.getY() - 10, 20, 20);

        //temporary dot, showing where the true x and y coords are
        g.setColor(Color.RED);
        g.fillOval(getX()-1, getY()-1, 3, 3);

        if(gun != null) {
            gun.setX(getX());
            gun.setY(getY());
            gun.draw(g);
        }
    }

    //generic "get" commands
    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }

    public Ranged getGun() { return gun; }

    //"set" methods
    public void setPoints(int points) {
        this.points = points;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addPoints(int amount) {
        this.points += amount;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void setGun(Ranged gun) {
        this.gun = gun;
    }
}

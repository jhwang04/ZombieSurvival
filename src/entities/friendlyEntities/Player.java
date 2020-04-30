
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

    public Player(int x, int y, double maxHealth, double health, double movementSpeed) {
        super(x, y, maxHealth, health, movementSpeed);
    }

    //generic "get" commands
    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(this.getX() - 10, this.getY() - 10, 20, 20);
    }
}


/*
Savannah Bananas
4/28/2020
This is the class of the main character that the user controls.
*/

package entities.friendlyEntities;

import entities.LivingEntity;

public class Player extends LivingEntity {
    private int points; //number of points the player has
    private int coins; //number of coins/currency the player has

    //generic "get" commands
    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }
}

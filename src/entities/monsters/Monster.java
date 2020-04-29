//Generic monster class, extend for other monsters.

package entities.monsters;

import entities.LivingEntity;

public abstract class Monster extends LivingEntity {
    private int targetX; //x-coordinate of the thing the monster is targeting
    private int targetY; //y-coordinate of the thing the monster is targeting

    //generic "get" methods
    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }
}

//Generic monster class, extend for other monsters.

package entities.monsters;

import entities.LivingEntity;

public abstract class Monster extends LivingEntity {
    private int targetX; //x-coordinate of the thing the monster is targeting
    private int targetY; //y-coordinate of the thing the monster is targeting

    //default constructor
    public Monster(int x, int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY, int hx, int hy, int hw, int hh) {
        super(x, y, maxHealth, health, movementSpeed, hx, hy, hw, hh);
        this.targetX = targetX;
        this.targetY = targetY;
    }

    //generic "get" methods
    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    //generic "set" methods
    public void setTargetX(int x) {
        this.targetX = x;
    }

    public void setTargetY(int y) {
        this.targetY = y;
    }
}

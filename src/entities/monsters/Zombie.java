package entities.monsters;

public class Zombie extends Monster {

    public static final double ZOMBIE_MAX_HEALTH = 100.0;
    public static final double ZOMBIE_MOVEMENT_SPEED = 5.0; //this number is arbitrary. Change as needed for functionality.

    //custom zombie constructor (changing default zombie values)
    public Zombie(int x, int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY) {
        super(x, y, maxHealth, health, movementSpeed, targetX, targetY);
    }

    //default zombie constructor (normal zombie default values)
    public Zombie(int x, int y, int targetX, int targetY) {
        super(x, y, ZOMBIE_MAX_HEALTH, ZOMBIE_MAX_HEALTH, ZOMBIE_MOVEMENT_SPEED, targetX, targetY);
    }

}

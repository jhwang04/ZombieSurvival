package entities.monsters;

import java.awt.*;

public class Zombie extends Monster {

    public static final double ZOMBIE_MAX_HEALTH = 100.0;
    public static final double ZOMBIE_MOVEMENT_SPEED = 5.0; //this number is arbitrary. Change as needed for functionality.
    public static final int ZOMBIE_WIDTH = 50;
    public static final int ZOMBIE_HEIGHT = 100;

    //custom zombie constructor (changing default zombie values)
    public Zombie(int x, int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY) {
        super(x, y, maxHealth, health, movementSpeed, targetX, targetY, x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
    }

    //default zombie constructor (normal zombie default values)
    public Zombie(int x, int y, int targetX, int targetY) {
        super(x, y, ZOMBIE_MAX_HEALTH, ZOMBIE_MAX_HEALTH, ZOMBIE_MOVEMENT_SPEED, targetX, targetY, x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
    }

    //Zombie draw method
    @Override
    public void draw(Graphics g) {
        //This draw() method, as I have it set up now, is going to be the zombie moving itself
        //and then drawing itself at its new position. I haven't put in any movment or other
        //functional code yet, but you can put that here.
        int randInt = (int)(Math.random() * 2);

        Color zombieColor = new Color(0, 100, 0);

        g.setColor(zombieColor);


        g.fillOval((int) this.getX() - 10, (int) this.getY() - 10, 20, 20);
    }

}

package entities.monsters;

import entities.Hitbox;
import zombiesurvivalgame.ZombieSurvivalGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Zombie extends Monster {

    public static final double ZOMBIE_MAX_HEALTH = 100.0;
    public static final double ZOMBIE_MOVEMENT_SPEED = 2.5; //this number is arbitrary. Change as needed for functionality.
    public static final int ZOMBIE_WIDTH = 50;
    public static final int ZOMBIE_HEIGHT = 100;

    //public static final Image image = (new ImageIcon("resources/zombie.png")).getImage().getScaledInstance(36, 45,Image.SCALE_SMOOTH);;


    //custom zombie constructor (changing default zombie values)
    public Zombie(int x, int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY, ZombieSurvivalGame game) {
        super(x, y, maxHealth, health, movementSpeed, targetX, targetY, game, x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
    }

    //default zombie constructor (normal zombie default values)
    public Zombie(int x, int y, int targetX, int targetY, ZombieSurvivalGame game) {
        super(x, y, ZOMBIE_MAX_HEALTH, ZOMBIE_MAX_HEALTH, ZOMBIE_MOVEMENT_SPEED, targetX, targetY, game,x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
    }

    public void move() {
        //setting the target to be the player's location
        setTargetX((int) game.getPlayer().getX());
        setTargetY((int) game.getPlayer().getY());

        int x = (int) getX();
        int y = (int) getY();

        //calculating the angle
        int changeX = getTargetX() - x;
        int changeY = y - getTargetY();

        double hypotenuse = Math.sqrt(changeX * changeX + changeY * changeY);

        if(hypotenuse != 0) {
            double refAngle = Math.asin(changeY/hypotenuse) ;
            double cosAngle = Math.acos(changeX/hypotenuse) ;

            if(cosAngle > Math.PI/2) {
                refAngle = Math.PI - refAngle;
            }

            setX(getX() + (getMovementSpeed() * Math.cos(refAngle)));
            setY(getY() - (getMovementSpeed() * Math.sin(refAngle)));
        }

        setHx(getX() - ZOMBIE_WIDTH/2);
        setHy(getY() - ZOMBIE_HEIGHT/2);
    }

    //Zombie draw method
    @Override
    public void draw(Graphics g) {
        move();
        //This draw() method, as I have it set up now, is going to be the zombie moving itself
        //and then drawing itself at its new position. I haven't put in any movment or other
        //functional code yet, but you can put that here.
        int randInt = (int)(Math.random() * 2);

        //g.drawImage(image, (int) this.getX() - 10, (int) this.getY() - 10, Color.BLACK, null);


        Color zombieColor = new Color(0, 100, 0);

        g.setColor(zombieColor);


        g.fillOval((int) this.getX() - 10, (int) this.getY() - 10, 40, 40);


    }




}

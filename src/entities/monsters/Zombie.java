/*
Justin hwang and jeremy mills
5/05/2020
Rev: 04
Notes:
  - basic class
  - Made zombies follow player
  Jeremy: Changed zombie image
  Jeremy: made zombie rotate by using the same code as Player.java
*/

package entities.monsters;

import entities.Hitbox;
import zombiesurvivalgame.ZombieSurvivalGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Zombie extends Monster {

    public static final double ZOMBIE_MAX_HEALTH = 100.0;
    public static final double ZOMBIE_MOVEMENT_SPEED = 1.5; //this number is arbitrary. Change as needed for functionality.
    public static final int ZOMBIE_WIDTH = 56;
    public static final int ZOMBIE_HEIGHT = 69;
    public static final double ZOMBIE_BASE_DAMAGE = 5.0;


    public static BufferedImage image;


    //custom zombie constructor (changing default zombie values)
    public Zombie(int x, int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY, ZombieSurvivalGame game) {
        super(x, y, maxHealth, health, movementSpeed, targetX, targetY, game, x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
        setBaseDamage(ZOMBIE_BASE_DAMAGE);
    }

    //default zombie constructor (normal zombie default values)
    public Zombie(int x, int y, int targetX, int targetY, double baseDamageIncrease, ZombieSurvivalGame game) {
        super(x, y, ZOMBIE_MAX_HEALTH, ZOMBIE_MAX_HEALTH, ZOMBIE_MOVEMENT_SPEED, targetX, targetY, game,x-ZOMBIE_WIDTH/2, y-ZOMBIE_HEIGHT/2, ZOMBIE_WIDTH, ZOMBIE_HEIGHT);
        setBaseDamage(ZOMBIE_BASE_DAMAGE + baseDamageIncrease);
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

       // g.drawImage(image, (int) this.getX() - 10, (int) this.getY() - 10, Color.BLACK, null);


        Color zombieColor = new Color(0, 100, 0);

        g.setColor(zombieColor);


        //g.fillOval((int) this.getX() - 10, (int) this.getY() - 10, 20, 20);


        //this determines the angle, in radians, that the player should be facing
        int changeX = getTargetX() - (int) getX();
        int changeY = (int) getY() - getTargetY();

        double hypotenuse = Math.sqrt(changeX * changeX + changeY * changeY);

        double refAngle = Math.PI/2;

        if(hypotenuse != 0) {
            refAngle = Math.asin(changeY/hypotenuse) ;
            double cosAngle = Math.acos(changeX/hypotenuse) ;

            if(cosAngle > Math.PI/2) {
                refAngle = Math.PI - refAngle;
            }

            setX(getX() + (getMovementSpeed() * Math.cos(refAngle)));
            setY(getY() - (getMovementSpeed() * Math.sin(refAngle)));
        }

        BufferedImage rotatedImage;
        rotatedImage = rotateImageByRadians(image, 0-refAngle + Math.PI/2);
        g.drawImage(rotatedImage, (int) getX() - rotatedImage.getWidth()/2, (int) getY() - rotatedImage.getHeight()/2, null);

    }


    public BufferedImage rotateImageByRadians(BufferedImage image, double rad) {
        int w = image.getWidth();
        int h = image.getHeight();
        double sin = Math.abs(Math.sin(rad));
        double cos = Math.abs(Math.cos(rad));
        int newWidth = (int) (w * cos + h * sin);
        int newHeight = (int) (h * cos + w * sin);

        BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = rotatedImage.createGraphics();
        AffineTransform transform = new AffineTransform();
        transform.translate((newWidth - w) / 2, (newHeight - h) / 2);
        int x = w/2;
        int y = h/2;
        transform.rotate(rad, x, y);
        g.setTransform(transform);
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return rotatedImage;
    }

    public static void setZombieImage() {
        BufferedImage originalImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB); //unused image, just to get rid of error
        try {
            originalImage = ImageIO.read(new File("resources/zombie.png"));
        } catch (IOException e) {
            //should never happen
            e.printStackTrace();
        }
        image = new BufferedImage(56, 69, BufferedImage.TYPE_INT_ARGB);
        AffineTransform t = AffineTransform.getScaleInstance(0.04, 0.04); //divides by 25
        AffineTransformOp to = new AffineTransformOp(t, AffineTransformOp.TYPE_BILINEAR);
        image = to.filter(originalImage, image);
    }

}

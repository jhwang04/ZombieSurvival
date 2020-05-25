
/*
Justin hwang and jeremy mills
4/28/2020
Rev: 07
Notes:
  - general player class, most stuff is basic get/set methods
  - Added key listener
  - Added mouse motion listener to be used for rotating the player
  Jeremy: changed image to be a player instead of a dot
  Jeremy: changed image to be a player with a gun, and no longer using a pistol image
  Jeremy: started to use AffineTransform to rotate the player, but stopped for now
  Justin: finished using AffineTransform, player now rotates
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Player extends LivingEntity implements KeyListener, MouseMotionListener {
    private int points; //number of points the player has
    private int coins; //number of coins/currency the player has
    private Ranged gun; //player's equipped ranged weapon.
    private int armorLevel; //armor level, can be increased/upgraded over time
    public BufferedImage image; //image of the player
    public BufferedImage armorImage; //camo skin
    private ZombieSurvivalGame game; //game that the player is inside of
    private int numOfKits; //the number of health kits the player has in storage

    private static final int PLAYER_HEIGHT = 69; //constant, for the default height of the player
    private static final int PLAYER_WIDTH = 56; //constant, for the default width of the player
    private static final double PLAYER_MOVEMENT_SPEED = 5.0; //how fast a default player will go

    //Directional variables, for which direction the input is telling the player to move
    private boolean movingLeft; //if player is moving left
    private boolean movingRight; //is player moving right?
    private boolean movingUp; //is player moving upwards?
    private boolean movingDown; //is player moving downwards?

    private int mouseX = 0; //x coordinate of the mouse
    private int mouseY = 0; //y coordinate of the mouse

    //default constructor
    public Player(int x, int y, double maxHealth, double health, ZombieSurvivalGame game) {
        super(x, y, maxHealth, health, PLAYER_MOVEMENT_SPEED, x - PLAYER_WIDTH/2, y-PLAYER_HEIGHT/2, PLAYER_WIDTH, PLAYER_HEIGHT);

        //player is never moving when it's first created
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;

        this.game = game;

        //this creates a scaled image, that can be rotated
        BufferedImage originalImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB); //unused image, just to get rid of error
        try {
            originalImage = ImageIO.read(new File("playergun.png"));
        } catch (IOException e) {
            //should never happen
            e.printStackTrace();
        }
        image = new BufferedImage(56, 69, BufferedImage.TYPE_INT_ARGB);
        AffineTransform t = AffineTransform.getScaleInstance(0.04, 0.04); //divides by 25
        AffineTransformOp to = new AffineTransformOp(t, AffineTransformOp.TYPE_BILINEAR);
        image = to.filter(originalImage, image);

        //creates a scaled image of the camo skin, that can be rotated
        BufferedImage originalArmorImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        try {
            originalArmorImage = ImageIO.read(new File("camoskingun.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        armorImage = new BufferedImage(56, 69, BufferedImage.TYPE_INT_ARGB);
        to = new AffineTransformOp(t, AffineTransformOp.TYPE_BILINEAR);
        armorImage = to.filter(originalArmorImage, armorImage);
    }

    //this is called by the draw method, to determine where the player should be drawn
    private void move() {
        double oldX = getX();
        double oldY = getY();

        int leftRightDir = 0; //0 = no movement. 1 = left. 2 = right
        int upDownDir = 0; //0 = no movement. 1 = up. 2 = down.

        if(movingLeft == true && movingRight == false) {
            leftRightDir = 1;
        } else if(movingLeft == false && movingRight == true) {
            leftRightDir = 2;
        }
        //if neither, or both, no left/right movement

        if(movingUp == true && movingDown == false) {
            upDownDir = 1;
        } else if(movingUp == false && movingDown == true) {
            upDownDir = 2;
        }
        //if neither, or both, no up/down movement

        //System.out.println("leftRightDir = " + leftRightDir + ", upDownDir = " + upDownDir);

        //cardinal directions
        if(upDownDir == 1 && leftRightDir == 0) { //up
            setY(getY() - getMovementSpeed());
        } else if(upDownDir == 2 && leftRightDir == 0) { //down
            setY(getY() + getMovementSpeed());
        } else if(upDownDir == 0 && leftRightDir == 1) { //left
            setX(getX() - getMovementSpeed());
        } else if(upDownDir == 0 && leftRightDir == 2) { //right
            setX(getX() + getMovementSpeed());
        }

        //secondary directions (complicated math because trig ok leave me alone)
        double diagonalX = getMovementSpeed() * (Math.cos(45 * Math.PI/180));
        double diagonalY = getMovementSpeed() * (Math.sin(45 * Math.PI/180));

        if(upDownDir == 1 && leftRightDir == 1) { //up and left
            setX(getX() - diagonalX);
            setY(getY() - diagonalY);
        } else if(upDownDir == 1 && leftRightDir == 2) { //up and right
            setX(getX() + diagonalX);
            setY(getY() - diagonalY);
        } else if(upDownDir == 2 && leftRightDir == 2) { //down and right
            setX(getX() + diagonalX);
            setY(getY() + diagonalY);
        } else if(upDownDir == 2 && leftRightDir == 1) { //down and left
            setX(getX() - diagonalX);
            setY(getY() + diagonalY);
        }

        //prevent player from leaving the screen
        if(getX() > 1000 - getHw()/2) {
            setX(1000 - getHw()/2);
        }
        if(getY() > 900 - getHh()/2) {
            setY(900 - getHh()/2);
        }
        if(getX() < getHw()/2) {
            setX(getHw() / 2);
        }
        if(getY() < getHh()/2) {
            setY(getHh()/2);
        }
    }

    //draws the player
    @Override
    public void draw(Graphics g) {
        //every time draw() is called, the move() method determines where it should be
        //as of now, the move() method is not called from outside this class, it's only
        //called whenever the player is redrawn
        move();

        //sets the hitbox coordinates to be at the new coordinates
        setHx(getX()-PLAYER_WIDTH/2);
        setHy(getY()-PLAYER_HEIGHT/2);

        //this determines the angle, in radians, that the player should be facing
        int changeX = mouseX - (int) getX();
        int changeY = (int) getY() - mouseY;

        double hypotenuse = Math.sqrt(changeX * changeX + changeY * changeY);

        double refAngle = Math.PI/2;

        if(hypotenuse != 0) {
            refAngle = Math.asin(changeY/hypotenuse) ;
            double cosAngle = Math.acos(changeX/hypotenuse) ;

            if(cosAngle > Math.PI/2) {
                refAngle = Math.PI - refAngle;
            }
        }

        //this rotates the image
        BufferedImage rotatedImage;
        if(armorLevel <= 4) {
            rotatedImage = rotateImageByRadians(image, 0-refAngle + Math.PI/2);
        } else {
            rotatedImage = rotateImageByRadians(armorImage, 0-refAngle + Math.PI/2);
        }
        g.drawImage(rotatedImage, (int) getX() - rotatedImage.getWidth()/2, (int) getY() - rotatedImage.getHeight()/2, null);

        //sets the gun x and y to be the player's
        if(gun != null) {
            gun.setX((int) getX());
            gun.setY((int) getY());
        }
    }

    //generic "get" commands
    //gets the player's number of points
    public int getPoints() {
        return points;
    }

    //gets the player's number of coins
    public int getCoins() {
        return coins;
    }

    //gets the player's gun
    public Ranged getGun() { return gun; }

    //gets the player's armor level
    public int getArmorLevel() { return armorLevel; }

    //gets the number of health kits the player has (not used)
    public int getNumOfKits() {return numOfKits; }

    //"set" methods
    //sets the number of points
    public void setPoints(int points) {
        this.points = points;
    }

    //sets the number of coins the player has
    public void setCoins(int coins) {
        this.coins = coins;
    }

    //adds a certain number to the current number of points
    public void addPoints(int amount) {
        this.points += amount;
    }

    //adds some coins to the current amount
    public void addCoins(int amount) {
        this.coins += amount;
    }

    //sets the player gun to be a new gun
    public void setGun(Ranged gun) {
        this.gun = gun;
    }

    //sets the number of health kits the player has
    public void setNumOfKits(int i) {
        numOfKits = i;
    }

    //sets the player's armor level
    public void setArmorLevel(int i) {
        armorLevel = i;
    }

    //increases the player's armor level by one
    public void increaseArmorLevel() {
        armorLevel += 1;
    }

    //increases the number of health kits the player has
    public void increaseNumOfKits() {
        numOfKits += 1;
    }

    //resets the player image (not used)
    public void resetImage() throws IOException { image = ImageIO.read(new File("playergun.png")); }

    //stops all player movement
    public void stopMoving() {
        // this will halt all movement.
        // This is used when the screen is paused, or the wave is over,
        // and the key is never released while the player class is listening.
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
    }


    //These are taking key input in order to move the player.
    //I have to set a true/false flag because the keys themselves have a weird delay
    //We have more control this way, than just using the keyPressed event to move the player directly
    @Override
    public void keyTyped(KeyEvent e) {
        //not used
    }

    //called when the key is pressed down for the first time
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();


        switch(keyCode) {
            case KeyEvent.VK_W :
                this.movingUp = true;
                break;
            case KeyEvent.VK_A:
                this.movingLeft = true;
                break;
            case KeyEvent.VK_D:
                this.movingRight = true;
                break;
            case KeyEvent.VK_S:
                this.movingDown = true;
                break;
            default:
                //do nothing, if it's not a meaningful input
                break;
        }
    }

    //called when the key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_W:
                movingUp = false;
                break;
            case KeyEvent.VK_A:
                movingLeft = false;
                break;
            case KeyEvent.VK_S:
                movingDown = false;
                break;
            case KeyEvent.VK_D:
                movingRight = false;
                break;
            case KeyEvent.VK_ESCAPE:
                movingRight = false;
                movingLeft = false;
                movingUp = false;
                movingDown = false;
                game.changeScreen(ZombieSurvivalGame.PAUSE_SCREEN);
            default:
                //do nothing, if it's not a meaningful input
                break;
        }
    }

    //called when the mouse is pressed and then moved
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    //called when the mouse is moved
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    //uses affine transform to rotate the image by some number of radians
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
}

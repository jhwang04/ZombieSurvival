
/*
Savannah Bananas
4/28/2020
This is the class of the main character that the user controls.
*/

package entities.friendlyEntities;

import entities.LivingEntity;
import weapons.Ranged;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends LivingEntity implements KeyListener {
    private int points; //number of points the player has
    private int coins; //number of coins/currency the player has
    private Ranged gun; //player's equipped ranged weapon.

    private static final int PLAYER_HEIGHT = 100; //constant, for the default height of the player
    private static final int PLAYER_WIDTH = 50; //constant, for the default width of the player
    private static final double PLAYER_MOVEMENT_SPEED = 5.0;

    //Directional variables, for which direction the input is telling the player to move
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public Player(int x, int y, double maxHealth, double health) {
        super(x, y, maxHealth, health, PLAYER_MOVEMENT_SPEED, x - PLAYER_WIDTH/2, y-PLAYER_HEIGHT/2, PLAYER_WIDTH, PLAYER_HEIGHT);
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;
    }

    //this is called by the draw method, to determine where the player should be drawn
    private void move() {
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
    }

    @Override
    public void draw(Graphics g) {
        move();

        setHx(getX()-PLAYER_WIDTH/2);
        setHy(getY()-PLAYER_HEIGHT/2);

        g.setColor(Color.BLACK);
        g.fillOval((int) this.getX() - 10, (int) this.getY() - 10, 20, 20);

        //temporary dot, showing where the true x and y coords are
        g.setColor(Color.RED);
        g.fillOval((int) getX()-1, (int) getY()-1, 3, 3);

        if(gun != null) {
            gun.setX((int) getX());
            gun.setY((int) getY());
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



    //These are taking key input in order to move the player.
    //I have to set a true/false flag because the keys themselves have a weird delay
    //We have more control this way, than just using the keyPressed event to move the player directly
    @Override
    public void keyTyped(KeyEvent e) {
        //not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_W:
                this.movingUp = true;
                break;
            case KeyEvent.VK_A:
                this.movingLeft = true;
                break;
            case KeyEvent.VK_S:
                this.movingDown = true;
                break;
            case KeyEvent.VK_D:
                this.movingRight = true;
            default:
                //do nothing, if it's not a meaningful input
                break;
        }
    }

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
            default:
                //do nothing, if it's not a meaningful input
                break;
        }
    }
}

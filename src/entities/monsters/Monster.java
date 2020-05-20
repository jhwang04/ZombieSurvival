/*
justin hwang and jeremy mills
4/28/2020
Rev: 03
Notes:
  - basic class
  Jeremy: added base damage
  Jeremy: added targetx and targetY for motion
 */
package entities.monsters;

import entities.LivingEntity;
import zombiesurvivalgame.ZombieSurvivalGame;

public abstract class Monster extends LivingEntity {
    private int targetX; //x-coordinate of the thing the monster is targeting
    private int targetY; //y-coordinate of the thing the monster is targeting
    private double baseDamage;
    public ZombieSurvivalGame game;

    //default constructor
    public Monster(int x,int y, double maxHealth, double health, double movementSpeed, int targetX, int targetY, ZombieSurvivalGame game, int hx, int hy, int hw, int hh) {
        super(x, y, maxHealth, health, movementSpeed, hx, hy, hw, hh);
        this.targetX = targetX;
        this.targetY = targetY;
        this.game = game;
    }

    /*
    public void getTarget() {
        int leg1 = this.getX()- ZombieSurvivalGame.player.getX();
        int leg2 = this.getY()- ZombieSurvivalGame.player.getY();
        double hyp = Math.sqrt((double)(leg1^2 * leg2^2));
    }

     */

    //generic "get" methods
    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public double getBaseDamage() {return baseDamage;}

    //generic "set" methods
    public void setTargetX(int x) {
        this.targetX = x;
    }

    public void setTargetY(int y) {
        this.targetY = y;
    }

    public void setBaseDamage(double x) {this.baseDamage = x;}
}

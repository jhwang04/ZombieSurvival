/*
justin hwang and jeremy mills
4/28/2020
Rev: 03
Notes:
  - basic class
  Jeremy: added base damage
  Jeremy: added targetx and targetY for motion
 */


public abstract class Monster extends LivingEntity {
    private int targetX; //x-coordinate of the thing the monster is targeting
    private int targetY; //y-coordinate of the thing the monster is targeting
    private double baseDamage; //base damage of the monster
    public ZombieSurvivalGame game; //game that the monster is inside of

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
    //gets the x coordinate of its target
    public int getTargetX() {
        return targetX;
    }

    //gets the y coordinate of its target
    public int getTargetY() {
        return targetY;
    }

    //gets the base damage that the monster does
    public double getBaseDamage() {return baseDamage;}

    //generic "set" methods
    //sets the x coordinate it's targeting
    public void setTargetX(int x) {
        this.targetX = x;
    }

    //sets the y coordinate it's targeting
    public void setTargetY(int y) {
        this.targetY = y;
    }

    //sets the base damage the monster does
    public void setBaseDamage(double x) {this.baseDamage = x;}
}

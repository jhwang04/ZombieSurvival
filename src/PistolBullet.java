/*
Justin hwang
5/22/2020
Rev: 02
Notes: Added static final constants
 */


import java.awt.*;

public class PistolBullet extends Projectile {
    public static final double PISTOL_BULLET_SPEED = 10.0; //speed a pistol bullet will go at
    public static final double PISTOL_BULLET_DAMAGE = 35.0; // damage a pistol bullet will do
    public static final int PISTOL_RANGE = 500; //range the pistol bullet will go
    public static final int PISTOL_BULLET_WIDTH = 20; //width of the pistol bullet
    public static final int PISTOL_BULLET_HEIGHT = 20; //height of the bullet
    public static final Image PISTOL_BULLET_IMAGE = null; //image of the bullet (not used)

    //creates a new projectile
    public PistolBullet(int x, int y, double trajectory, ZombieSurvivalGame game) {
        super(x, y, PISTOL_BULLET_SPEED, PISTOL_BULLET_DAMAGE, PISTOL_RANGE, PISTOL_BULLET_IMAGE, trajectory, game, x - PISTOL_BULLET_WIDTH/2, y - PISTOL_BULLET_HEIGHT/2, PISTOL_BULLET_WIDTH, PISTOL_BULLET_HEIGHT);
    }
}

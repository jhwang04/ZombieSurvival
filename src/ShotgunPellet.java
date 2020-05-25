import java.awt.*;

/*
Rishi Zamvar
5/20/2020
Rev: 02
Notes: Changed values to work for shotgun
 */

public class ShotgunPellet extends Projectile {
    public static final double SHOTGUN_BULLET_SPEED = 10.0; //speed of shotgun bullet
    public static final double SHOTGUN_BULLET_DAMAGE = 20; //damage of shotgun bullet
    public static final int SHOTGUN_RANGE = 250; //range of shotgun bullet
    public static final int SHOTGUN_BULLET_WIDTH = 20; //width of shotgun bullet
    public static final int SHOTGUN_BULLET_HEIGHT = 20; //height of shotgun bullet
    public static final Image SHOTGUN_BULLET_IMAGE = null;//image of the shotgun pellet

    //default constructor, calls the Projectile.java constructor
    public ShotgunPellet(int x, int y, double trajectory, ZombieSurvivalGame game) {
        super(x, y, SHOTGUN_BULLET_SPEED, SHOTGUN_BULLET_DAMAGE, SHOTGUN_RANGE, SHOTGUN_BULLET_IMAGE, trajectory, game, x - SHOTGUN_BULLET_WIDTH/2, y - SHOTGUN_BULLET_HEIGHT/2, SHOTGUN_BULLET_WIDTH, SHOTGUN_BULLET_HEIGHT);
    }
}
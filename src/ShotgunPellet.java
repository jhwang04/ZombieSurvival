import java.awt.*;

/*
Rishi Zamvar
5/20/2020
Rev: 02
Notes: Changed values to work for shotgun
 */

public class ShotgunPellet extends Projectile {
    public static final double SHOTGUN_BULLET_SPEED = 10.0; //placeholder value, is arbitrary
    public static final double SHOTGUN_BULLET_DAMAGE = 20;
    public static final int SHOTGUN_RANGE = 250;
    public static final int SHOTGUN_BULLET_WIDTH = 20;
    public static final int SHOTGUN_BULLET_HEIGHT = 20;
    public static final Image SHOTGUN_BULLET_IMAGE = null;

    public ShotgunPellet(int x, int y, double trajectory, ZombieSurvivalGame game) {
        super(x, y, SHOTGUN_BULLET_SPEED, SHOTGUN_BULLET_DAMAGE, SHOTGUN_RANGE, SHOTGUN_BULLET_IMAGE, trajectory, game, x - SHOTGUN_BULLET_WIDTH/2, y - SHOTGUN_BULLET_HEIGHT/2, SHOTGUN_BULLET_WIDTH, SHOTGUN_BULLET_HEIGHT);
    }
}
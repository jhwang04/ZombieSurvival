package weapons.projectiles;

import zombiesurvivalgame.ZombieSurvivalGame;

import java.awt.*;

public class ShotgunPellet extends Projectile {
    public static final double PISTOL_BULLET_SPEED = 10.0; //placeholder value, is arbitrary
    public static final double PISTOL_BULLET_DAMAGE = 20;
    public static final int PISTOL_RANGE = 250;
    public static final int PISTOL_BULLET_WIDTH = 20;
    public static final int PISTOL_BULLET_HEIGHT = 20;
    public static final Image PISTOL_BULLET_IMAGE = null;

    public ShotgunPellet(int x, int y, double trajectory, ZombieSurvivalGame game) {
        super(x, y, PISTOL_BULLET_SPEED, PISTOL_BULLET_DAMAGE, PISTOL_RANGE, PISTOL_BULLET_IMAGE, trajectory, game, x - PISTOL_BULLET_WIDTH/2, y - PISTOL_BULLET_HEIGHT/2, PISTOL_BULLET_WIDTH, PISTOL_BULLET_HEIGHT);
    }
}

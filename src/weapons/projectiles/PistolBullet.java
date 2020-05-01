package weapons.projectiles;

import java.awt.*;

public class PistolBullet extends Projectile {
    public static final double PISTOL_BULLET_SPEED = 10.0; //placeholder value, is arbitrary
    public static final double PISTOL_BULLET_DAMAGE = 5.0;
    public static final int PISTOL_RANGE = 500;

    public PistolBullet(int x, int y, Image image, double trajectory) {
        super(x, y, PISTOL_BULLET_SPEED, PISTOL_BULLET_DAMAGE, PISTOL_RANGE, image, trajectory);
    }
}

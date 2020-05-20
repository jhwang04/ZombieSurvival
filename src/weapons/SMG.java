package weapons;

import weapons.projectiles.PistolBullet;
import zombiesurvivalgame.ZombieSurvivalGame;

import javax.swing.*;
import java.awt.*;

public class SMG extends Ranged  {

    public static final Image PLACEHOLDER_PISTOL_IMAGE = (new ImageIcon("pistol.png")).getImage();

    public SMG(int x, int y, ZombieSurvivalGame game) {
        super(x, y, PLACEHOLDER_PISTOL_IMAGE, game);
    }

    public void shoot(double angle) {
        PistolBullet bullet = new PistolBullet(getX(), getY(), angle, this.game);
        game.appendBullet(bullet);
        game.appendBullet(bullet);
        game.appendBullet(bullet);
        game.appendBullet(bullet);
    }

}

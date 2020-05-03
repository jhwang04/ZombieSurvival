package weapons;

import weapons.projectiles.PistolBullet;
import weapons.projectiles.Projectile;
import zombiesurvivalgame.ZombieSurvivalGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Pistol extends Ranged {

    public static final Image PLACEHOLDER_PISTOL_IMAGE = (new ImageIcon("pistol.png")).getImage();

    //default constructor
    public Pistol(int x, int y, ZombieSurvivalGame game) {
        super(x, y, PLACEHOLDER_PISTOL_IMAGE, game);
    }

    @Override
    public void shoot(double angle) {
        PistolBullet bullet = new PistolBullet(getX(), getY(), angle, this.game);
        game.appendBullet(bullet);
    }

}

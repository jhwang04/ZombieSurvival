package weapons;

import weapons.projectiles.PistolBullet;
import weapons.projectiles.ShotgunPellet;
import zombiesurvivalgame.ZombieSurvivalGame;

import javax.swing.*;
import java.awt.*;

public class Shotgun extends Ranged  {

    public static final Image PLACEHOLDER_PISTOL_IMAGE = (new ImageIcon("pistol.png")).getImage();

    public Shotgun(int x, int y, ZombieSurvivalGame game)
    {
        super(x, y, PLACEHOLDER_PISTOL_IMAGE, game);
    }

    public void shoot(double angle) {
        ShotgunPellet bullet1 = new ShotgunPellet(getX(), getY(), angle-0.125, this.game);
        ShotgunPellet bullet2 = new ShotgunPellet(getX(), getY(), angle-0.25, this.game);
        ShotgunPellet bullet3 = new ShotgunPellet(getX(), getY(), angle, this.game);
        ShotgunPellet bullet4 = new ShotgunPellet(getX(), getY(), angle+0.125, this.game);
        ShotgunPellet bullet5 = new ShotgunPellet(getX(), getY(), angle+.25, this.game);
        game.appendBullet(bullet1);
        game.appendBullet(bullet2);
        game.appendBullet(bullet3);
        game.appendBullet(bullet4);
        game.appendBullet(bullet5);
    }

}

/*
Rishi Zamvar
5/20/2020
Rev: 02
Notes: Added new gun class
 */

import javax.swing.*;
import java.awt.*;

public class Shotgun extends Ranged  {

    //placeholder image, not used
    public static final Image PLACEHOLDER_PISTOL_IMAGE = (new ImageIcon("pistol.png")).getImage();

    //default constructor
    public Shotgun(int x, int y, ZombieSurvivalGame game)
    {
        super(x, y, PLACEHOLDER_PISTOL_IMAGE, game);
    }

    //overrides the Ranged shoot() method
    public void shoot(double angle) {
        //creates several shotgun pellets with slightly different angles
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
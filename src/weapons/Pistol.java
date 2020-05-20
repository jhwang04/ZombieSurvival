/*
Justin Hwang and Jeremy Mills
5/19/2020
Rev: 03
Notes:
  - Added basic function
  Jeremy: Changed how shoot function interacts with Ranged class
  Jeremy: Removed use of Placeholder pistol image, it's no longer needed
 */

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

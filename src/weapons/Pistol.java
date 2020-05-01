package weapons;

import weapons.projectiles.Projectile;

import javax.swing.*;
import java.awt.*;

public class Pistol extends Ranged {

    public static final Image PLACEHOLDER_PISTOL_IMAGE = (new ImageIcon("pistol.png")).getImage();

    //default constructor
    public Pistol(int x, int y) {
        super(x, y, PLACEHOLDER_PISTOL_IMAGE);
    }

}

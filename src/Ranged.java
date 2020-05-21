/*
jeremy and justin
5/13/2020
rev: 04
Notes:
  - Generic abstract ranged weapon class. Extend for pistol, rifle, etc.
  - added the mouse listener to listen to clicks
 */

package weapons;

import entities.monsters.Zombie;
import zombiesurvivalgame.ZombieSurvivalGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ranged implements MouseListener {
    private int x; //x coordinate of the weapon itself
    private int y; //y coordinate of the weapon itself
    private Image weaponImage; //picture of the weapon itself. If we're doing animations, you're gonna have to change the whole image system.
    public ZombieSurvivalGame game;


    //default contructor
    public Ranged(int x, int y, Image image, ZombieSurvivalGame game) {
        this.x = x;
        this.y = y;
        this.weaponImage = image;
        this.game = game;


    }

    //useful methods
    public void shoot(double angle) {
        //placeholder, change anything you'd like
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY() - 32;

        int changeX = mouseX - x;
        int changeY = y - mouseY;

        double hypotenuse = Math.sqrt(changeX * changeX + changeY * changeY);

        double refAngle = Math.PI/2;

        if(hypotenuse != 0) {
            refAngle = Math.asin(changeY/hypotenuse) ;
            double cosAngle = Math.acos(changeX/hypotenuse) ;

            if(cosAngle > Math.PI/2) {
                refAngle = Math.PI - refAngle;
            }
        }

        shoot(refAngle);
    }

    public void draw(Graphics g) {
        int width = weaponImage.getWidth(null);
        int height = weaponImage.getHeight(null);
        g.drawImage(weaponImage, x - width/2, y - height/2, null);

        g.setColor(Color.RED);
        g.fillOval(x - 1, y-1, 3, 3);
    }

    //generic "get" methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getWeaponImage() {
        return weaponImage;
    }

    //generic "set" methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWeaponImage(Image image) {
        this.weaponImage = image;
    }


    //not used

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

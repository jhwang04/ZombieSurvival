/*
Justin Hwang and Jeremy Mills
5/19/2020
Rev: 07
Notes:
  - Added armor and health kit icons to the screen
  Jeremy: Added explanation of armor to the screen
 */

package zombiesurvivalgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HelpScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;
    private static Image healthKitImage = (new ImageIcon("resources/medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private static Image armorKitImage = (new ImageIcon("resources/vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH);

    private Button menuButton;


    public HelpScreen(ZombieSurvivalGame game) {
        this.game = game;
        menuButton = new Button(250, 750, 500, 150, Color.BLUE, Color.RED);
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        menuButton.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact", Font.PLAIN, 40));

        g.drawString("Move with the W, A, S and D keys.", 100, 160);
        g.drawString("Use the mouse to aim, and left click to shoot.", 100, 240);
        g.drawString("Watch out for zombies!", 100, 320);
        g.drawString("This is a health kit, for +15 health.", 100, 400);
        g.drawString("This is an armor kit, for +1 armor each.", 100, 480);
        g.drawString("If you get 5 armor, you get a new outfit!", 100, 560);
        g.drawString("You can pause at any time with the ESC key.", 100, 640);
        g.drawString("Zombies do more damage as time goes on.", 100, 720);

        g.drawImage(healthKitImage, 30, 360, null);
        g.fillRect(20, 435, 60, 60);
        g.drawImage(armorKitImage, 30, 445, null);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Main Menu", 330, 850);
        g.drawString("How to play", 310, 100);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        menuButton.setPressed(false);
        menuButton.setHovered(false);
        if(menuButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.START_SCREEN);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(menuButton.isTouchedBy(mouseX, mouseY)) {
            menuButton.setHovered(true);
            if(isMousePressed == true) {
                menuButton.setPressed(true);
            }
        } else {
            menuButton.setHovered(false);
            menuButton.setPressed(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        if(menuButton.isTouchedBy(mouseX, mouseY)) {
            menuButton.setPressed(true);
        } else {
            menuButton.setPressed(false);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }




    //not used
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

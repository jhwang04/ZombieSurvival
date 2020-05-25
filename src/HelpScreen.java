/*
Justin Hwang and Jeremy Mills
5/19/2020
Rev: 07
Notes:
  - Added armor and health kit icons to the screen
  Jeremy: Added explanation of armor to the screen
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HelpScreen implements MouseMotionListener, MouseListener {
    private int mouseX; //x coord of the mouse
    private int mouseY; //y coord of the mouse
    private boolean isMousePressed; //is the mouse pressed?
    private ZombieSurvivalGame game; //game that the helpscreen is a part of
    private static Image healthKitImage = (new ImageIcon("medKit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); //picture of the healthkit
    private static Image armorKitImage = (new ImageIcon("vestIcon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH); //picture of the armor

    private Button menuButton; //"back to main menu" button


    //default constructor
    public HelpScreen(ZombieSurvivalGame game) {
        this.game = game;
        menuButton = new Button(250, 750, 500, 150, Color.BLUE, Color.RED);
    }

    //draws the whole screen
    public void draw(Graphics g) {
        //background (black)
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        //draws the menu button
        menuButton.draw(g);

        //draws all the text on the screen
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

        //draws the healthkit and armor icons next to the correct lines
        g.drawImage(healthKitImage, 30, 360, null);
        g.fillRect(20, 435, 60, 60);
        g.drawImage(armorKitImage, 30, 445, null);

        //draws the text on the button
        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Main Menu", 330, 850);
        g.drawString("How to play", 310, 100);

    }

    //called when the mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        menuButton.setPressed(false);
        menuButton.setHovered(false);
        if(menuButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.START_SCREEN);
        }
    }

    //called when the mouse is moved
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

    //called when the mouse is pressed down
    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        if(menuButton.isTouchedBy(mouseX, mouseY)) {
            menuButton.setPressed(true);
        } else {
            menuButton.setPressed(false);
        }
    }


    //called when the mouse is pressed, and then moved
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

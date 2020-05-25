/*
Justin Hwang
05/29/2020
Rev: 02
Notes: Added the bar with the player health at the bottom of the window.
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameOverScreen implements MouseMotionListener, MouseListener {
    private int mouseX; //x coord of the mouse
    private int mouseY; //y coord of the mouse
    private boolean isMousePressed; //if the mouse is pressed, this is true
    private ZombieSurvivalGame game; //the game that the screen is a part of

    private Button menuButton; //main menu button


    //default constructor
    public GameOverScreen(ZombieSurvivalGame game) {
        this.game = game;
        menuButton = new Button(250, 600, 500, 150, Color.BLUE, Color.RED);
    }

    //draws the button
    public void draw(Graphics g) {
        game.gameOver(g);

        menuButton.draw(g);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Main Menu", 330, 700);

        game.drawHUD(g);
    }

    //called when mouse button is released
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


    //called when the mouse is pressed down and then moved
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

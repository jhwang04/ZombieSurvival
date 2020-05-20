/*
Justin Hwang
05/29/2020
Rev: 02
Notes: Added the bar with the player health at the bottom of the window.
 */

package zombiesurvivalgame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameOverScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;

    private Button menuButton;


    public GameOverScreen(ZombieSurvivalGame game) {
        this.game = game;
        menuButton = new Button(250, 600, 500, 150, Color.BLUE, Color.RED);
    }


    public void draw(Graphics g) {
        game.gameOver(g);

        menuButton.draw(g);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Main Menu", 330, 700);

        game.drawHUD(g);
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

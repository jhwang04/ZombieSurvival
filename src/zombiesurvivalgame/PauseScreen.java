/*
Justin Hwang
5/19/2020
Rev: 03
Notes:
  - Added basic function
  - Changed buttons to change color when hovered
 */

package zombiesurvivalgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PauseScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;

    private Button resumeButton;
    private Button menuButton;


    public PauseScreen(ZombieSurvivalGame game) {
        this.game = game;
        resumeButton = new Button(250, 400, 500, 150, Color.BLUE, Color.RED);
        menuButton = new Button(250, 600, 500, 150, Color.BLUE, Color.RED);
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        resumeButton.draw(g);
        menuButton.draw(g);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Continue", 350, 500);
        g.drawString("Game Paused", 290, 100);
        g.drawString("Main Menu", 340, 700);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        resumeButton.setPressed(false);
        resumeButton.setHovered(false);
        menuButton.setPressed(false);
        menuButton.setHovered(false);
        if(resumeButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(ZombieSurvivalGame.GAME_SCREEN);
        } else if(menuButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(ZombieSurvivalGame.START_SCREEN);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(resumeButton.isTouchedBy(mouseX, mouseY)) {
            resumeButton.setHovered(true);
            if(isMousePressed == true) {
                resumeButton.setPressed(true);
            }
        } else {
            resumeButton.setHovered(false);
            resumeButton.setPressed(false);
        }

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
        if(resumeButton.isTouchedBy(mouseX, mouseY)) {
            resumeButton.setPressed(true);
        } else {
            resumeButton.setPressed(false);
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

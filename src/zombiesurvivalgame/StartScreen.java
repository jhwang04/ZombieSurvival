/*
Justin Hwang and Jeremy Mills
5/19/2020
Rev: 06
Notes:
  - Added a start button
  - Added a how to play button
  - Added an exit button
  - Added savannah bananas logo in the bottom left
  - Renamed Exit to "Quit Program"
 */

package zombiesurvivalgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StartScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;
    private static Image banana = (new ImageIcon("resources/savannahbananas.png")).getImage().getScaledInstance(126, 161,Image.SCALE_SMOOTH);

    private Button startButton;
    private Button helpButton;
    private Button quitButton;


    public StartScreen(ZombieSurvivalGame game) {
        this.game = game;
        this.startButton = new Button(250, 300, 500, 150, Color.BLUE, Color.RED);
        this.helpButton = new Button(250, 500, 500, 150, Color.BLUE, Color.RED);
        this.quitButton = new Button(250, 700, 500, 150, Color.BLUE, Color.RED);
        isMousePressed = false;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        g.setFont(new Font("Impact", Font.BOLD, 100));
        g.setColor(Color.WHITE);
        g.drawString("ZombieSurvival", 160, 175);
        g.drawImage(banana, 0, 839, null);
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        g.drawString("By the SavannahBananas", 150, 980);

        startButton.draw(g);
        helpButton.draw(g);
        quitButton.draw(g);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Start Game", 330, 400);
        g.drawString("How to play", 320, 600);
        g.drawString("Stop Program", 280, 800);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;

        helpButton.setPressed(false);
        startButton.setPressed(false);
        quitButton.setPressed(false);
        helpButton.setHovered(false);
        startButton.setHovered(false);
        quitButton.setHovered(false);

        if(startButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.GAME_SCREEN);
        }

        if(helpButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.HOW_TO_PLAY_SCREEN);
        }

        if(quitButton.isTouchedBy(mouseX, mouseY)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(startButton.isTouchedBy(mouseX, mouseY)) {
            startButton.setHovered(true);
            if(isMousePressed == true) {
                startButton.setPressed(true);
            }
        } else {
            startButton.setHovered(false);
            startButton.setPressed(false);
        }

        if(helpButton.isTouchedBy(mouseX, mouseY)) {
            helpButton.setHovered(true);
            if(isMousePressed == true) {
                helpButton.setPressed(true);
            }
        } else {
            helpButton.setHovered(false);
            helpButton.setPressed(false);
        }

        if(quitButton.isTouchedBy(mouseX, mouseY)) {
            quitButton.setHovered(true);
            if(isMousePressed == true) {
                quitButton.setPressed(true);
            }
        } else {
            quitButton.setHovered(false);
            quitButton.setPressed(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        if(startButton.isTouchedBy(mouseX, mouseY)) {
            startButton.setPressed(true);
        } else {
            startButton.setPressed(false);
        }

        if(helpButton.isTouchedBy(mouseX, mouseY)) {
            helpButton.setPressed(true);
        } else {
            helpButton.setPressed(false);
        }

        if(quitButton.isTouchedBy(mouseX, mouseY)) {
            quitButton.setPressed(true);
        } else {
            quitButton.setPressed(false);
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

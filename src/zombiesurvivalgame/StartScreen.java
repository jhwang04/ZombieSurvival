package zombiesurvivalgame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StartScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;

    private Button startButton;

    private Button helpButton;

    public StartScreen(ZombieSurvivalGame game) {
        this.game = game;
        this.startButton = new Button(250, 400, 500, 150, Color.BLUE, Color.RED);
        this.helpButton = new Button(250, 600, 500, 150, Color.BLUE, Color.RED);
        isMousePressed = false;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        g.setFont(new Font("Impact", Font.BOLD, 100));
        g.setColor(Color.WHITE);
        g.drawString("ZombieSurvival", 200, 175);

        startButton.draw(g);
        helpButton.draw(g);

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);
        g.drawString("Start Game", 330, 500);
        g.drawString("How to play", 320, 700);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;

        helpButton.setPressed(false);
        startButton.setPressed(false);
        helpButton.setHovered(false);
        startButton.setHovered(false);

        if(startButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.GAME_SCREEN);
        }

        if(helpButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(game.HOW_TO_PLAY_SCREEN);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY() - 32;

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

package zombiesurvivalgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WaveCompleteScreen implements MouseMotionListener, MouseListener {
    private int mouseX;
    private int mouseY;
    private boolean isMousePressed;
    private ZombieSurvivalGame game;
    private Button nextWaveButton;


    public WaveCompleteScreen(ZombieSurvivalGame game) {
        this.game = game;
        nextWaveButton = new Button(250, 700, 500, 150, Color.BLUE, Color.RED);
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        nextWaveButton.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Impact", Font.PLAIN, 30));


        String text = "";
        text = text + "Wave " + (game.getWave()-1) + " completed.\n";
        text = text + "You now have " + game.getPlayer().getPoints() + " points.\n";
        text = text + "You now have " + game.getPlayer().getCoins() + " coins.\n";
        text = text + "Wave " + game.getWave() + " will have " + game.getMonsterCount() + " zombies.\n";
        text = text + "Wave " + game.getWave() + " zombies will do " + game.monsters[0].getBaseDamage() + " damage.\n";
        text = text + "Your armor level of " + game.getPlayer().getArmorLevel() + " will protect you from " + (game.getPlayer().getArmorLevel()*10) + "% of damage.\n";

        //g.drawString(text, 100, 150);

        int lineNumber = 0;
        while(text.contains("\n")) {
            String line = text.substring(0, text.indexOf("\n"));
            text = text.substring(text.indexOf("\n")+1);
            g.drawString(line, 100, 150 + (80 * lineNumber));
            lineNumber++;
        }

        g.setFont(new Font("Impact", Font.BOLD, 70));
        g.setColor(Color.WHITE);

        //every "next wave" screen during the game
        g.drawString("Wave Complete", 250, 100);
        g.drawString("Next Wave", 330, 800);


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        nextWaveButton.setPressed(false);
        nextWaveButton.setHovered(false);
        if(nextWaveButton.isTouchedBy(mouseX, mouseY)) {
            game.changeScreen(ZombieSurvivalGame.GAME_SCREEN);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(nextWaveButton.isTouchedBy(mouseX, mouseY)) {
            nextWaveButton.setHovered(true);
            if(isMousePressed == true) {
                nextWaveButton.setPressed(true);
            }
        } else {
            nextWaveButton.setHovered(false);
            nextWaveButton.setPressed(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        if(nextWaveButton.isTouchedBy(mouseX, mouseY)) {
            nextWaveButton.setPressed(true);
        } else {
            nextWaveButton.setPressed(false);
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

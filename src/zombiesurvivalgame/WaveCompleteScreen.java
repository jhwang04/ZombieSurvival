/*
Justin Hwang and Jeremy Mills
5/19/2020
Rev: 04
Notes:
  - Made bare-bones class
  - Changed button color when hovered
  Jeremy: Added explanation of armor
  Jeremy: Changed how the text is displayed
 */

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
    //private Button useHealthKitButton;
    private int ticksOnScreen;


    public WaveCompleteScreen(ZombieSurvivalGame game) {
        this.game = game;
        nextWaveButton = new Button(250, 700, 500, 150, Color.BLUE, Color.RED);
        nextWaveButton.setEnabled(false);
        //useHealthKitButton = new Button(700, 700, 250, 100, Color.BLUE, Color.RED);
        //useHealthKitButton.setEnabled(false);
    }


    public void draw(Graphics g) {
        ticksOnScreen++;
        if(ticksOnScreen >= 100) {
            nextWaveButton.setEnabled(true);
        } else {
            nextWaveButton.setEnabled(false);
        }

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
        //text = text + "You have " + game.getPlayer().getNumOfKits() + " health kits, which heal 15 health each. Would you like to use one?\n";


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
        if(nextWaveButton.isTouchedBy(mouseX, mouseY) && nextWaveButton.getEnabled() == true) {
            mouseX = -1;
            mouseY = -1; //prevents mouse from activating it immediately again the next wave.
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

    public void resetTicks() {
        this.ticksOnScreen = 0;
    }




    //not used
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

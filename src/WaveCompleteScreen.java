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


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WaveCompleteScreen implements MouseMotionListener, MouseListener {
    private int mouseX; //x coord of the mouse
    private int mouseY; //y coord of the mouse
    private boolean isMousePressed; //whether or not the mouse is pressed
    private ZombieSurvivalGame game; //the game that the screen is inside of
    private Button nextWaveButton; //the button that begins the next wave
    private Button buyShotgunButton; //the button to buy a shotgun
    //private Button useHealthKitButton;
    private int ticksOnScreen; //the number of ticks it's been on screen

    //constructor, creates a new screen
    public WaveCompleteScreen(ZombieSurvivalGame game) {
        this.game = game;

        //creates new buttons that are disabled by default
        nextWaveButton = new Button(250, 700, 500, 150, Color.BLUE, Color.RED);
        nextWaveButton.setEnabled(false);
        buyShotgunButton = new Button(250, 600, 500, 50, Color.BLUE, Color.RED);
        buyShotgunButton.setEnabled(false);
        //useHealthKitButton = new Button(700, 700, 250, 100, Color.BLUE, Color.RED);
        //useHealthKitButton.setEnabled(false);
    }

    //draws the screen
    public void draw(Graphics g) {
        //increases the number of ticks it's been on screen
        ticksOnScreen++;

        //enables the next wave button after 2 seconds (that way the user can't accidentally click the button immediately
        if(ticksOnScreen >= 100) {
            nextWaveButton.setEnabled(true);
        } else {
            nextWaveButton.setEnabled(false);
        }

        //enabled buyShotgun button if player can afford it, and does not already have it
        if(game.getPlayer().getCoins() >= 1000 && !(game.getPlayer().getGun() instanceof Shotgun)) {
            buyShotgunButton.setEnabled(true);
        } else {
            buyShotgunButton.setEnabled(false);
        }

        //sets the background to black
        g.setColor(Color.BLACK);
        g.fillRect(-1, -1, 1002, 1002);

        //draws the buttons
        nextWaveButton.draw(g);
        buyShotgunButton.draw(g);

        //draws the main text
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

        g.drawString("Buy shotgun for 1000 coins?", 340, 635);


        //loops through the long string, and draws one line at a time going downwards
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

    //called when the mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {
        isMousePressed = false;
        nextWaveButton.setPressed(false);
        nextWaveButton.setHovered(false);

        //if the mouse was released when on a button, then it calls the button functionality
        if(nextWaveButton.isTouchedBy(mouseX, mouseY) && nextWaveButton.getEnabled() == true) {
            mouseX = -1;
            mouseY = -1; //prevents mouse from activating it immediately again the next wave.
            game.changeScreen(ZombieSurvivalGame.GAME_SCREEN);
        }

        buyShotgunButton.setPressed(false);
        buyShotgunButton.setHovered(false);
        //if the mouse was released on this button, then the button functionality is called
        if(buyShotgunButton.isTouchedBy(mouseX, mouseY) && nextWaveButton.getEnabled() == true) {
            mouseX = -1;
            mouseY = -1; //prevents mouse from activating it immediately again the next wave.
            game.getPlayer().setGun(new Shotgun((int) game.getPlayer().getX(), (int) game.getPlayer().getY(), game));
            game.getPlayer().addCoins(-1000);
        }
    }

    //called when the mouse is moved
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        //if the buttons are being hovered over, they change color
        if(nextWaveButton.isTouchedBy(mouseX, mouseY)) {
            nextWaveButton.setHovered(true);
            if(isMousePressed == true) {
                nextWaveButton.setPressed(true);
            }
        } else {
            nextWaveButton.setHovered(false);
            nextWaveButton.setPressed(false);
        }

        if(buyShotgunButton.isTouchedBy(mouseX, mouseY)) {
            buyShotgunButton.setHovered(true);
            if(isMousePressed == true) {
                buyShotgunButton.setPressed(true);
            }
        } else {
            buyShotgunButton.setHovered(false);
            buyShotgunButton.setPressed(false);
        }
    }

    //when mouse is clicked down, this is called
    @Override
    public void mousePressed(MouseEvent e) {
        isMousePressed = true;
        //if a button is being touched when the mouse is pressed, it shrinks a little bit to give some response to the user
        if(nextWaveButton.isTouchedBy(mouseX, mouseY)) {
            nextWaveButton.setPressed(true);
        } else {
            nextWaveButton.setPressed(false);
        }

        if(buyShotgunButton.isTouchedBy(mouseX, mouseY)) {
            buyShotgunButton.setPressed(true);
        } else {
            buyShotgunButton.setPressed(false);
        }
    }


    //called when the mouse is pressed down and moved without being released
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    //resets the number of ticks it's been on screen
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

/*
Savannah Bananas
4/28/2020
This is the class that will contain all of the graphics, and will be added to the main class on startup
*/

import entities.friendlyEntities.Player;
import entities.monsters.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieSurvivalGame extends JPanel implements ActionListener {

    private int time; //counts the number of game ticks since the start of the wave
    private Player player; //This is the player that the user can control.
    private int waveNumber; //Assuming we use the wave system, this will hold the wave number.
    private Monster[] monsters; //List of all monsters on screen

    //Default constructor
    public ZombieSurvivalGame() {
        time = 0;
        startNewGame();
        //Clock inserts a delay between redrawing each frame. For testing, the delay can be modified.
        //The delay is in milliseconds. If you set delay to 20, that's 50 fps.
        Timer clock = new Timer(20, this);
        clock.start();
    }

    // Initialization of the window. This only happens once.
    public void initialize() {
        //sets up the window
        JFrame w = new JFrame("ZombieSurvival - by the SavannahBananas");
        w.setBounds(200, 0, 1000, 1000);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = w.getContentPane();
        c.add(new ZombieSurvivalGame());
        w.setVisible(true);
        w.setResizable(false);
    }

    // start a game. Once we have a "restart" or "Try again" or something, this will be called to restart the game
    // (without restarting the program)
    public void startNewGame() {
        time = 0;
        player = new Player(500, 500, 100.0, 100.0, 5.0);

    }

    // This draws the scene every frame.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawNextFrame(g);
    }

    //This event gets activated by the Clock, and repaints the screen.
    public void actionPerformed(ActionEvent e) {
        time++;
        repaint();
    }












    //This is the main "repaint" method that will redraw every single frame
    private void drawNextFrame(Graphics g) {
        g.drawString("Time = " + time, 50, 50);

        //Calls the draw method of the player
        player.draw(g);
    }
}

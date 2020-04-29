/*
Savannah Bananas
4/28/2020
This is the class that will contain all of the graphics, and will be added to the main class on startup
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieSurvivalGame extends JPanel implements ActionListener {

    private int time; //counts the number of game ticks since the start of the wave

    //Default constructor
    public ZombieSurvivalGame() {
        time = 0;

        //Clock inserts a delay between redrawing each frame. For testing, the delay can be modified.
        //The delay is in milliseconds. If you set delay to 20, that's 50 fps.
        Timer clock = new Timer(1000, this);
        clock.start();
    }

    // Initialization of the window
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

    // This draws the scene
    public void paintComponent(Graphics g) {
        System.out.println("Called repaint()");
        super.paintComponent(g);
        g.drawString("Time = " + time, 50, 50);
    }
    /*public void paintComponent(Graphics g) {
        System.out.println("yeah");
        super.paintComponent(g);
        setBackground(Color.GREEN);
        g.drawString("Time = " + time, 50, 50);
    }*/

    public void actionPerformed(ActionEvent e) {
        System.out.println("Gone through actionPerformed");
        time++;
        repaint();
    }
}

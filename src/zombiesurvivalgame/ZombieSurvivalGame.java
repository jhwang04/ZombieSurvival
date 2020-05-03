/*
Savannah Bananas
4/28/2020
This is the class that will contain all of the graphics, and will be added to the main class on startup
*/

package zombiesurvivalgame;

import entities.friendlyEntities.Player;
import entities.monsters.Monster;
import entities.monsters.Zombie;
import weapons.Pistol;
import weapons.projectiles.Projectile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieSurvivalGame extends JPanel implements ActionListener {

    private int time; //counts the number of game ticks since the start of the wave
    private Player player = new Player(500, 500, 100.0, 100.0); //This is the player that the user can control.
    private int waveNumber; //Assuming we use the wave system, this will hold the wave number.
    public Monster[] monsters = new Monster[0]; //List of all monsters on screen
    private Projectile[] bullets = new Projectile[0];
    private boolean showHitboxes = true;
    ImageIcon tree1;

    //Default constructor
    public ZombieSurvivalGame() {
        time = 0;
        startNewGame();
        //Clock inserts a delay between redrawing each frame. For testing, the delay can be modified.
        //The delay is in milliseconds. If you set delay to 20, that's 50 fps.
        Timer clock = new Timer(20, this);
        clock.start();

        //sets up the window
        JFrame w = new JFrame("ZombieSurvival - by the SavannahBananas");
        w.setBounds(200, 0, 1000, 1000);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = w.getContentPane();
        c.add(this);
        w.setVisible(true);
        w.setResizable(false);

        tree1 = new ImageIcon("C:/Users/jrmil/IdeaProjects/ZombieSurvival");

        //this allows player input
        w.addKeyListener(player);
        w.addMouseListener(player.getGun());
    }

    // start a game. Once we have a "restart" or "Try again" or something, this will be called to restart the game
    // (without restarting the program)
    public void startNewGame() {
        time = 0;
        player.setX(500.0);
        player.setY(500.0);
        player.setMaxHealth(100.0);
        player.setMaxHealth(100.0);
        player.setGun(new Pistol((int) player.getX(), (int) player.getY(), this));
    }

    // starts a new wave.  Will be called when all zombies are dead not functional yet)
    public void nextWave() {
        int placeholderNumberOfZombies = 10;

        monsters = new Monster[0];

        for(int i = 0; i < placeholderNumberOfZombies; i++) {
            monsters = addMonster(monsters, new Zombie(i * 100, 100, 500, 500));
        }

    }

    // This draws the scene every frame.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color background = new Color(60, 179, 113);



        setBackground(background);
        this.drawNextFrame(g);
    }

    //This event gets activated by the Clock, and repaints the screen.
    public void actionPerformed(ActionEvent e) {
        time++;
        repaint();
    }

    //adds element to array
    public static Monster[] addMonster(Monster[] originalArray, Monster newMonster) {
        Monster[] newMonsterArray = new Monster[originalArray.length + 1];
        for(int i = 0; i < originalArray.length; i++) {
            newMonsterArray[i] = originalArray[i];
        }

        newMonsterArray[originalArray.length] = newMonster;
        return newMonsterArray;
    }

    public static Projectile[] addBullet(Projectile[] original, Projectile newBullet) {
        Projectile[] newArray = new Projectile[original.length + 1];
        for(int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        newArray[original.length] = newBullet;
        return newArray;
    }





    //This is the main "repaint" method that will redraw every single frame
    private void drawNextFrame(Graphics g) {

        //moves onto next wave if all monsters are dead
        if(monsters.length == 0) {
            nextWave();
        }

        //checks if each monster is dead. If so, the monster is removed from monsters array.
        Monster[] newMonsters = new Monster[0];
        for(int i = 0; i < monsters.length; i++) {
            if(monsters[i].getHealth() > 0.0) {
                newMonsters = addMonster(newMonsters, monsters[i]);
            }
        }
        monsters = newMonsters.clone();

        //checks if each bullet is dead. If so, the projectile is removed from the array.
        Projectile[] newProjectiles = new Projectile[0];
        for(int i = 0; i < bullets.length; i++) {
            if(bullets[i].getDespawned() == false) {
                newProjectiles = addBullet(newProjectiles, bullets[i]);
            }
        }
        bullets = newProjectiles.clone();




        g.drawString("Time = " + time, 50, 50);
        g.drawString("# of bullets = " + bullets.length, 50, 80);
        for(int i = 0; i < monsters.length; i++) {
            monsters[i].draw(g);
            if(showHitboxes == true) {
                monsters[i].drawHitbox(g);
            }
        }
        for(int i = 0; i < bullets.length; i++) {
            bullets[i].draw(g);
            if(showHitboxes == true) {
                bullets[i].drawHitbox(g);
            }
        }

        //Calls the draw method of the player
        player.draw(g);
        if(showHitboxes == true) {
            player.drawHitbox(g);
        }
    }

    public Projectile[] getBullets() {
        return bullets;
    }

    public void setBullets(Projectile[] p) {
        this.bullets = p;
    }

    public void appendBullet(Projectile p) {
        this.bullets = addBullet(bullets, p);
    }
}

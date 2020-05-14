/*
Savannah Bananas
4/28/2020
This is the class that will contain all of the graphics, and will be added to the main class on startup
*/

package zombiesurvivalgame;

import entities.friendlyEntities.Player;
import entities.monsters.Monster;
import entities.monsters.Zombie;
import misc.*;
import weapons.Pistol;
import weapons.projectiles.Projectile;
import misc.Items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ZombieSurvivalGame extends JPanel implements ActionListener {

    private int time; //counts the number of game ticks since the start of the wave
    public Player player = new Player(500, 500, 100.0, 100.0); //This is the player that the user can control.
    private int waveNumber; //Assuming we use the wave system, this will hold the wave number.
    public Monster[] monsters = new Monster[0]; //List of all monsters on screen
    private Projectile[] bullets = new Projectile[0];
    private boolean debugOn = true;
    public int seconds;
    public Tree tree1;
    public int kills;
    public int monsterCount;
    public boolean isGameOver = false;
    Timer clock;
    private HealthKit kit;
    private Armor armor;
    private Graphics graphics;


    //Default constructor
    public ZombieSurvivalGame() {

        time = 0;
        startNewGame();
        //Clock inserts a delay between redrawing each frame. For testing, the delay can be modified.
        //The delay is in milliseconds. If you set delay to 20, that's 50 fps.
        clock = new Timer(20, this);
        clock.start();

        //sets up the window
        JFrame w = new JFrame("ZombieSurvival - by the SavannahBananas");
        w.setBounds(200, 0, 1000, 1000);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = w.getContentPane();
        c.add(this);
        w.setVisible(true);
        w.setResizable(false);

        //Becuase this is using a filepath from your computer, it won't work


        //this allows player input
        w.addKeyListener(player);
        w.addMouseListener(player.getGun());
        w.addMouseMotionListener(player);

        seconds = 0;
        kills = 0;
        monsterCount = 0;
        waveNumber = 0;

        kit = new HealthKit(250, 250);
        armor = new Armor(750, 750);
        tree1 = new Tree((int)Math.random()*900, (int)Math.random()*900);

        drawTrees();
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
        monsterCount = 2;

        //drawTrees();

    }

    // starts a new wave.  Will be called when all zombies are dead not functional yet)
    public void nextWave() {
        //int placeholderNumberOfZombies = 5;
        monsterCount += 2;
        waveNumber++;
        monsters = new Monster[0];

        for(int i = 0; i < monsterCount; i++) {

            //makes sure that a zombie can't spawn too close to the player
            int zombieX = 0;
            int zombieY = 0;
            boolean isValidLocation = false;
            while(isValidLocation == false) {
                //creates new random spawn location
                zombieX = (int) (Math.random() * 1400) - 200;
                zombieY = (int) (Math.random() * 1400) - 200;
                //uses pythagorean theorem to check distance from spawn location to player
                double changeX = zombieX - player.getX();
                double changeY = zombieY - player.getY();
                double distance = Math.sqrt(changeX*changeX + changeY*changeY);
                //if more than 300 pixels away, it's a valid location
                if(distance >= 300) {
                    isValidLocation = true;
                }
            }

            monsters = addMonster(monsters, new Zombie(zombieX, zombieY, 500, 500, this));
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

        if(isGameOver == false) {
            time++;
        }
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

        if(this.isGameOver == false) {
            //moves onto next wave if all monsters are dead
            if(monsters.length == 0) {
                nextWave();
            }


            /*
            kit.draw(g);
            armor.draw(g);


             */
            /*
            if (player.isTouching(kit) || !(kit.getPickedUp())) {
                player.setHealth(player.getHealth() + 15);
                kit.setPickedUp(true);
                kit.hide();

            }
            */


         /*
         if (player.isTouching(kit.hitbox))  {
             player.setHealth(player.getHealth() + 15);
         }
        */



            //checks if each monster is dead. If so, the monster is removed from monsters array.
            Monster[] newMonsters = new Monster[0];
            for(int i = 0; i < monsters.length; i++) {
                if(monsters[i].getHealth() > 0.0) {
                    newMonsters = addMonster(newMonsters, monsters[i]);
                }
                else {
                    kills++;
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

            for(int i = 0; i < monsters.length; i++) {
                monsters[i].draw(g);
                if(debugOn == true) {
                    monsters[i].drawHitbox(g);
                }
            }
            for(int i = 0; i < bullets.length; i++) {
                bullets[i].draw(g);
                if(debugOn == true) {
                    bullets[i].drawHitbox(g);
                }
            }

            //Calls the draw method of the player
            player.draw(g);

            if(debugOn == true) {
                player.drawHitbox(g);
            }

            //debug screen, more text can be added as needed
            if(debugOn == true) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Impact", Font.PLAIN, 15));
                g.drawString("Ticks = " + time, 50, 50);
                g.drawString("# of bullets = " + bullets.length, 50, 80);
                g.drawString("Player x = " + player.getX(), 50, 110);
                g.drawString("Player y = " + player.getY(), 50, 140);
                g.drawString("Player Health = " + player.getHealth(), 50, 170);
                g.drawString("Time Seconds = " + seconds, 50, 200);
                g.drawString("Kills = " + kills, 50, 230);
            }

            for (int m = 0; m < monsters.length && time%50 == 0; m++) {
                if (player.isTouching(monsters[m])){
                    player.setHealth(player.getHealth()-5);
                }
            }

            if (time % 50 == 0) {
                seconds++;
            }

            if (player.getHealth() <= 0) {
                this.isGameOver = true;
            }
        } else {
            player.setHealth(0.0);
            this.gameOver(g);
        }

        //HUD at the bottom, displays on top of both game and game over
        g.setColor(Color.black);
        g.fillRect(0, 900, 1000, 100);

        g.setColor(Color.yellow);
        g.setFont(new Font("Impact", Font.PLAIN, 25));
        g.drawString("Time: " + seconds, 30, 940);
        g.drawString("Kills: " + kills, 180, 940);
        g.drawString("Monster Count:  " + monsters.length + "/" + monsterCount, 300, 940);
        g.drawString("Wave Number: " + waveNumber, 550, 940);
        g.drawString("Health: " + player.getHealth(), 750, 940);
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

    public Player getPlayer() {
        return player;
    }

    public void drawTrees() {
        tree1.draw(graphics);
    }

    public void gameOver(Graphics g) {
        setBackground(Color.black);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 1000, 1000);
        g.setColor(Color.RED);
        g.setFont(new Font("Impact", Font.BOLD, 150));
        g.drawString("GAME OVER", 125, 550);
    }
}
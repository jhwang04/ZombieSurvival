### Final Capstone Project - Zombie Survival

**Team Name:** *The Savannah Bananas*

**Team Members:** Jeremy Mills, Justin Hwang, Rishi Zamvar

**Revision Date:** 5/17 Rev #6

**Program Purpose:** After running this program, users will be able to play a zombie survival game, where waves of zombies come at you, while you try to survive.

**Target User Profile:** Our Target User Profile is people who like to play games, and for people who want a challenge.

**Feature List:** Some features for our game include zombie waves, shooting, finding items on the floor that spawn randomly, healing from certain items, powerups, and more.

**Instructions:** To run the program, copy the source files into Eclipse or IntelliJ and run the folder as a java application.  

Controls:
  * Move by using W, A, S and D
  * Left click to fire a weapon
  * Run over items to pick them up


### Class List:

For a more detailed class list, go to https://github.com/jhwang04/ZombieSurvival/blob/master/CLASSLIST.md

  * ZombieSurvivalMain.java
  * ZombieSurvivalGame.java
  * Button.java
  * GameOverScreen.java
  * HelpScreen.java
  * StartScreen.java
  * PauseScreen.java
  * WaveCompleteScreen.java
  * Ranged.java
  * LivingEntity.java
  * Monster.java
  * Zombie.java
  * Player.java
  * Hitbox.java
  * Pistol.java
  * PistolBullet.java
  * Projectile.java
  * Armor.java
  * Tree.java
  * Armor.java
  * HealthKit.java


**Team Responsibility:** Jeremy Mills - Graphics
			    Justin Hwang - Overall Game Function
			    Rishi Zamvar - Classes for Zombies, etc.
 
**Known Bugs/ Workarounds:**
  * ~~Clock runs slightly slow (about 1 second slow ever 30-35 seconds)~~
    * Fixed by redoing clock system with System.getTimeInMillis() instead of java.swing.Timer
  * ~~Images won’t show, and/or wont rotate~~
    * Fixed by using AffineTransform and BufferedImage
  * Mouse alignment with buttons and gun aiming is slightly off
    * Caused by the thickness of the title bar at the top, and it's different for mac and windows.


**Key Learnings:** Learning how to link Github and IntelliJ so making changes is easier.
  * Learning to use GitHub and link it to IntelliJ
  * Learning to use AffineTransform
  * Learning to use MouseMotion, MouseEvent and KeyboardEvent listeners


**Credit List:**
  * Icons and Skins - survivio.fandom.com

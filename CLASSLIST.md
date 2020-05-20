# CLASS LIST - PreRelease 1.0
### 5/17/2020

## zombiesurvivalgame package

### ZombieSurvivalMain.java
**Is a:**
  * Main class, contains main method and little else.

**Fields:** N/A

**Methods**
  * main(), which calls a new ZombieSurvivalGame

### ZombieSurvivalGame.java
**Is a:**  
  * Game window for the final product. Includes all of the major bits and pieces for the game to run.  
  * Is also a JPanel 
  
**Fields:**  
  * int time  
    * number of game ticks (50 per second, as of now)  
  * Player player  
    * The active player, that the user controls.  
  * int waveNumber  
    * the wave number that the game is currently on.
  * Monster[] monsters
    * Array that contains all the current zombies
  * Projectile[] bullets
    * Array that contains all the active bullets
  * boolean debugOn
    * setting that shows hitboxes & other debugging overlays
  * int seconds
    * number of seconds a game has been going on
  * Tree[] trees
    * array of trees
  * int kills
    * number of zombie kills the player has
  * int monsterCount
    * number of total monsters in the current wave
  * ~~Timer clock~~
    * ~~the clock that refreshes the screen 50 times per second~~
    * no longer used
  * HealthKit kit
    * the health package that can be picked up by the player
  * Armor armor
    * the player's armor that can be picked up
  * JFrame window
    * the window the game runs in
  * StartScreen startScreen
    * the start-up title screen/main menu screen
  * GameOverScreen gameOverScreen
    * the black "GAME OVER" screen
  * HelpScreen helpScreen
    * the "how to play" screen
  * PauseScreen pauseScreen
    * the "paused" screen when the user clicks "ESC"
  * WaveCompleteScreen waveScreen
    * the "wave complete" screen when the user defeats a wave of zombies
  * int screen
    * which screen the user is on (main game screen, help, etc)
  * static final int _START\_SCREEN_ = 0
    * constant, for switching the screen to main menu
  * static final int _GAME\_SCREEN_ = 1
    * constant, for switching the screen to the game
  * static final int _PAUSE\_SCREEN_ = 2
    * constant, for the pause menu
  * static final int _NEXT\_WAVE\_SCREEN_ = 3
    * constant, for the screen between waves
  * static final int _HOW\_TO\_PLAY\_SCREEN_ = 4
    * constant for the "how to play" screen
  * static final into _GAME\_OVER\_SCREEN_ = 5
    * constant for the game over screen
    
**Methods**
  * ~~starts a clock, that regulates the time between each game tick~~
    * no longer used
  * creates new java window, the graphics display for the game itself
  * drawNextFrame()
    * repaints the window every game tick
  * can append elements to the Monster[], Projectile[], and Tree[] arrays
    * addBullet(), addMonster(), addTree()
  * startNewGame()
    * starts a new game, resetting some variables to 0
  * nextWave()
    * starts a new wave of zombies
  * ~~drawTrees(Graphics g)~~
    * ~~draws all trees~~ not currently used
  * drawPlayer(Graphics g)
    * draws player, and checks if it's dead
  * drawMonsters(Graphics g)
    * draws all monsters, checks if they're dead
  * drawBullets
    * draws all bullets, checks if it's despawned
  * drawDebug
    * draws the debug text in the top left
  * gameOver
    * runs when the player is dead, changes the gameOver flag
  * getPlayer()
    * returns the player object
  * drawHUD()
    * draws the heads-up-display at the bottom, with health, wave number, etc.
  * changeScreen()
    * changes the screen that the window displays
  * gameOver()
    * draws part of the game over screen
    

### StartScreen.java
**Is a:**
  * Display for the main menu screen of the game
  * implements MouseListener and MouseMotionListener

**Fields:**
  * int mouseX
    * x coordinate of the mouse
  * int mouseY
    * y coordinate of the mouse
  * boolean isMousePressed
    * keeps track of whether or not the mouse is pressed
  * ZombieSurvivalGame game
    * game that the screen is inside of
  * Button startButton
    * button to start the game
  * Button helpButton
    * button to open the "how to play" screen

**Methods:**
  * draw(Graphics g)
    * draws the screen, including the buttons
  * MouseEvent methods
    * mouseReleased, mousePressed, used for detecting clicks and movement
    
### HelpScreen.java
**Is a:**
  * Display for the "how to play" screen of the game
  * implements MouseListener and MouseMotionListener

**Fields:**
  * int mouseX
  * int mouseY
  * boolean isMousePressed
  * ZombieSurvivalGame game
  * static Image healthKitImage
    * image of a health kit for display purposes
  * static Image armorKitImage
    * image of the armor kit for display purposes
  * Button menuButton
    * button to return to main menu

**Methods:**
  * draw(Graphics g)
    * draws the button
  * MouseEvent methods
    * mousePressed, mouseReleased, for detecting clicks and movement

### GameOverScreen.java
**Is a:**
  * Display for the "game over" screen of the game
  * implements MouseListener and MouseMotionListener

**Fields:**
  * int mouseX
  * int mouseY
  * boolean isMousePressed
  * ZombieSurvivalGame game
    * game window that this display is inside of
  * Button menuButton
    * button to return to main menu
    
**Methods:**
  * draw(Graphics g)
    * draws the window
  * MouseEvent methods
    * mousePressed, mouseReleased, mouseMoved, for mouse clicks and movement

### PauseScreen.java
**Is a:**
  * Display for the "paused" screen of the game
  * implements MouseListener and MouseMotionListener
  
**Fields:**
  * int mouseX
  * int mouseY
  * boolean isMousePressed
  * ZombieSurvivalGame game
    * game window that the display is inside of
  * Button menuButton
    * back to main menu button
  * Button resumeButton
    * button to resume the game

**Methods:**
  * draw(Graphics g)
    * draws the screen
  * MouseEvent methods
    * mousePressed, mouseReleased, mouseMoved, for detecting clicking/moving

### WaveCompleteScreen.java
**Is a:**
  * Display for the "Wave complete" screen of the game
  * implements MouseListener and MouseMotionListener
  
**Fields:**
  * int mouseX
  * int mouseY
  * boolean isMousePressed
  * ZombieSurvivalGame game
    * game window that the display is inside of
  * Button nextWaveButton
    * button to advance to the next wave
  * Button useHealthKitButton
    * button to use up one health kit

**Methods:**
  * draw(Graphics g)
    * draws the screen
  * MouseEvent methods
    * mousePressed, mouseReleased, mouseMoved, for detecting clicking/moving

### Button.java
**Is a:**
  * Button that can be pressed

**Fields:**
  * int x
    * x coordinate of button
  * int y
    * y coordinate of button
  * int width
    * width of button
  * int height
    * height of button
  * Color currentColor
    * color the button is at that moment
  * Color defaultColor
    * the color that the button is when idle
  * Color secondaryColor
    * the color that the button is when it's hovered over
  * boolean isHovered
    * if the mouse is hovering over the button
  * boolean isPressed
    * if the mouse is pressed down on the button

**Methods:**
  * draw(Graphics g)
    * draws the button
  * boolean isTouchedBy(int mouseX, int mouseY)
    * determines if the button is being touched by the mouse
  * setHovered
    * sets the isHovered variable
  * setPressed
    * sets the isPressed variable

    
## weapons package

### Ranged.java
**Is a:** Class, represents all ranged weapons. Will be extended to be "pistol" or "rifle" or "bow & arrow".
  * implements MouseListener so that it can take mouse input (to shoot the bullets)
  
**Fields:**
  * int x
    * x coordinate of the ranged weapon
  * int y
    * y coordinate of the ranged weapon
  * Image image
    * the picture of the weapon
  * ZombieSurvivalGame game
    * the game that the Ranged is inside of

**Methods**
  * can shoot a projectile
  * can draw itself
  * has generic "get" methods to query the current state of instance variables
  * generic "set" methods to change its fields
  * Uses the mousePressed event to shoot bullets

### Pistol.java
**Is a:**
  * Is a Ranged weapon, and represents the default gun (a pistol)

**Fields:**
  * _Inherits fields from Ranged.java_
  * Image _PISTOL\_IMAGE_
    * Is the default image for a pistol

**Methods**
  * _Inherits methods from Ranged.java_
  * Overrides the Ranged "shoot" method (not necessary at the moment because of our lack of graphics)

## weapons.projectiles package

### Projectile.java
**Is a:**
  * Is the generic projectile, which can be a bullet, an arrow, etc.
  * Is also a Hitbox

**Fields:**
  * int x
    * x coordinate of the projectile
  * int y
    * y coordinate of the projectile
  * double speed
    * speed that the projectile can travel
  * double damage
    * damage the bullet does on impact
  * int range
    * how far the bullet can go before it despawns
  * boolean despawned
    * whether or not the bullet is despawned
  * double distanceTraveled
    * amount of pixels the bullet has traveled
  * Image image
    * the picture of the bullet
  * double trajectory
    * the trajectory of the bullet in degrees
  * ZombieSurvivalGame game
    * the game that the projectile exists inside of

**Methods**
  * Draw itself
  * Generic "get" methods
  * Generic "set" methods to change the values
  * move() , which will move the bullet the amount it should in one frame

### PistolBullet.java
**Is a:**
  * Is a bullet that is fired by the Pistol.java class

**Fields:**
  * _Inherits fields from Projectile.java_
  * double _PISTOL\_BULLET\_SPEED_
    * The default speed of a pistol bullet
  * double _PISTOL\_BULLET\_DAMAGE_
    * The default damage a pistol bullet does on impact
  * int _PISTOL\_RANGE_
    * The default range of a pistol bullet before it despawns
  * int _PISTOL\_BULLET\_WIDTH_
    * default width of the hitbox
  * int _PISTOL\_BULLET\_HEIGHT_
    * default height of the hitbox
  * Image _PISTOL\_BULLET\_IMAGE_
    * default image of the pistol bullet (null for now, basic circle is being used);
    
**Methods**
  * _Inherits methods from Projectile.java_
  * Calls _super()_ constructor of Projectile.java

## entities package

### LivingEntity.java
**Is a:**
  * Is an abstract class, which is a generic living entity, to be extended by both the Player class and all Monster classes.
  * Is also a hitbox

**Fields:**
  * double maxHealth
	* maximum health that the entity can have, not likely to change
  * double health
	* current health the entity has
  * double movementSpeed
	* how quickly the entity can move
  * double x
	* current x-coordinate of the entity on the screen
  * double y
	* current y-coordinate of the entity on the screen

**Methods**
	* draws itself
	* has generic "get" methods to query the current state of instance variables
	* has generic "set" methods to change the values of the variables

### Hitbox.java
**Is a:**
  * Represents an object with a hitbox, like a player, bullet, or zombie.
  
**Fields:**
  * int hx
    * the x coordinate of the top left corner of the hitbox
  * int hy
    * the y coordinate of the top left corner of the hitbox
  * int hw
    * the width of the hitbox
  * int hh
    * the height of the hitbox

**Methods**
  * isTouching, can check if two Hitboxes are in contact with each other
  * drawHitbox(Graphics g)
    * draws the hitbox
  * generic "get" methods to query the current values of instance variables
  * generic "set" methods to change the values of the variables

## entities.monsters package

### Monster.java
**Is a:**
  * Is a LivingEntity, but is also an abstract class to be extended by specific monsters, such as Zombies.

**Fields:**
  * _inherits instance variables from LivingEntity class_
  * int targetX
    * current x-coordinate of the monster's target, where it wants to go to.
  * int targetY
	* current y-coordinate of the monster's target, where it wants to go to.
  * ZombieSurvivalGame game
    * the game that the monster is inside

**Methods**
  * _inherits methods from LivingEntity class_
  * generic "get" methods to query targetX and targetY
  * generic "set" methods to set its instance variables

### Zombie.java
**Is a:**
  * Is a Monster, and represents the generic zombie enemy.

**Fields:**
  * int _ZOMBIE\_MAX\_HEALTH_
    * static final int, which defines the default zombie max health.
  * double _ZOMBIE\_MOVEMENT\_SPEED_
    * static final double, which defines default zombie movement speed.
  * int _ZOMBIE\_WIDTH_
    * static final int, the default width of a zombie
  * int _ZOMBIE\_HEIGHT_
    * static final int, the default height of a zombie

**Methods**
  * move()
    * moves the zombie closer to the player
  * draw()
    * draws the zombie

## entities.friendlyEntities package

### Player.java
**Is a:**
  * is a LivingEntity, and represents the user's character in the game.
  * implements KeyListener, so that the user can input movement controls

**Fields:**
  * _inherits instance variables from LivingEntity class_
  * int points
	* the total number of points this player has, accumulates over time
  * int coins
	* the current amount of in-game currency the player has, functionality may be implemented later
  * gun
    * An instance of "Ranged" abstract class, of some kind of gun.
  * int _PLAYER\_HEIGHT_
    * default height of player's hitbox
  * int _PLAYER\_WIDTH_
    * default width of a player's hitbox
  * double _PLAYER\_MOVEMENT\_SPEED_
    * default movement speed of a player
  * boolean movingUp, movingDown, movingLeft, movingRight
    * private variables, used for determining player movement
  * BufferedImage image
    * the image of the player
  * int numOfKits
    * number of health kits the player has in storage
  * ZombieSurvivalGame game
    * the game that the player is inside of

**Methods**
  * _inherits methods from LivingEntity class_
  * move()
    * moves the player to the location for the next frame (using keyboard input)
  * draw() (overrides the LivingEntity's draw method)
  * generic "get" commands to query points and coins
  * stopMoving()
    * stops all player movement
  * "set" methods, both to set the amount of coins & points the player has, but also "add" methods to increment the amount.
  * uses the keyPressed and keyReleased events to take player input
  * rotateImageByRadians(BufferedImage image) will return a new buffered image, that's been rotated by the given number of radians.

## misc package

### Tree.java

**Is a:**
  * Is a tree, that represents a tree. Will maybe be a hitbox in the future.
  
**Fields:**
  * int x
    * x coordinate of tree
  * int y 
    * y coordinate of tree
  * Image image
    * tree image

**Methods**
  * draw(Graphics g)
    * draws the tree at the location given



## misc.items package

### Armor.java

**Is a:**
  * An item for the player, that makes the player take less damage
  * Is also a hitbox

**Fields:**
  * int x
    * x coordinate of armor item
  * int y
    * y coordinate of armor item
  * int width
    * width of armor item
  * int height
    * height of armor item
  * boolean pickedUp
    * whether or not the armor has been picked up

**Methods**
  * generic "get" methods
  * generic "set" methods
  * hide()
    * hides the Armor
  * unHide()
    * shows the Armor
  * draw()
    * draws the Armor
    
### HealthKit.java

**Is a:**
  * is an item that the player can pick up to heal themselves
  * is also a hitbox

**Fields:**
  * int x
    * x coordinate of item
  * int y
    * y coordinate of item
  * boolean pickedUp
    * whether or not the item is picked up
  * Image image
    * image of the item
  * ZombieSurvivalGame game
    * the game that the item is inside
    
**Methods**
  * draw(Graphics g)
    * draws the healthkit
  * hide()
    * hides the healthkit
  * unhide()
    * shows the healthkit
  * "get" methods
    * query the current state of the variables
  * "set" methods
    * set the current state of the variables
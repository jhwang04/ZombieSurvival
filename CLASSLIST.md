# CLASS LIST - ALPHA 1.1
### 4/29/2020

# OUTDATED!! REFER TO README.pdf FOR UPDATED INFO

## zombiesurvivalgame package

#### ZombieSurvivalMain.java
**Is a:**
  * Main class, contains main method and little else.

**Has a:** N/A

**Does:**
  * main(), which calls a new ZombieSurvivalGame

#### ZombieSurvivalGame.java
**Is a:**  
  * Game window for the final product. Includes all of the major bits and pieces for the game to run.  
  * Is also a JPanel  
  * Implements ActionListener  
  
**Has a:**  
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
  * boolean isGameOver
    * is the game over?
  * Timer clock
    * the clock that refreshes the screen 50 times per second
  * HealthKit kit
    * the health package that can be picked up by the player
  * Armor armor
    * the player's armor
    
**Does:**
  * starts a clock, that regulates the time between each game tick
  * creates new java window, the graphics display for the game itself
  * drawNextFrame()
    * repaints the window every game tick
  * can append elements to the Monster[], Projectile[], and Tree[] arrays
    * addBullet(), addMonster(), addTree()
  * startNewGame()
    * starts a new game, resetting some variables to 0
  * nextWave()
    * starts a new wave of zombies
  * drawTrees(Graphics g)
    * draws all trees
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
    

## weapons package

#### Ranged.java
**Is a:** Class, represents all ranged weapons. Will be extended to be "pistol" or "rifle" or "bow & arrow".
  * implements MouseListener so that it can take mouse input (to shoot the bullets)
  
**Has a:**
  * int x
    * x coordinate of the ranged weapon
  * int y
    * y coordinate of the ranged weapon
  * Image image
    * the picture of the weapon
  * ZombieSurvivalGame game
    * the game that the Ranged is inside of

**Does:**
  * can shoot a projectile
  * can draw itself
  * has generic "get" methods to query the current state of instance variables
  * generic "set" methods to change its fields
  * Uses the mousePressed event to shoot bullets

#### Pistol.java
**Is a:**
  * Is a Ranged weapon, and represents the default gun (a pistol)

**Has a:**
  * _Inherits fields from Ranged.java_
  * Image _PISTOL\_IMAGE_
    * Is the default image for a pistol

**Does:**
  * _Inherits methods from Ranged.java_
  * Overrides the Ranged "shoot" method (not necessary at the moment because of our lack of graphics)

## weapons.projectiles package

#### Projectile.java
**Is a:**
  * Is the generic projectile, which can be a bullet, an arrow, etc.
  * Is also a Hitbox

**Has a:**
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

**Does:**
  * Draw itself
  * Generic "get" methods
  * Generic "set" methods to change the values
  * move() , which will move the bullet the amount it should in one frame

#### PistolBullet.java
**Is a:**
  * Is a bullet that is fired by the Pistol.java class

**Has a:**
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
    
**Does:**
  * _Inherits methods from Projectile.java_
  * Calls _super()_ constructor of Projectile.java

## entities package

#### LivingEntity.java
**Is a:**
  * Is an abstract class, which is a generic living entity, to be extended by both the Player class and all Monster classes.
  * Is also a hitbox

**Has a:**
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

**Does:**
	* draws itself
	* has generic "get" methods to query the current state of instance variables
	* has generic "set" methods to change the values of the variables

#### Hitbox.java
**Is a:**
  * Represents an object with a hitbox, like a player, bullet, or zombie.
  
**Has a:**
  * int hx
    * the x coordinate of the top left corner of the hitbox
  * int hy
    * the y coordinate of the top left corner of the hitbox
  * int hw
    * the width of the hitbox
  * int hh
    * the height of the hitbox

**Does:**
  * isTouching, can check if two Hitboxes are in contact with each other
  * drawHitbox(Graphics g)
    * draws the hitbox
  * generic "get" methods to query the current values of instance variables
  * generic "set" methods to change the values of the variables

## entities.monsters package

#### Monster.java
**Is a:**
  * Is a LivingEntity, but is also an abstract class to be extended by specific monsters, such as Zombies.

**Has a:**
  * _inherits instance variables from LivingEntity class_
  * int targetX
    * current x-coordinate of the monster's target, where it wants to go to.
  * int targetY
	* current y-coordinate of the monster's target, where it wants to go to.
  * ZombieSurvivalGame game
    * the game that the monster is inside

**Does:**
  * _inherits methods from LivingEntity class_
  * generic "get" methods to query targetX and targetY
  * generic "set" methods to set its instance variables

#### Zombie.java
**Is a:**
  * Is a Monster, and represents the generic zombie enemy.

**Has a:**
  * int _ZOMBIE\_MAX\_HEALTH_
    * static final int, which defines the default zombie max health.
  * double _ZOMBIE\_MOVEMENT\_SPEED_
    * static final double, which defines default zombie movement speed.
  * int _ZOMBIE\_WIDTH_
    * static final int, the default width of a zombie
  * int _ZOMBIE\_HEIGHT_
    * static final int, the default height of a zombie

**Does:**
  * move()
    * moves the zombie closer to the player
  * draw()
    * draws the zombie

## entities.friendlyEntities package

#### Player.java
**Is a:**
  * is a LivingEntity, and represents the user's character in the game.
  * implements KeyListener, so that the user can input movement controls

**Has a:**
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

**Does:**
  * _inherits methods from LivingEntity class_
  * move()
    * moves the player to the location for the next frame (using keyboard input)
  * draw() (overrides the LivingEntity's draw method)
  * generic "get" commands to query points and coins
  * "set" methods, both to set the amount of coins & points the player has, but also "add" methods to increment the amount.
  * uses the keyPressed and keyReleased events to take player input
  * rotateImageByRadians(BufferedImage image) will return a new buffered image, that's been rotated by the given number of radians.

## misc package

#### Tree.java

**Is a:**
  * Is a tree, that represents a tree. Will maybe be a hitbox in the future.
  
**Has a:**
  * int x
    * x coordinate of tree
  * int y 
    * y coordinate of tree
  * Image image
    * tree image

**Does:**
  * draw(Graphics g)
    * draws the tree at the location given



## misc.items package

#### Armor.java

**Is a:**
  * An item for the player, that makes the player take less damage
  * Is also a hitbox

**Has a:**
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

**Does:**
  * generic "get" methods
  * generic "set" methods
  * hide()
    * hides the Armor
  * unHide()
    * shows the Armor
  * draw()
    * draws the Armor
    
#### HealthKit.java

**Is a:**
  * is an item that the player can pick up to heal themselves
  * is also a hitbox

**Has a:**
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
    
**Does:**
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
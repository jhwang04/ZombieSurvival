# CLASS LIST - ALPHA 1.0
### 4/29/2020

## src package

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
    * number of game ticks (20-50 per second, not decided yet.)  
  * Player player  
    * The active player, that the user controls.  
  * int waveNumber  
    * the wave number that the game is currently on.
    
**Does:**
  * starts a clock, that regulates the time between each game tick
    * creates new java window, the graphics display for the game itself
    * repaints the window every game tick

## weapons package

#### Ranged.java
**Is a:** Abstract class, represents all ranged weapons. Will be extended to be "pistol" or "rifle" or "bow & arrow".

**Has a:**
  * int x
    * x coordinate of the ranged weapon
  * int y
    * y coordinate of the ranged weapon
  * Image image
    * the picture of the weapon

**Does:**
  * can shoot a projectile
  * can draw itself
  * has generic "get" methods to query the current state of instance variables

#### Pistol.java
**Is a:**
  * Is a Ranged weapon, and represents the default gun (a pistol)

**Has a:**
  * _Inherits fields from Ranged.java_
  * Image _PISTOL\_IMAGE_
    * Is the default image for a pistol

**Does:**
  * _Inherits methods from Ranged.java_

## weapons.projectiles package

#### Projectile.java
**Is a:**
  * Is the generic projectile, which can be a bullet, an arrow, etc.

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
  * Image image
    * the picture of the bullet
  * double trajectory
    * the trajectory of the bullet in degrees

**Does:**
  * Draw itself
  * Generic "get" methods

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
    
**Does:**
  * _Inherits methods from Projectile.java_
  * Calls _super()_ constructor of Projectile.java

## entities package

#### LivingEntity.java
**Is a:**
  * Is an abstract class, which is a generic living entity, to be extended by both the Player class and all Monster classes.

**Has a:**
  * double maxHealth
	* maximum health that the entity can have, not likely to change
  * double health
	* current health the entity has
  * double movementSpeed
	* how quickly the entity can move
  * int x
	* current x-coordinate of the entity on the screen
  * int y
	* current y-coordinate of the entity on the screen

**Does:**
	* draws itself
	* has generic "get" methods to query the current state of instance variables

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

**Does:**
  * _inherits methods from LivingEntity class_
  * generic "get" methods to query targetX and targetY

#### Zombie.java
**Is a:**
  * Is a Monster, and represents the generic zombie enemy.

**Has a:**
  * int ZOMBIE_MAX_HEALTH
    * static final int, which defines the default zombie max health.
  * double ZOMBIE_MOVEMENT_SPEED
    * static final double, which defines default zombie movement speed.

## entities.friendlyEntities package

#### Player.java
**Is a:**
  * is a LivingEntity, and represents the user's character in the game.

**Has a:**
  * _inherits instance variables from LivingEntity class_
  * int points
	* the total number of points this player has, accumulates over time
  * int coins
	* the current amount of in-game currency the player has, functionality may be implemented later
  * gun
    * An instance of "Ranged" abstract class, of some kind of gun.

**Does:**
  * _inherits methods from LivingEntity class_
  * generic "get" commands to query points and coins
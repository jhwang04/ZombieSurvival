# CLASS LIST - ALPHA 1.0
### 4/29/2020

## src package

#### ZombieSurvivalMain.java
**Is a:** Main class, contains main method and little else.
**Has a:** N/A
**Does:** main(), which calls a new ZombieSurvivalGame

#### ZombieSurvivalGame.java
**Is a:** Game window for the final product. Includes all of the major bits and pieces for the game to run.
      	- Is also a JPanel
      	- Implements ActionListener
**Has a:**
	- int time
      	  - number of game ticks (20-50 per second, not decided yet.)
      	- Player player
      	  - The active player, that the user controls.
      	- int waveNumber
      	  - the wave number that the game is currently on.
**Does:**
	- starts a clock, that regulates the time between each game tick
      	- creates new java window, the graphics display for the game itself
      	- repaints the window every game tick

## weapons package

#### Ranged.java
**Is a:** Abstract class, represents all ranged weapons. Will be extended to be "pistol" or "rifle" or "bow & arrow".
**Has a:**
        - int range
      	  - range of a bullet
      	- double bulletSpeed
          - how quickly the projectile can travel
        - double bulletDamage
          - base damage for the projectile
        - Image bulletImage
      	  - image for the projectile
        - Image weaponImage
          - picture of the weapon itself.
**Does:**
	- can shoot a projectile
	- can draw itself
	- has generic "get" methods to query the current state of instance variables

## entities package

#### LivingEntity.java
**Is a:** Is an abstract class, which is a generic living entity, to be extended by both the Player class and all Monster classes.
**Has a:**
        - double maxHealth
	  - maximum health that the entity can have, not likely to change
	- double health
	  - current health the entity has
	- double movementSpeed
	  - how quickly the entity can move
	- int x
	  - current x-coordinate of the entity on the screen
	- int y
	  - current y-coordinate of the entity on the screen
**Does:**
	- draws itself
	- has generic "get" methods to query the current state of instance variables

## entities.monsters package

#### Monster.java
**Is a:** Is a LivingEntity, but is also an abstract class to be extended by specific monsters, such as Zombies.
**Has a:**
	- _inherits instance variables from LivingEntity class_
        - int targetX
	  - current x-coordinate of the monster's target, where it wants to go to.
	- int targetY
	  - current y-coordinate of the monster's target, where it wants to go to.
**Does:**
	- _inherits methods from LivingEntity class_
	- generic "get" methods to query targetX and targetY

## entities.friendlyEntities package

#### Player.java
**Is a:** is a LivingEntity, and represents the user's character in the game.
**Has a:**
        - _inherits instance variables from LivingEntity class_
	- int points
	  - the total number of points this player has, accumulates over time
	- int coins
	  - the current amount of in-game currency the player has, functionality may be implemented later
**Does:**
	- _inherits methods from LivingEntity class_
	- generic "get" commands to query points and coins
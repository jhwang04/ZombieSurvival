# CLASS LIST - ALPHA 1.0
##### 4/29/2020

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

## weapons package

#### Ranged
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
# Pac-Man Java Game

## Project Overview

This project is a custom Java implementation of the classic Pac-Man arcade game using object-oriented programming principles and a custom game engine structure. The game was adapted from a previous sprite-based project and expanded into a complete playable Pac-Man experience with multiple ghost AI behaviors, powerups, score tracking, lives, character selection, and level regeneration.

The game is built using Java Swing for rendering and keyboard input handling.

---

# Features

## Core Pac-Man Gameplay

The project includes the core mechanics of the original Pac-Man game:

- Maze-based movement
- Pellet collection
- Ghost enemies
- Score tracking
- Lives system
- Power pellets
- Regenerating levels

---

# Ghost AI System

The game contains multiple ghost movement behaviors implemented using the `GhostState` interface and state-based AI design.

## 1. Aggressive Ghost

The aggressive ghost continuously chases Pac-Man by comparing horizontal and vertical distances and prioritizing movement directions toward the player.

Behavior:
- Tracks Pac-Man directly
- Attempts alternative valid directions when blocked by walls
- Avoids unnecessary backtracking

---

## 2. Random Ghost

The random ghost moves unpredictably through the maze.

Behavior:
- Randomly changes direction
- Uses cooldown timers to avoid jittering
- Selects only valid movement directions
- Avoids immediate reverse movement when possible

---

## 3. Aggressive-Within-Range Ghost

This ghost behaves randomly until Pac-Man enters a specified detection radius.

Behavior:
- Random movement outside perimeter
- Aggressive chasing behavior inside perimeter
- Dynamically switches between AI modes

---

# Pellet System

## Standard Pellets

Standard pellets are placed throughout the maze.

Features:
- Increase score when collected
- Replace themselves with floor tiles after collection
- Remain in the environment list for rendering consistency

---

## Power Pellets

Power pellets activate frightened mode for ghosts.

Features:
- Increase score
- Trigger frightened ghost state
- Allow Pac-Man to eat ghosts temporarily
- Reverse normal ghost behavior

During frightened mode:
- Ghosts move randomly
- Pac-Man can consume ghosts for bonus points

---

# Powerup System

The game includes several additional custom powerups beyond the original Pac-Man gameplay.

---

## 1. Speed Boost Powerup

Effect:
- Doubles Pac-Man movement speed temporarily

Implementation:
- Modifies Pac-Man speed variable
- Uses timer-based duration handling

---

## 2. Invisibility Powerup

Effect:
- Ghosts ignore Pac-Man temporarily
- Aggressive ghosts revert to random movement behavior

Implementation:
- Ghost AI checks invisibility state
- Prevents normal chase behavior

---

## 3. Angry Ghosts Powerup

Effect:
- Forces all ghosts into aggressive chase mode temporarily

Implementation:
- Overrides each ghost's current AI state

---

## 4. Teleport Powerup

Effect:
- Instantly teleports Pac-Man to a random valid location in the maze

Implementation:
- Selects valid floor positions only
- Prevents teleporting into walls

---

# Character Selection

Before gameplay begins, the player can select between:

- Pac-Man
- Mrs. Pac-Man

Features:
- Separate sprite sheets
- Menu-based character selection system

---

# Lives and Game Over System

Pac-Man begins with 3 lives.

Features:
- Losing collision with ghosts removes a life
- Temporary immunity after respawn
- Game over state when lives reach zero
- Restart functionality from game over screen

---

# Level Regeneration

When all pellets are collected:

- The level resets
- Pellets respawn
- Ghosts respawn
- Pac-Man resets position
- Power states are cleared

This creates continuous arcade-style gameplay.

---

# Game States

The project uses a `GameState` enum to manage screens and gameplay flow.

States:
- MENU
- CHARACTER_SELECT
- PLAYING
- GAME_OVER

---

# Rendering System

The rendering engine is implemented using Java Swing.

Features:
- Sprite-based rendering
- Animated Pac-Man movement
- Directional ghost sprite rendering
- HUD display for:
  - Score
  - Lives
  - Active powerups

---

# Physics and Collision System

The project uses a custom collision engine.

Features:
- Axis-aligned rectangle collision detection
- Dynamic sprite movement
- Collision listener architecture
- Wall collision prevention
- Pellet and ghost interaction handling

---

# Object-Oriented Design

The project heavily uses object-oriented programming concepts.

Concepts used:
- Inheritance
- Interfaces
- Polymorphism
- State pattern
- Encapsulation

Examples:
- `Sprite -> SolidSprite -> DynamicSprite`
- `GhostState` AI implementations
- `PowerUp` abstract class hierarchy

---

# File Structure

## Main Components

### Core Game Classes
- `Game`
- `GameManager`
- `Main`

### Engines
- `RenderEngine`
- `PhysicEngine`
- `GameEngine`

### Sprites
- `Sprite`
- `DynamicSprite`
- `Pacman`
- `Ghost`
- `Pellet`
- `PowerPellet`

### Powerups
- `SpeedUp`
- `Invisibility`
- `AngryGhosts`
- `Teleport`

### AI States
- `AggressiveState`
- `RandomState`
- `AggCloseState`
- `FrightenedState`

---

# Controls

| Key | Action |
|---|---|
| Arrow Keys | Move Pac-Man |
| Enter | Start Game |
| 1 | Select Pac-Man |
| 2 | Select Mrs. Pac-Man |
| R | Restart after Game Over |

---

# Assets

The game uses:
- Sprite sheets
- Tile textures
- Maze text file level layout
# Pac-Man Style Game (Final Project)

## Overview
This project is a Java-based Pac-Man style game that demonstrates object-oriented programming principles including polymorphism, interfaces, and modular design. The game focuses on extensible entity behavior, multiple ghost patterns, and a power-up driven gameplay system.

---

## Features

### Core Gameplay
- Grid-based movement in a maze
- Pellet collection for scoring
- Level resets after all pellets are collected
- 3 lives before game over

### Ghost Behavior
Ghosts use different movement patterns:
- Aggressive: directly pursues the player
- Random: moves unpredictably
- Proximity-based: becomes aggressive when the player is nearby

### Power Pellets
- Temporarily reverse ghost behavior
- Allow the player to eat ghosts for points

### Power-Ups
- 2x speed boost
- Invisibility to ghosts
- Force all ghosts into aggressive mode
- Random teleport within the maze

### Character Selection
- Player can choose between Pac-Man and Ms. Pac-Man

---

## Design
The project uses:
- Polymorphism for game entities
- Strategy-based ghost movement behavior
- State changes for power-ups and ghost vulnerability

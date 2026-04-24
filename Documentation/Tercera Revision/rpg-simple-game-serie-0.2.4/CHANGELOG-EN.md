# Changelog

All notable changes to this project will be documented in this file.

The format is based on: 
[Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to: 
[Semantic Versioning](https://semver.org/spec/v2.0.0.html)

## [Unreleased]

## [0.0.0] - 15-09-2023 (100,0 %)

Creation the basic structure of the project.

**Video**: _N/A_

## [0.1.0] - 16-09-2023 (100,0 %)

Creation the basic structure of the game panel, which will contain the 
definitions of the basic properties of the game and the screen that will 
contain it, in turn we modify the main class of the application to execute this 
panel.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 1 - The Mechanism of 2D Games.mp4_

## [0.1.1] - 17-09-2023 (100,0 %)

Added to the execution panel the functionality of being executable (Runnable), 
that is, it offers the possibility of being playable (play), pauseable (pause) 
and stoppable (Stop), offering the basic functionality to be able to implement 
the life cycle of the game.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 1 - The Mechanism of 2D Games.mp4_

## [0.2.0] - 18-09-2023 (99,0 %)

Defined a first implementation of the game's life cycle, and establish the 
phases through which the game will go through with a basic detail of the 
different functionalities that we seek to cover within each of them. At first 
we start from two phases, a first of update, where we will update the
information of the different components of the game, and after this we have the
second, of drawing where from the information of the different components of 
the game we will paint these on the screen.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

## [0.2.1] - 19-09-2023 (99,3 %)

Started from the definition of phases proposed in the previous version, we 
develop each of the phases of the game's life cycle, on each of them we create 
the specific method that adds a minimum functionality to these methods.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

## [0.2.2] - 20-09-2023 (99,7 %)

Created a new class that allows us to manage keyboard usage, which will allow 
us to capture keyboard keystrokes and maintain a state of them.

With this new class we update the update phase to add interaction through the 
keyboard to the game panel, creating a small movement control, which will not 
be usable because it does not have a time control in the game's life cycle.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

## [0.2.3] - 21-09-2023 (99,7 %)

Added a small example to see the passage of time in the execution of the 
program and clearly understand why the previous execution behaves in the way 
een, it allows us to enter into the time control of the application's life 
cycle.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

## [0.2.4] - 22-09-2023 (97,9 %)

Implementation of time control for the life cycle.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

# Reflection

Add to this file to satisfy the "Reflection Updates" non-functional requirement
for this project. Please keep this document organized using Markdown. If you
click on this file in your team's GitHub repository website, then you will see
that the Markdown is transformed into nice looking HTML.



## TUES 2019-11-19 @ 11:55 PM EST

1. **DONE:** Downloaded the skeleton code of the project, read through the project description,
   wrote a scene graph for the two games we are going to create, and implemented the main application
   requirements (a basic set up fulfilling all the requirements). 

2. **TODO:** Finish the design of our main application, begin work on constructing
   each individual game, and work on the attributions for the images we have been
   using. 

3. **PROB:** At first, we had issues in regards to gitHub, mainly the problem with pushing
   and pulling each other's work without deleting any work we had done separately as well.
   With some practice, though, we were able to work through this problem and effectively
   utilize gitHub. 


## TUES 2019-11-26 @ 11:55 PM EST

1. **DONE:** Made a new text design for our main menu, which included making the text red
   and adding a shadow reflection. In addition, we imported the game boards for both tetris
   and mancala, setting the mancala game board to a wooden design and the tetris game
   board to a plain black fill. We wrote some pseudo code for the both games to try
   and eliminate any errors once we begin the implementation of both.

2. **TODO:** Begin implementing the code of the games to produce some functionality
   and work on the visual aspect of our main menu and the games itself. We also need
   to include attributions for any new images we have pulled from the internet.

3. **PROB:** We ran into some issues when attempting to set the backgrounds of the
   games, which took up a great deal of time. However, we realized that we were
   making a simple mistake. In addition, we ran into some issues trying to format
   our main menu, but after playing around with the different styles, we were able
   to overcome this issue.

## WED 2019-12-4 @ 11:55 PM EST

1. **DONE:** Implemented the main classes for the tetris game, which included
   one that forms the shapes that will be used in the game, the grid from which
   they will fall, and a randomization for their generation. We also decided that
   we might have an easier time to implement chess rather than mancala, as we are
   more familiar with this game.

2. **TODO:** Finish up the graphical portion of tetris and implement the classes
   in the start method for that game, and make a decision as to whether we will
   continue with mancala or start on tetris. We also need to put any new images
   gathered in the attributions file.

3. **PROB:** We were having issues when attempting to implement mancala, which
   is why we might change the game to chess. We ran into some issues when
   attempting to form the shapes for tetris, as we had to use the rectangle class;
   however, we were able to overcome this. We also ran into some issues with some
   of the graphical interface portion for tetris. These are all things we were able to
   overcome, or have a solution to do so in the upcoming days.

## WED 2019-12-11 @ 3:30 PN EST

1. **DONE:** Completed implementation of both games, as well as java docs for each
   class created and in line documentation. Attributions were updated for all
   outside sources, and each game is fully functioning.

2. **TODO:** NA

3. **PROB:** With tetris, we had some trouble getting the rotations and key pressed
   action events to work, however we discovered a null array that was causing
   this issue. For reversi, we had trouble with finding the possible spaces a
   player could move and determining which spaces flipped after a player moved.
   However, after rereading the rules of reversi and playing the game a few times
   online, we discovered that one needs to check in all 8 possible directions surrounding
   a singular game piece on the board to determine both things, as well as to check for
   the opponent's game piece placement as well as the player's itself.
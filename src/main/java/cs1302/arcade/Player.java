package cs1302.arcade;

/**
 * Represents a class which contains information in regards to a singular
 * player for the Reversi game. A player is represented by a color, in this
 * case cyan blue or white.
 */

public class Player {
    
    // declare variable
    public char color;
    
    /** 
     * Constructor for a player, which takes in a character
     * representing a color as a parameter. 
     * 
     * @param color a character which represents a color for which
     * a player's game piece will be filled. 
     */
    public Player (char color) {
        this.color = color; // initialize color for a player
    }
    
    /** 
     * A setter method, which sets a player's color to that 
     * specified in the parameter. 
     * 
     * @param color a character which represents a color for which 
     * a player's game piece will be filled. 
     */
    public void setColor(char color) {
        this.color = color; // set the color of the player
    }
    
    /**
     * A getter method, which returns the color of a player. 
     *
     * @return a char containing a player's color.
     */
    public char getColor() {
        return color; // return the color of the player
    }
    
}

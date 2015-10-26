/**
 * this class is used to make player objects which have the ability to add pieces to the board.
 * @author Noah Kaplan
 * @version 2.2
 */
public class Player {
    //the fields of a player
    //for the integer representation of color (0 = no color, 1 = player 1, color 2 = player 2 color)
    private int color;
    private String playerName;

    /**
     * overloaded constructor for player objects
     * @param co- the integer value of the players color
     * @param str- the string value of the players name
     */
    public Player(int co,String str){
        color = co;
        playerName = str;
    }

    /**
     * the add piece method is used to add a piece to the board. the location of the piece to be added is validated,
     * and then the 2d array of space objects is modified. Then back in the TurnControl class the Interface is recreated
     * with the new piece added
     * @param column-the column the piece will be added to
     */
    public void addPiece(int column){
        //if the color of the top row of this column is 0(not filled) proceed to find the lowest available space
        if(TurnControl.b.getColor(5,column) == 0) {
            //checking all the rows. the lowest available space gets set with this players color
            for (int row = 0; row < 6; row++) {
                if (TurnControl.b.getColor(row, column) == 0) {
                    TurnControl.b.setSpace(row, column, color);
                    //sets the location of the last move for the winnercheck class.
                    WinnerCheck.rowOfLastMove = row;
                    WinnerCheck.columnOfLastMove = column;
                    //set row = 6 so the loop is exited
                    row = 6;
                }
            }
        }
        //if the column is full set the turn number = turn number - 1, so that it stays this players turn
        else{
            TurnControl.turnNumber--;
        }

    }

    /**
     * accessor method for the players name
     * @return playerName- the string for the players name
     */
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String str){
        playerName = str;
    }
}


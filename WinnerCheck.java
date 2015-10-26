/**
  * The class definition file for winner check. there is no constructor, because this class is not used to make
  * object, but rather to be full of static methods and fields like gameWon (tells if the game has been won,
  * colorOfWinner(the integer representing the color of the winner) columnOfLastMove and rowOfLastMove
  * @author Noah Kaplan
  * @version 2.2
  */
public class WinnerCheck {
    //the fields of a WinnerCheck object
    public static boolean gameWon;
    public static int colorOfWinner;
    public static int columnOfLastMove;
    public static int rowOfLastMove;

    /**
     * a method for reseting all the fields. except colorOfWinner. it cant be reset because these fields need
     * to be reset in the turn control class before the FinishStatement window is created, and one of the parameters
     * for the FinishStatement constructor requires the name of the winner, which requires the color of the winner.
     * so instead, the last winners color remains the colorOfWinner until a new 4 in a row is made, and then it is changed
     * then.
     */
    public static void reset(){
        gameWon = false;
        columnOfLastMove = 0;
        rowOfLastMove = 0;
    }
    /**
     * The big method which checks for any winning combinations. Since we know the space of the last placed piece
     * (using the method above) and if four pieces were made to be in a row this turn, the last placed piece would
     * have to be one of the four, we can check the row of the last placed piece, the column of the last placed
     * placed piece, and the positive slope and negative slope diagonals of the last placed piece, and if four in
     * a row have the same color, that player is the winner
     * @param b- the 2d array with all the information about the board
     * @param color- the integer representing the color of the last person to move
     */
    public static void checkWinner(Space[][] b, int color){
        int inARow = 0;
        //for checking horizontal wins
        for(int c = 0; c <= 6; c++){
            //if a piece in the row has the same color as the player, 1 is added to the tally of pieces in a row
            if(b[rowOfLastMove][c].getColor() == color){
                inARow += 1;
            }
            //if a piece in the row is not the players color, the tally is reset to zero
            else{
                inARow = 0;
            }
            //if there are 4 in a row, we have a winner
            if(inARow == 4){
                gameWon = true;
                colorOfWinner = color;
            }
        }
        inARow = 0;
        //for checking vertical wins
        for(int r = 0; r <= 5; r++){
            //if a piece in the column has the same color as the player, 1 is added to the tally of pieces in a row
            if(b[r][columnOfLastMove].getColor() == color){
                inARow += 1;
            }
            //if a piece in the column is not the players color, the tally is reset to zero
            else{
                inARow = 0;
            }
            //if there are 4 in a row, we have a winner
            if(inARow == 4){
                gameWon = true;
                colorOfWinner = color;
            }
        }
        inARow = 0;
        /*
         * for checking diagonal wins
         * positive slope diagonals
         * we need to check at least 3 spaces south west of the last placed piece and 3 spaces north east of the last
         * placed piece because that would mean the newest piece was added at the very end of a run of 3 pieces.
         */
        for(int d = -3; d <= 3; d++){
            /*
             * we need to check that plugging in the values of diagonal points will not be outside the bounds of the
             * array, so before any values are checked, it is ensured that the values of the pieces being checked are
             * real values of the array. 0<row<6 and 0<column<7
             */
            if((rowOfLastMove + d <= 5) && (rowOfLastMove + d >= 0)&&(columnOfLastMove + d >= 0) && (columnOfLastMove + d <= 6)){
                if(b[rowOfLastMove + d][columnOfLastMove + d].getColor() == color){
                    inARow += 1;
                }
                else{
                    inARow = 0;
                }
            }
            if(inARow == 4) {
                gameWon = true;
                colorOfWinner = color;
            }
        }
        inARow = 0;
        /*
         * negative slope diagonals
         * we need to check at least 3 spaces north west of the last placed piece and 3 spaces south east of the last
         * placed piece because that would mean the newest piece was added at the very end of a run of 3 pieces.
         */
        for(int d = -3; d <= 3; d++){
            /*
             * we need to check that plugging in the values of diagonal points will not be outside the bounds of the
             * array, so before any values are checked, it is ensured that the values of the pieces being checked are
             * real values of the array. 0<row<6 and 0<column<7
             * note: the opposite of d is added to the column value of the last piece, because the slope of this diagonal
             * is negative
             */
            if((rowOfLastMove + d <= 5) && (rowOfLastMove + d >= 0)&&(columnOfLastMove - d >= 0) && (columnOfLastMove - d <= 6)){
                if(b[rowOfLastMove + d][columnOfLastMove - d].getColor() == color){
                    inARow += 1;
                }
                else{
                    inARow = 0;
                }
            }
            if(inARow == 4) {
                gameWon = true;
                colorOfWinner = color;
            }
        }
    }
}


/**
 * This class is in charge of deciding which players turn it is, as well as organizing the majority of the program
 * @author Noah Kaplan
 * @version 2.2
 */
public class TurnControl {
    //creating many static fields so that the values can be viewed and changed from anywhere
    public static boolean gameOver;
    public static Board b = new Board();
    public static int turnNumber = 1;
    public static Player p1 = new Player(1,HomeMenu.p1TF.getText());
    public static Player p2 = new Player(2,HomeMenu.p2TF.getText());
    public static UserInterface GUI;
    public static FinishStatement fs;

    /**
     * a method for resetting all the fields. used when the player restarts the game
     */
    public static void reset(){
        gameOver = false;
        b = new Board();
        turnNumber = 1;
    }

    /**
     * a method for setting the names of the players
     */
    public static void setNames(){
        p1.setPlayerName(HomeMenu.p1TF.getText());
        p2.setPlayerName(HomeMenu.p2TF.getText());
    }
    /**
     * the method that controls the flow of the game. a button is pressed, and then this method interprets
     * what that means. it keeps count of how many buttons have been pressed, so it knows whos turn it is, and
     * which player pressed the button. then it calls the addPiece method which add the piece to the board, and then
     * changes the GUI and checks if there is a winner
     * @param column the column of the last button pressed
     */
    public static void step(int column){
        //if its been an odd number of turns, player one pressed the button
        if (turnNumber % 2 == 1) {
            //adds the piece to the board
            p1.addPiece(column);
            //changes the look of the GUI
            GUI.setGrid(b.getGrid());
            //checks if player one has four in a row
            WinnerCheck.checkWinner(b.getGrid(),1);
        }
        //if it has been an even number of turns, player two pressed the button
        else {
            //adds piece to the board
            p2.addPiece(column);
            //changes the look of the GUI
            GUI.setGrid(b.getGrid());
            //checks if player two has four in a row
            WinnerCheck.checkWinner(b.getGrid(), 2);
        }
        //if a player has four in a row
        if(WinnerCheck.gameWon == true){
            //create the finished game GUI with the message of the winner
            fs = new FinishStatement((WinnerCheck.colorOfWinner==1? p1.getPlayerName():p2.getPlayerName()) + " is the winner",p1.getPlayerName(),p2.getPlayerName());
        }
        //if the board is full and nobody has won
        if(b.checkFull() == true && WinnerCheck.gameWon == false){
            //create the finished game GUI with the message that there is no winner
            fs = new FinishStatement("The board is filled with no winner",p1.getPlayerName(),p2.getPlayerName());
        }
        //increment up one so its the next players turn
        turnNumber++;
    }
}

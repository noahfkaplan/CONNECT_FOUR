/**
 * Created by Noah on 10/19/2015.
 */
public class Driver {
    public static void main(String args[]) {
        Board b = new Board();
        UserInterface GUI = new UserInterface();
        boolean cont = true;
        int turnNumber = 1;
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        WinnerCheck check = new WinnerCheck();
        while (cont == true) {
            if (turnNumber % 2 == 1) {
                b = p1.takeTurn(b);
                GUI.setGrid(b.getGrid());
                check.setLocationOfLastMove(p1.getRowOfLastMove(),p1.getColumnOfLastMove());
                check.checkWinner(b.getGrid(), 1);
            }
            else {
                b = p2.takeTurn(b);
                GUI.setGrid(b.getGrid());
                check.setLocationOfLastMove(p2.getRowOfLastMove(),p2.getColumnOfLastMove());
                check.checkWinner(b.getGrid(), p2.getColor());
            }
            if (b.checkFull() == true || check.getGameWon() == true) {
                cont = false;
            }
            turnNumber++;
        }
        if(check.getGameWon() == true){
            System.out.println("Player " + check.getColorOfWinner() + " wins");
        }
        else{
            System.out.println("The board was filled with no winner");
        }
    }
}

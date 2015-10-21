/**
 * Created by Noah on 10/19/2015.
 */
import java.util.*;
public class Player {
    private int color;
    public Player(int co){
        color = co;
    }
    public Board takeTurn(Board b){
        System.out.print("Player " + color + " select a column: ");
        Space grid[][] = b.getGrid();
        Scanner input = new Scanner(System.in);
        int column = input.nextInt() - 1;
        int row = b.checkColumnFull(column);
        if(row == -1) {
            System.out.println("That column is full, Try Again");
            takeTurn(b);
        }
        else {
            grid[row][column].setColor(color);
            b.setGrid(grid);
        }
        return b;
    }
    public int getColor(){
        return color;
    }
}

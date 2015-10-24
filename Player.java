/**
 * Created by Noah on 10/19/2015.
 */
import java.util.*;
public class Player {
    private int color;
    public Player(int co){
        color = co;
    }
    public void addPiece(int column){
        if(TurnControl.b.getColor(5,column) == 0) {
            for (int row = 0; row < 6; row++) {
                if (TurnControl.b.getColor(row, column) == 0) {
                    TurnControl.b.setSpace(row, column, color);
                    TurnControl.check.setLocationOfLastMove(row, column);
                    row = 6;
                }
            }
        }
        else{
            TurnControl.turnNumber--;
        }

    }
    public int getColor(){
        return color;
    }
}

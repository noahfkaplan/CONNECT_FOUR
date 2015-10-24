
/**
 * Created by Noah on 10/19/2015.
 */
public class Space {
    private int row;
    private int column;
    private int color;

    /**
     * the overloaded constructor
     * @param r the row of the space in the grid
     * @param c the column of the space in the grid
     * @param co the color of the space (0=empty,1=red,2=black)
     */
    public Space(int r, int c, int co){
        row = r;
        column = c;
        color = co;
    }

    /**
     * accessor method for the color of the space
     * @return color, the color of the space
     */
    public int getColor(){
        return color;
    }

    /**
     * mutator method for setting the color of the space
     * @param co the color for the space to be changed to
     */
    public void setColor(int co){
        color = co;
    }
}

/**
 * this class creates the board object which creates the 2d array where the data will be stored
 * and is able to modify the data
 * @author Noah Kaplan
 * @version 2.2
 */
public class Board {
    //the only field of the Board object is the 2d array filled with Space objects
    private Space[][] grid;

    /**
     * a constructor method for the board object. fills the 2d array with space objects
     */
    public Board() {
        //a connectFour game has 6 rows and 7 columns so our 2d array should have the same
        grid = new Space[6][7];
        //filling the grid
        for (int r = 0; r <= 5; r++) {
            for (int c = 0; c <= 6; c++) {
                //creating a space object for each spot in the 2d array with 0 as the color
                grid[r][c] = new Space(r, c, 0);
            }
        }
    }

    /**
     * a method for checking each object to see if there are any spaces left without a color
     * @return boolean-true:the board is full, false:the board is not full
     */
    public boolean checkFull(){
        for (int r = 0; r <= 5; r++) {
            for (int c = 0; c <= 6; c++) {
                //if any Space object in the array has the color 0, it is considered empty
                if(grid[r][c].getColor() == 0){
                    return false;
                }
            }
        }
        //if none of the space objects had the color 0, the board is full, and true is returned
        return true;
    }
    /**
     * accessor method for the 2d array of space objects
     * @return grid-the 2d array of space objects which stores the board components
     */
    public Space[][] getGrid(){
        return grid;
    }
    /**
     * accessor method that returns the color of a space of a specified row and column
     * @param r the row of the space to be checked
     * @param c the column of the space to be checked
     * @return an integer of the color (0=empty, 1=red, 2=black) of the space
     */
    public int getColor(int r, int c){
        return grid[r][c].getColor();
    }
    /**
     * mutator method for any space in the grid.
     * @param r the row of the piece to be changed
     * @param c the column of the piece to be changed
     * @param co the color the piece will be changed to
     */
    public void setSpace(int r, int c, int co){
        grid[r][c].setColor(co);
    }
}


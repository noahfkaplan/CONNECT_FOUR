/**
 * Created by Noah on 9/11/2015.
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
    public int checkColumnFull(int column){
        for(int r = 0; r <= 5; r++){
            if(grid[r][column].getColor() == 0) {
                return r;
            }
        }
        return -1;
    }
    /**
     * accessor method for the 2d array of space objects
     * @return grid-the 2d array of space objects which stores the board components
     */
    public Space[][] getGrid(){
        return grid;
    }

    /**
     * mutator method for changing the grid. the 2d array is changed outside the class, and then the new 2d
     * array is returned and stored as "grid"
     * @param g-takes in a 2d array, and sets the grid equal to the data found in the imported array
     */
    public void setGrid(Space[][] g){
        grid = g;
    }
}

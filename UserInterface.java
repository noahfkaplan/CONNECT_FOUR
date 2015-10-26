//importing the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * this class creates the user interface. the board that shows us where the data is stored in the grid. data is added
 * to the board through the use of the JButtons that form the grid
 * @author Noah Kaplan
 * @version 2.2
 */
public class UserInterface extends JFrame{
    //the only field of my interface class is a 2d array of jbuttons which will act as the pieces on the board
    private JButton[][] buttonGrid;
    private JPanel[][] panelGrid;
    private Color player1;
    private Color player2;
    /**
     * overloaded constructor method for the interface
     * @param p1-the color of player 1
     * @param p2- the color of player 2
     */
    public UserInterface(Color p1,Color p2){
        //setting up the window
        super("Connect Four-GameInterface");
        final int WINDOW_WIDTH = 683;
        final int WINDOW_HEIGHT = 768;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setting the Color object fields to the color that is taken as parameters
        player1 = p1;
        player2 = p2;
        //setting the layout to a grid 6 tall and 7 wide
        setLayout(new GridLayout(6, 7));
        //making the 2d array of buttons 6 tall and 7 wide
        buttonGrid = new JButton[6][7];
        panelGrid = new JPanel[6][7];
        //creating and adding the buttons to the interface
        for(int r = 5; r >= 0; r--) {
            for (int c = 0; c <= 6; c++) {
                //creating a panel to put each button on
                JPanel panel = new JPanel();
                panel.setBackground(Color.YELLOW);
                //creating the buttons
                JButton button = new JButton("");
                button.setBackground(Color.WHITE);
                button.setPreferredSize(new Dimension(60, 60));
                button.addActionListener(new ButtonListener());
                //adding the buttons and panels to the arrays
                buttonGrid[r][c] = button;
                panelGrid[r][c] = panel;
                //adding the panels to the window, and adding the buttons to the panels
                add(panel);
                panel.add(button);
            }
        }
        setVisible(true);
    }

    /**
     * setting the grid to show the colors represented by the 2d array of space objects
     * @param grid- a 2d array of spaces. the color of each space is accessed, and used to set the color of the JButtons
     */
    public void setGrid(Space[][] grid){
        for(int r = 0; r <= 5; r++){
            for(int c = 0; c <= 6; c++){
                //if the color of the space object at any location = 1, set the button of that location to red
                if(grid[r][c].getColor() == 1){
                    buttonGrid[r][c].setBackground(player1);
                }
                //if the color of the space object at any location = 2, set the button of that location to black
                if(grid[r][c].getColor() == 2){
                    buttonGrid[r][c].setBackground(player2);
                }
            }
        }
    }

    /**
     * the class that listens to all the buttons in the window
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            //checks all the buttons to see  which one called this method
            for(int r = 0; r < 6; r++) {
                for (int c = 0; c < 7; c++) {
                    /*
                     * if the button that called the method represents an empty space and the game is not over,
                     * call the step method in the turn control class, which checks to make sure it is a valid
                     * move, checks to see if there is a winner, and proceed based on that information
                     */
                    if(e.getSource() == buttonGrid[r][c] && TurnControl.b.getColor(r,c)==0 && WinnerCheck.gameWon == false){
                        TurnControl.step(c);
                    }
                }
            }
        }
    }
}


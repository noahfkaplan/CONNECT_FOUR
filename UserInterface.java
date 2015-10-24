/**
 * Created by Noah on 9/13/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame{
    //the only field of my interface class is a 2d array of jbuttons which will act as the pieces on the board
    private JButton[][] buttonGrid;
    private JPanel[][] panelGrid;
    private Color player1;
    private Color player2;
    /**
     * constructor method for the interface
     */
    public UserInterface(Color p1,Color p2){
        super("Connect Four");
        player1 = p1;
        player2 = p2;
        //setting the layout to a grid 6 tall and 7 wide
        setLayout(new GridLayout(6,7));
        //setting the width and height of the window
        final int WINDOW_WIDTH = 683;
        final int WINDOW_HEIGHT = 768;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //making the 2d array of buttons 6 tall and 7 wide
        buttonGrid = new JButton[6][7];
        panelGrid = new JPanel[6][7];
        //creating and adding the buttons to the interface
        for(int r = 5; r >= 0; r--) {
            for (int c = 0; c <= 6; c++) {
                JLabel columnLabel = new JLabel();
                JPanel panel = new JPanel();
                panel.setBackground(Color.YELLOW);
                JButton button = new JButton("");
                button.setBackground(Color.WHITE);
                button.setPreferredSize(new Dimension(60, 60));
                button.addActionListener(new ButtonListener());
                //putting the number that needs to be inputted in the bottom button of each column
                if(r == 0){
                    button.setText(""+ (c+1));
                }
                buttonGrid[r][c] = button;
                panelGrid[r][c] = panel;
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
    private class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            //Execute when button is pressed
            for(int r = 0; r < 6; r++) {
                for (int c = 0; c < 7; c++) {
                    if(e.getSource() == buttonGrid[r][c] && TurnControl.b.getColor(r,c)==0 && TurnControl.gameOver == false){
                        TurnControl.step(c);
                    }
                }
            }


        }
    }
}

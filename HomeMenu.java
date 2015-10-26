//importing the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * the home menu class. The majority of the code in this class is used to make the home screen aesthetically pleasing
 * to make the layout how it is, I made a main panel that is subdivided into a grid of 9 panels. the middle top panel
 * has the game title in it "Connect four". The left-center panel and the right-center panel both have colored buttons
 * and a text field. The user edits the textfields to be the names of player one and two, and then selects the color that
 * the player is represented by on the board. The bottom center panel has the start button that when pressed launches the
 * game through the UserInterface class, and finally in the bottom right panel there is a label that states the version
 * number
 * @author Noah Kaplan
 * @version 2.2
 */
public class HomeMenu extends JFrame {
    /*
     * the fields of the HomeMenu class
     */
    private JButton[] colorButtons1 = new JButton[5];
    private JButton[] colorButtons2 = new JButton[5];
    private Color player1;
    private Color player2;
    //an array of color object I made that made selecting colors easier
    private Color[] colors;
    public static TextField p1TF;
    public static TextField p2TF;
    /**
     * overloaded constructor of the HomeMenu object
     * @param p1Name- the name of the player. if this is the first time a HomeMenu object is created, the parameters
     *                passed are "player 1" and "player 2". After they are changed and a game is played, the names are
     *                stored and then passed back into this constructor method.
     * @param p2Name- same as above, except with the second players name
     */
    public HomeMenu(String p1Name, String p2Name) {
        //setting up the basic dimensions of the window
        super("Connect Four-HomeMenu ");
        final int WINDOW_WIDTH = 400;
        final int WINDOW_HEIGHT = 300;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //default button colors
        player1 = Color.RED;player2 = Color.BLACK;
        //creating the main panel to have a 3 by 3 grid layout
        JPanel mainPanel = new JPanel(new GridLayout(3,3));
        /*
         *creating a 3-3 2d array of panels. the main panel is divided into a 3-3 grid, so a panel from the
         *secondaryPanels array is added to the main panel.
         */
        JPanel secondaryPanels[][] = new JPanel[3][3];
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                secondaryPanels[r][c] = new JPanel();
                secondaryPanels[r][c].setBackground(Color.yellow);
                mainPanel.add(secondaryPanels[r][c]);
            }
        }
        /*
         * the title panel (first row, second column) this panel is divided into two panels(2 rows 1 column) and the
         * word "connect" is in the upper panel and "four" in the lower panel
         */
        secondaryPanels[0][1].setLayout(new GridLayout(2,1));
        JLabel topTitle = new JLabel("Connect",SwingConstants.CENTER);
        JLabel bottomTitle = new JLabel("Four",SwingConstants.CENTER);
        topTitle.setFont(new Font("Courier New", Font.BOLD, 28));
        bottomTitle.setFont(new Font("Courier New", Font.BOLD, 28));
        secondaryPanels[0][1].add(topTitle);
        secondaryPanels[0][1].add(bottomTitle);
        /*
         * creating the textfield that the user will type their name into. the color of the text is set to the Color
         * object that the player is defined by. This will be changed when any of the color buttons are pressed
         *
         */
        p1TF = new TextField(p1Name);
        p1TF.setFont(new Font("Courier New", Font.BOLD, 14));
        p1TF.setForeground(player1);
        p2TF = new TextField(p2Name);
        p2TF.setFont(new Font("Courier New", Font.BOLD, 14));
        p2TF.setForeground(player2);
        /*
         * setting up the layout of the secondary panel in the second row, and first column. It is going to have a
         * grid layout with 2 rows and 1 column. in the top row, another JPanel will be added, and the text field with
         * player 1's name in it will be added to that panel. on the bottom row, another JPanel will be added with
         * 1 row and 5 columns. each column will have a different one of the colored buttons in each.
         */
        secondaryPanels[1][0].setLayout(new GridLayout(2, 1, 0, 30));
        JPanel upperLeftMid = new JPanel();
        upperLeftMid.add(p1TF);
        JPanel lowerLeftMid = new JPanel(new GridLayout(1,5,5,0));
        secondaryPanels[1][0].add(upperLeftMid).setBackground(Color.yellow);
        secondaryPanels[1][0].add(lowerLeftMid).setBackground(Color.yellow);
        /*
         * this is setting up the layout of the secondary panel in the 2nd row and third column. It is set up in the same
         * way as the secondary panel in the 2nd row and 1st column, but the text field and buttons are for player 2
         */
        secondaryPanels[1][2].setLayout(new GridLayout(2, 0, 0, 30));
        JPanel upperRightMid = new JPanel();
        upperRightMid.add(p2TF);
        JPanel lowerRightMid = new JPanel(new GridLayout(1,5,5,0));
        secondaryPanels[1][2].add(upperRightMid).setBackground(Color.yellow);
        secondaryPanels[1][2].add(lowerRightMid).setBackground(Color.yellow);
        /*
         * making the array of color objects. the color objects and the buttons will have the same array index. this
         * will make accessing this data much easier in the future
         */
        colors = new Color[5];
        //filling the array with color objects
        colors[0] = Color.RED;colors[1]=Color.BLACK;colors[2]=Color.BLUE;colors[3]=Color.GREEN;colors[4]=Color.MAGENTA;
        /*
         * creating the color JButtons for player 1.
         */
        for(int count = 0; count <=4; count++){
            colorButtons1[count] = new JButton("");
            colorButtons1[count].setBackground(colors[count]);
            colorButtons1[count].addActionListener(new colorButtonListener1());
            lowerLeftMid.add(colorButtons1[count]);
        }
        /*
         * creating the color JButtons for player 2.
         */
        for(int count = 0; count <=4; count++){
            colorButtons2[count] = new JButton("");
            colorButtons2[count].setBackground(colors[count]);
            colorButtons2[count].addActionListener(new colorButtonListener2());
            lowerRightMid.add(colorButtons2[count]);
        }
        /*
         * creating the start button. It is stored in the main panel in the (3rd row, 2nd column). the secondary
         * panel in the 3rd row and 2nd column of the main panel is split into three rows one column, and the button is
         * put in the middle row. this is for spacing/aesthetic purposes only
         */
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());
        secondaryPanels[2][1].setLayout(new GridLayout(3,1));
        //adding a blank JPanel to the first row so that the button can go in the second (and center) row.
        secondaryPanels[2][1].add(new JPanel()).setBackground(Color.yellow);
        secondaryPanels[2][1].add(startButton);
        /*
         * setting up the layout for the secondary panel in the 3rd row and 3rd column (the bottom right). All this
         * panel will have is the version number.
         */
        secondaryPanels[2][2].setLayout(new BorderLayout());
        //adding a label to the SOUTH border and using the swingConstants class to set it up against the right side
        secondaryPanels[2][2].add(new JLabel("Version 2.2", SwingConstants.RIGHT), BorderLayout.PAGE_END);
        //adding the main panel to the window
        add(mainPanel);
        //setting the window visible
        setVisible(true);
    }

    /**
     * this class listens to the Start button and calls its actionPerformed method when the button is pressed
     */
    private class StartButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            //setting the player names to the last text that was in the text fields
            TurnControl.setNames();
            //when the start button is pressed, create the User interface object
            TurnControl.GUI = new UserInterface(player1,player2);
            //hide the current window
            setVisible(false);
        }
    }

    /**
     * this class listens to the color buttons on the left side of the screen (player 1's color buttons) and calls the
     * actionPerformed method when any of the buttons are pressed
     */
    private class colorButtonListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            /*
             * a loop that will check to see if the source of the button has the same object location as the
             * color button at the "count" index in the array of buttons
             */
            for(int count = 0; count <= 4; count++){
                //if the source is a button and the color of that button is not the color of player2
                if(e.getSource() == colorButtons1[count] && colors[count] != player2){
                        //player 1's color is set to the color of the button that called this method
                        player1 = colors[count];
                        //the text field with player 1's name is set to the color of the button that was pressed
                        p1TF.setForeground(colors[count]);
                }
            }
        }
    }
    /**
     * this class listens to the color buttons on the left side of the screen (player 1's color buttons) and calls the
     * actionPerformed method when any of the buttons are pressed. the comments from colorButtonListener1 are the same
     * as the comments for this class.
     */
    private class colorButtonListener2 implements ActionListener{
        public void actionPerformed(ActionEvent d){
            for(int count = 0; count <= 4; count++){
                if(d.getSource() == colorButtons2[count] && colors[count] != player1){
                    player2 = colors[count];
                    p2TF.setForeground(colors[count]);
                }
            }
        }
    }

    /**
     * returns the names of the player. this is used to get the name of the player, and store it in the name field of
     * the player class.
     * @param playerNumber the number of the players color (integer value 1:player 1 2:player 2)
     * @return the name of the player
     */
    public static String getTextFieldWinner(int playerNumber){
        if(playerNumber == 1){
            return p1TF.getText();
        }
        else{
            return p2TF.getText();
        }
    }
    /**
     * this is the main method. where the application begins. a HomeMenu object is created with the player names set as
     * "player 1" and "player 2"
     */
    public static void main(String args[]){
        new HomeMenu("Player 1", "Player 2");
    }
}


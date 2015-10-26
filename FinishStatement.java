//importing the necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * this class is responsible for creating the window that displays who won the game, and gives the user the
 * option to quit, or restart the game
 * @author Noah Kaplan
 * @version 2.2
 */
public class FinishStatement extends JFrame {
    //the two fields of this class, the names of the two players
    private String p1Name;
    private String p2Name;

    /**
     * the overloaded constructor for FinishStatement objects
     * @param str the message that will be displayed about who won
     * @param p1 the name of the first player
     * @param p2 the name of the second player
     */
    public FinishStatement(String str,String p1, String p2){
        //setting the basic parts of the window
        super("Connect Four-GameOverScreen");
        final int WINDOW_WIDTH = 400;
        final int WINDOW_HEIGHT = 150;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setting the names of the players
        p1Name = p1;
        p2Name = p2;
        //creating the main panel with a gridlayout of two panels(2 rows, 1 column)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        //creating the secondary panel that will be on top. Will only display the message
        JPanel topSecondaryPanel = new JPanel();
        mainPanel.add(topSecondaryPanel).setBackground(Color.yellow);
        JLabel title = new JLabel(str);
        title.setFont(new Font("Courier New", Font.CENTER_BASELINE, 24));
        topSecondaryPanel.add(title);
        //creating the secondary panel that will be on the bottom. Has the two buttons "retry" and "quit"
        JPanel bottomSecondaryPanel = new JPanel(new FlowLayout());
        mainPanel.add(bottomSecondaryPanel).setBackground(Color.yellow);
        JButton retryButton = new JButton("Play Again");
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new quitButtonListener());
        retryButton.addActionListener(new retryButtonListener());
        bottomSecondaryPanel.add(retryButton);
        bottomSecondaryPanel.add(quitButton);
        //adding the main panel containing all the other panels to the window
        add(mainPanel).setBackground(Color.yellow);
        setVisible(true);
    }
    /**
     * a class that listens to the quit button. when pressed, the system exits
     */
    private class quitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    /**
     * a class that listens to the retry button. when pressed, the FinishStatement window is hidden, the finished
     * game window is hidden, and a new home menu is created, passing the two players names as its parameters
     */
    private class retryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            TurnControl.GUI.setVisible(false);
            new HomeMenu(p1Name, p2Name);
            //reset the game
            TurnControl.reset();
            WinnerCheck.reset();
        }
    }
}


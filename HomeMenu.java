import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Noah on 10/22/2015.
 */
public class HomeMenu extends JFrame {
    /**
     * default constructor
     */
    private JButton[] colorButtons1 = new JButton[5];
    private JButton[] colorButtons2 = new JButton[5];
    private Color player1;
    private Color player2;
    private Color[] colors;
    public static TextField p1TF;
    public static TextField p2TF;

    public HomeMenu() {
        super("Connect Four");
        //default button colors
        player1 = Color.RED;player2 = Color.BLACK;
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final int WINDOW_WIDTH = 625;
        final int WINDOW_HEIGHT = 400;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Connect Four");
        title.setFont(new Font("Courier New", Font.BOLD,48));
        JButton startButton = new JButton("Start");
        p1TF = new TextField("Player 1");
        p1TF.setFont(new Font("Courier New", Font.BOLD, 20));
        p1TF.setForeground(player1);
        p2TF = new TextField("Player 2");
        p2TF.setFont(new Font("Courier New", Font.BOLD, 20));
        p2TF.setForeground(player2);
        JPanel colorsPanel = new JPanel(new GridLayout(2,6,5,25));
        startButton.addActionListener(new StartButtonListener());
        panel.add(title, BorderLayout.NORTH);

        colors = new Color[5];
        colors[0] = Color.RED;colors[1]=Color.BLACK;colors[2]=Color.BLUE;colors[3]=Color.GREEN;colors[4]=Color.MAGENTA;
        colorsPanel.add(p1TF);
        for(int count = 0; count <=4; count++){
            colorButtons1[count] = new JButton("");
            colorButtons1[count].setBackground(colors[count]);
            colorButtons1[count].addActionListener(new colorButtonListener1());
            colorsPanel.add(colorButtons1[count]);
        }
        colorsPanel.add(p2TF);
        for(int count = 0; count <=4; count++){
            colorButtons2[count] = new JButton("");
            colorButtons2[count].setBackground(colors[count]);
            colorButtons2[count].addActionListener(new colorButtonListener2());
            colorsPanel.add(colorButtons2[count]);
        }
        panel.add(colorsPanel,BorderLayout.CENTER);
        panel.add(startButton,BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }

    private class StartButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            //Execute when button is pressed
            TurnControl.GUI = new UserInterface(player1,player2);
            setVisible(false);
        }
    }
    public static void main(String args[]){
        HomeMenu menu = new HomeMenu();
    }

    private class colorButtonListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int count = 0; count <= 4; count++){
                if(e.getSource() == colorButtons1[count] && colors[count] != player2){
                        player1 = colors[count];
                        p1TF.setFont(new Font("Courier New", Font.BOLD, 20));
                        p1TF.setForeground(colors[count]);
                }
            }
        }
    }
    private class colorButtonListener2 implements ActionListener{
        public void actionPerformed(ActionEvent d){
            for(int count = 0; count <= 4; count++){
                if(d.getSource() == colorButtons2[count] && colors[count] != player1){
                    player2 = colors[count];
                    p2TF.setFont(new Font("Courier New", Font.BOLD, 20));
                    p2TF.setForeground(colors[count]);
                }
            }
        }
    }
    public static String getTextFieldWinner(int playerNumber){
        if(playerNumber == 1){
            return p1TF.getText();
        }
        else{
            return p2TF.getText();
        }
    }
}

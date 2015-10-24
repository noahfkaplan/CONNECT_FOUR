import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Noah on 10/23/2015.
 */
public class FinishStatement extends JFrame {
    public FinishStatement(String str){
        super("Connect Four");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        final int WINDOW_WIDTH = 625;
        final int WINDOW_HEIGHT = 300;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel(str);
        JButton retryButton = new JButton("Play Again");
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new quitButtonListener());
        retryButton.addActionListener(new retryButtonListener());
        panel.add(title);
        panel.add(retryButton);
        panel.add(quitButton);
        add(panel);
        setVisible(true);
    }
    private class quitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    private class retryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            TurnControl.GUI.setVisible(false);
            HomeMenu menu = new HomeMenu();
        }
    }
}

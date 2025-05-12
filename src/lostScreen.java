import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lostScreen implements ActionListener {
    static private JFrame frame = new JFrame("More or less, Less is more");
    static private JPanel panel = new JPanel();
    static private JPanel panel1 = new JPanel();
    static private JLabel label = new JLabel("You have lost the game!");

    static private JButton exit = new JButton("Exit");
    static private JButton playAgain = new JButton("Play again?");
    static private JLabel Comment = new JLabel("The playAgain button doesnt work, it goes to the menu you click again to play but it gives the game grid2x and it bugs!!");
    static private JPanel Companel = new JPanel();

    public static void LostScreen() {
        frame.setBounds(30, 30, 30, 30);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(1, 2));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.add(label);
        panel.add(exit);
        exit.addActionListener(new lostScreen());
        panel.add(playAgain);
        playAgain.addActionListener(new lostScreen());
        Companel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Companel.add(Comment);
        frame.add(Companel, BorderLayout.PAGE_END);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();
        } else if (e.getSource()==playAgain) {
            frame.dispose();
            Main.mainMenu();
        }
        }

    }



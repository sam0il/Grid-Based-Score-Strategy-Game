import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class winingScreen implements ActionListener {
   static private JFrame Wframe = new JFrame("More or less, Less is more");
   static private JPanel Wpanel = new JPanel();
   static private JLabel Wlabel = new JLabel("You have won the game!!");
   static private JButton GG = new JButton("GG!");
   static private JLabel deviationScore = new JLabel("Deviation:"+(Grid.sum - Grid.SCR));

    public static void WiningScreen() {
    Wframe.setBounds(70,70,70,70);
    Wpanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
    Wpanel.setLayout(new GridLayout(0,1));
    Wpanel.add(Wlabel);
    Wlabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    Wpanel.add(GG);
    Wpanel.add(deviationScore);
    GG.addActionListener(new winingScreen());
    Wframe.add(Wpanel,BorderLayout.CENTER);
    Wframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Wframe.pack();
    Wframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==GG){
            Wframe.dispose();

        }
    }
}

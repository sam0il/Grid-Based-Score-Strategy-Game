import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
public class Main implements ActionListener {
    private static JLabel title = new JLabel("More or less, Less is more");
    private static  JPanel pannel = new JPanel();
    private static  JPanel pannel1 = new JPanel();
    private static JPanel pannel2 = new JPanel();
    private static  JFrame frame = new JFrame("More or Less, Less is More");
    private static JButton easy = new JButton("Easy");
    private static JButton medium = new JButton("Medium");
    private static JButton hard = new JButton("Hard");
    private static JButton play = new JButton("Play");
    private static boolean ez=false;
    private static boolean m=false;
    private static boolean h=false;
    private static Grid GameG;


    public static void mainMenu() {
        frame.setBounds(100, 200, 400, 500);
        pannel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        pannel.setLayout(new GridLayout(0, 3));
        easy.addActionListener(new Main());
        Color easyColor = new Color(255, 255, 255);
        easy.setBackground(easyColor);
        medium.addActionListener(new Main());
        Color mediumColor = new Color(255,255,255);
        medium.setBackground(mediumColor);
        hard.addActionListener(new Main());
        Color hardColor = new Color(255, 255, 255);
        hard.setBackground(hardColor);
        pannel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        title.setFont(labelFont);
        pannel1.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        play.addActionListener(new Main());
        play.setPreferredSize(new Dimension(70,30));


        pannel2.add(title);
        pannel1.add(play);
        pannel.add(easy);
        pannel.add(medium);
        pannel.add(hard);
        frame.add(pannel2,BorderLayout.NORTH);
        frame.add(pannel1,BorderLayout.CENTER);
        frame.add(pannel,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==easy){
            Color easyColor = new Color(0, 255, 0);
            easy.setBackground(easyColor);
            Color mediumColor = new Color(255,255,255);
            medium.setBackground(mediumColor);
            Color hardColor = new Color(255, 255, 255);
            hard.setBackground(hardColor);

            ez=true;
            m=false;
            h=false;

        } else if (e.getSource()==medium) {
            Color easyColor = new Color(255, 255, 255);
            easy.setBackground(easyColor);
            Color mediumColor = new Color(255,255,0);
            medium.setBackground(mediumColor);
            Color hardColor = new Color(255, 255, 255);
            hard.setBackground(hardColor);

            ez=false;
            m=true;
            h=false;

        } else if (e.getSource()==hard) {
            Color easyColor = new Color(255, 255, 255);
            easy.setBackground(easyColor);
            Color mediumColor = new Color(255,255,255);
            medium.setBackground(mediumColor);
            Color hardColor = new Color(255, 0, 0);
            hard.setBackground(hardColor);

            ez=false;
            m=false;
            h=true;


        }
    if (e.getSource()==play){
        if (ez==true){
            GameG=new Grid(10, 1 );
            frame.dispose();
        } else if (m==true) {
            GameG=new Grid(10, 2);
            frame.dispose();

        } else if (h==true) {
            GameG=new Grid(10, 3);
            frame.dispose();
        }
    }

    }
}

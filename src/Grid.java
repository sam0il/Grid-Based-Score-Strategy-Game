import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public  class Grid {
    static private JFrame frame = new JFrame("More or Less, Less is More");
    static private JPanel panel = new JPanel();
    static private JLabel scores = new JLabel("Total Score: " );
    private static JLabel moves;
    static private JPanel panel1 = new JPanel();
    static private JLabel score = new JLabel("Current Score: ");
    static private JPanel game;
    private static Random random = new Random();
    private static int NumMoves;
    public static int sum=0;
    public static int SCR=0;
    private static int previous=0;


    Grid (int n, int nMoves) {
        game = new JPanel();
        if (nMoves == 1){
            NumMoves=15;
            SCR=40;
        } else if (nMoves==2) {
            NumMoves=10;
            SCR=45;
        } else if (nMoves == 3) {
            NumMoves=8;
            SCR=50;
        }
        scores = new JLabel("Total Score: " +SCR);
        moves = new JLabel("Total Moves left: "+NumMoves);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(moves);
        panel.add(scores);
        moves.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        scores.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
        panel1.add(score);
        game.setLayout(new GridLayout(n,n));
        for (int i = 1; i <= n * n; i++) {
            int randomNum = random.nextInt(1,10);
            JButton button = new JButton();
            button.setText(Integer.toString(randomNum));
            button.setPreferredSize(new Dimension(75,75));
            game.add(button);
            button.setActionCommand(""+i);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sum+= randomNum;
                    score.setText("Current sum: "+sum);
                    NumMoves--;
                    moves.setText("Total Moves left: " +NumMoves);
                    if (NumMoves==0 && sum<SCR) {
                        frame.dispose();
                        lostScreen.LostScreen();
                    }else if (NumMoves==0 && sum >= SCR) {
                            frame.dispose();
                            winingScreen.WiningScreen();
                        }

                    Component[] components = game.getComponents();

                    for (Component component : components){
                        if (component instanceof JButton){
                            JButton button = (JButton) component;

                            int buttonValue = Integer.parseInt(button.getText());
                            int rowColValue= Integer.parseInt(button.getActionCommand());

                            int row = (rowColValue - 1) / n + 1;
                            int col = (rowColValue - 1) % n + 1;

                            if (previous != 0){
                                if (row % randomNum == 0 && col % randomNum == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else if (row % previous == 0 && col % previous == 0){
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else if (row % randomNum == 0 && col % previous == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else if (row % previous == 0 && col % randomNum == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else{
                                    button.setBackground(null);
                                    button.setEnabled(false);
                                }
                            } else {
                                if (row % randomNum == 0 && col % randomNum == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else if (row % randomNum == 0 && col % 1 == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                } else if (row % 1 == 0 && col % randomNum == 0) {
                                    button.setBackground(Color.GREEN);
                                    button.setEnabled(true);
                                }else{
                                    button.setBackground(null);
                                    button.setEnabled(false);
                                }
                            }
                        }
                    }
                    previous=randomNum;
                }
            });

        frame.add(game,BorderLayout.CENTER);
        frame.add(panel1,BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.NORTH);
        frame.setBounds(100, 200, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
}

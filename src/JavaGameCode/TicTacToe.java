import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();

    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();

    JLabel text_field = new JLabel();

    // number of buttons
    JButton[] buttons = new JButton[9];

    // conditional to see if the player turn is true or false
    boolean player1_turn;

    // constructor
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        // set background color
        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Ink Free",Font.BOLD,75));

        // using a border layout
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        // coordinates where to start
        title_panel.setBounds(0,0,800,100);

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void firstTurn(){

    }
    public void check(){

    }
    // what buttons were pressed for the user to result in winning
    public void xWins(int a , int b, int c){

    }
    public void oWins(int a , int b, int c){

    }
}



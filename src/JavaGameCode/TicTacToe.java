import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {
    //  ActionListener is an interface that allows you to handle events triggered by user actions, such as clicking a button or selecting a menu item

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

        // match the amount of buttons we have, 9
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        // traverse through buttons
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();

            // add button at current index
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));

            // make buttons not focusable
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // run 9 times when a button is clicked
        for (int i = 0; i < 9; i++){
            if (e.getSource() == buttons[i]){
                // already a boolean value/ no need to set it to a condition
                if (player1_turn){

                    // check to see if any text is assigned to the button

                    // Player clicked button displays X then moves to "O turn"
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                // Player clicked button displays O then moves to "X turn"
                else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X turn");
                        check();
                    }
                }

            }
        }

    }

    public void firstTurn(){
        // add a delay before assigning a turn
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // getting two random number 0 or 1
        if(random.nextInt(2) == 0){

            player1_turn = true;
            text_field.setText("X turn");
        }
        else {
            player1_turn = false;
            text_field.setText("O turn");
        }

    }
    public void check(){
        // check X win conditions
             if(
                        (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ){
            // winning combination
            xWins(0,1,2);
        }
        if(
                        (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ){
            // winning combination
            xWins(3,4,5);
        }
        if(
                        (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            // winning combination
            xWins(6,7,8);
        }

        if(
                        (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ){
            // winning combination
            xWins(0,3,3);
        }
        if(
                        (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ){
            // winning combination
            xWins(1,4,7);
        }
        if(
                        (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            // winning combination
            xWins(2,5,8);
        }

        if(
                        (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ){
            // winning combination
            xWins(0,4,8);
        }
        if(
                        (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ){
            // winning combination
            xWins(2,4,6);
        }

        // check O win conditions

        if(
                        (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ){
            // winning combination
            oWins(0,1,2);
        }
        if(
                        (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ){
            // winning combination
            oWins(3,4,5);
        }
        if(
                        (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            // winning combination
            oWins(6,7,8);
        }

        if(
                        (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ){
            // winning combination
            oWins(0,3,3);
        }
        if(
                        (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ){
            // winning combination
            oWins(1,4,7);
        }
        if(
                        (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            // winning combination
            oWins(2,5,8);
        }

        if(
                        (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ){
            // winning combination
            oWins(0,4,8);
        }
        if(
                        (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ){
            // winning combination
            oWins(2,4,6);
        }

    }
    // what buttons were pressed for the user to result in winning
    public void xWins(int a , int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        // disable all buttons so people cannot keep playing
        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X wins! Booya!");

    }
    public void oWins(int a , int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        // disable all buttons so people cannot keep playing
        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O is a Winner Winner Chicken Dinner!");

    }
}




import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tictactoe implements ActionListener {
    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();

    JPanel button_panel = new JPanel();

    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    Tictactoe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.DARK_GRAY);
        textfield.setForeground(Color.ORANGE);
        textfield.setFont(new Font("Ink tree", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-tac-toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 1200, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boi", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(200, 200)); // Added this line
        }
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }

            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (rand.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X's Turn");
        } else {
            player1_turn = false;
            textfield.setText("O's Turn");
        }
    }

    @SuppressWarnings("StringEquality")
    public void check() {
        // check X win conditions
        if (("X".equals(buttons[1].getText())) &&
                ("X".equals(buttons[0].getText())) &&
                ("X".equals(buttons[2].getText()))) {
            xWins(0, 1, 2);
        }
        if (("X".equals(buttons[3].getText())) &&
                ("X".equals(buttons[4].getText())) &&
                ("X".equals(buttons[5].getText()))) {
            xWins(3, 4, 5);
        }
        if (("X".equals(buttons[6].getText())) &&
                ("X".equals(buttons[7].getText())) &&
                ("X".equals(buttons[8].getText()))) {
            xWins(6, 7, 8);
        }
        if (("X".equals(buttons[0].getText())) &&
                ("X".equals(buttons[3].getText())) &&
                ("X".equals(buttons[6].getText()))) {
            xWins(0, 3, 6);
        }
        if (("X".equals(buttons[1].getText())) &&
                ("X".equals(buttons[4].getText())) &&
                ("X".equals(buttons[7].getText()))) {
            xWins(1, 4, 7);
        }
        if (("X".equals(buttons[2].getText())) &&
                ("X".equals(buttons[5].getText())) &&
                ("X".equals(buttons[8].getText()))) {
            xWins(2, 5, 8);
        }
        if (("X".equals(buttons[0].getText())) &&
                ("X".equals(buttons[4].getText())) &&
                ("X".equals(buttons[8].getText()))) {
            xWins(0, 4, 8);
        }
        if (("X".equals(buttons[2].getText())) &&
                ("X".equals(buttons[4].getText())) &&
                ("X".equals(buttons[6].getText()))) {
            xWins(2, 4, 6);
        }
        // check O win conditions
        if (("O".equals(buttons[0].getText())) &&
                ("O".equals(buttons[1].getText())) &&
                ("O".equals(buttons[2].getText()))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        if (checkDraw()) {
            textfield.setText("DRAW!");
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X won!");

    }

    public void oWins(int a, int b, int c) {
        buttons[a].setForeground(Color.GREEN);
        buttons[b].setForeground(Color.GREEN);
        buttons[c].setForeground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O won!");

    }

    

    public boolean checkDraw() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().isEmpty()) {
                return false; // There are still empty spaces, game is not a draw
            }
        }

        return true; // All spaces are filled, game is a draw
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {
    private JFrame frame;
    private JButton[][] buttons;
    private char currentPlayer = 'X';

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TicTacToeGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TicTacToeGUI() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener());
                frame.add(buttons[i][j]);
            }
        }

        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals("")) {
                buttonClicked.setText(String.valueOf(currentPlayer));
                if (checkWinner() || isBoardFull()) {
                    JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
                    resetGame();
                } else {
                    switchPlayer();
                }
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][1].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }

            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[1][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return buttons[0][2].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][0].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "Нічия");
        resetGame();
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }
}

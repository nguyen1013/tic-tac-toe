import java.awt.*;
import javax.swing.*;

public class GamePlay {
    Frame frame = new Frame(600, 700);   
    Panel panel = new Panel();
    Label label = new Label();
    ResetGame resetGameButton = new ResetGame();
    JPanel gameBoard = new JPanel();
    static TileButton[][] tileButtons = new TileButton[3][3];
    
    Player player = new Player('X');

    public GamePlay() {
        panel.add(label, BorderLayout.NORTH);
        panel.add(resetGameButton, BorderLayout.SOUTH);

        gameBoard.setLayout(new GridLayout(3, 3));
        gameBoard.setBackground(Color.black);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(gameBoard, BorderLayout.CENTER);

        resetGameButton.restartButton.addActionListener(e -> restartGame());

        initializeBoard();
        frame.setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TileButton tileButton = new TileButton();
                tileButtons[i][j] = tileButton;
                gameBoard.add(tileButton);
                tileButton.addActionListener(e -> clickTile(tileButton));
            }
        }
    }

    private void clickTile(JButton button) {
        if (button.getText().isEmpty()) {
            if (player.currentPlayer == 'X') {
                button.setForeground(Color.pink);
            } else {
                button.setForeground(Color.yellow);
            }
            button.setText(String.valueOf(player.currentPlayer));

            checkResult();
        }
    }

    private void checkResult() {
        if (checkWin()) {
            label.setText("Player " + player.currentPlayer + " wins!");
            disableAllButtons();
        } else if (checkDraw()) {
            label.setText("It's a draw!");
        } else {
            player.changePlayer();
            label.setText("Player " + player.currentPlayer + "'s turn");
        }
    }

    private void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tileButtons[i][j].setText("");
                tileButtons[i][j].setEnabled(true);
            }
        }
        player.currentPlayer = 'X';
        label.setText("Player " + player.currentPlayer + "'s turn");
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tileButtons[i][j].getText().isEmpty()) {
                    tileButtons[i][j].setEnabled(false);
                }
            }
        }
    }

    private static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (checkLine(tileButtons[i][0], tileButtons[i][1], tileButtons[i][2]) ||
                    checkLine(tileButtons[0][i], tileButtons[1][i], tileButtons[2][i])) {
                return true;
            }
        }
        return checkLine(tileButtons[0][0], tileButtons[1][1], tileButtons[2][2]) ||
                checkLine(tileButtons[0][2], tileButtons[1][1], tileButtons[2][0]);
    }

    private static boolean checkLine(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tileButtons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
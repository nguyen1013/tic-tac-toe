import java.awt.*;
import javax.swing.*;

public class GamePlay {
    int width = 600;
    int height = 700;

    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JPanel gameBoard = new JPanel();
    JButton restartButton = new JButton("Restart");

    static JButton[][] tileButtons = new JButton[3][3];
    char playerX = 'X';
    char playerO = 'O';
    char currentPlayer = playerX;

    public GamePlay() {
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.darkGray);

        label.setForeground(Color.green);
        label.setFont(new Font("Monospaced", Font.PLAIN, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.darkGray);
        restartButton.setPreferredSize(new Dimension(150, 50));
        restartButton.setFont(new Font("Courier", Font.BOLD, 20));
        restartButton.setFocusable(false);
        buttonPanel.add(restartButton);

        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        gameBoard.setLayout(new GridLayout(3, 3));
        gameBoard.setBackground(Color.black);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(gameBoard, BorderLayout.CENTER);

        restartButton.addActionListener(e -> restartGame());

        initializeBoard();

        frame.setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tileButton = createTileButton();
                tileButtons[i][j] = tileButton;
                gameBoard.add(tileButton);
                tileButton.addActionListener(e -> clickTile(tileButton));
            }
        }
    }

    private JButton createTileButton() {
        JButton button = new JButton();
        button.setBackground(Color.darkGray);
        button.setFont(new Font("Courier", Font.ITALIC, 50));
        button.setFocusable(false);
        return button;
    }

    private void clickTile(JButton button) {
        if (button.getText().isEmpty()) {
            if (currentPlayer == playerX) {
                button.setForeground(Color.pink);
            } else {
                button.setForeground(Color.yellow);
            }
            button.setText(String.valueOf(currentPlayer));

            checkResult();
        }
    }

    private void checkResult() {
        if (checkWin()) {
            label.setText("Player " + currentPlayer + " wins!");
            disableAllButtons();
        } else if (checkDraw()) {
            label.setText("It's a draw!");
        } else {
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            label.setText("Player " + currentPlayer + "'s turn");
        }
    }

    private void restartGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tileButtons[i][j].setText("");
                tileButtons[i][j].setEnabled(true);
            }
        }
        currentPlayer = playerX;
        label.setText("Player " + currentPlayer + "'s turn");
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
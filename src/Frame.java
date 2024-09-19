import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    JPanel panel;
    JTextField textField;
    JRadioButton radioButton;
    JButton startButton;
    Font font = new Font("Monospaced", Font.BOLD, 30);

    JButton[][] tiles = new JButton[9][9];

    public Frame() {
        this.setBounds(0,0, 600,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(0,100,600,600);
        panel.setLayout(new GridLayout(3,3));
        panel.setOpaque(true);

        textField = new JTextField("Tic Tac Toe");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(font);
        textField.setBounds(0,0,600,50);
        textField.setEditable(false);

        startButton = new JButton("Play");
        startButton.setFont(font);
        startButton.setBounds(0, 50, 600, 50);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                tiles[i][j] = new JButton();
                tiles[i][j].setFont(new Font("Serif", Font.ITALIC, 50));
                tiles[i][j].setFocusable(false);
                tiles[i][j].setBackground(Color.GRAY);
                tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(tiles[i][j]);

            }
        }

        this.add(textField);
        this.add(startButton);
        this.add(panel);
        this.setVisible(true);
    }

}

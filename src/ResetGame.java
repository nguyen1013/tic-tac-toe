import javax.swing.*;
import java.awt.*;

public class ResetGame extends JPanel {
    JButton restartButton;

    public ResetGame() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        restartButton = new JButton("Restart");
        this.setBackground(Color.darkGray);
        restartButton.setPreferredSize(new Dimension(150, 50));
        restartButton.setFont(new Font("Courier", Font.BOLD, 20));
        restartButton.setFocusable(false);
        this.add(restartButton);
    }

}

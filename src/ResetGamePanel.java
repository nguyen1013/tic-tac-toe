import javax.swing.*;
import java.awt.*;

public class ResetGamePanel extends JPanel {
    JButton restartButton;

    public ResetGamePanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        restartButton = new JButton("Restart");
        this.setBackground(Color.darkGray);
        restartButton.setPreferredSize(new Dimension(150, 50));
        restartButton.setFont(new Font("Courier", Font.BOLD, 20));
        restartButton.setFocusable(false);
        this.add(restartButton);
    }

}

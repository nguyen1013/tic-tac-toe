import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    Label label = new Label();
    ResetGamePanel resetGame = new ResetGamePanel();

    public TopPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.darkGray);
        this.add(label, BorderLayout.NORTH);
        this.add(resetGame, BorderLayout.SOUTH);
    }
}

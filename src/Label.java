import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{
    public Label() {
        this.setForeground(Color.green);
        this.setFont(new Font("Monospaced", Font.PLAIN, 50));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setText("Tic Tac Toe");
    }
}

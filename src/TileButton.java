import javax.swing.JButton;
import java.awt.*;

public class TileButton extends JButton {
    public TileButton() {
        this.setBackground(Color.darkGray);
        this.setFont(new Font("Courier", Font.ITALIC, 50));
        this.setFocusable(false);
    }
}

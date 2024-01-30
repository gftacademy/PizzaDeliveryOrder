import javax.swing.*;
import java.awt.*;

public class TestImage extends JFrame {
    public static void main(String[] args) {
        TestImage testImage = new TestImage();
        testImage.setVisible(true);
    }

    public TestImage() throws HeadlessException {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader()
                .getResource("res/images/no_image.png")));

    }
}

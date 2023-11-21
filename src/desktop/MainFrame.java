package desktop;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pizza Store Delivery Order 24/7");
        setLocation(400,200);
        setSize(600,400);
    }
}

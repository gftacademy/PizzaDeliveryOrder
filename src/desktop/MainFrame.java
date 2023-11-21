package desktop;

import entities.Shop;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Shop shop;
    public MainFrame(Shop shop){
        this.shop = shop;
        initComponents();
    }
    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pizza Store Delivery Order 24/7");
        setLocation(400,200);
        setSize(600,400);
    }
}

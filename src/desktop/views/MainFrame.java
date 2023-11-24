package desktop.views;

import desktop.controllers.OMController;
import desktop.controllers.PMController;
import entities.Shop;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Shop shop;
    private PMController pmController;
    private OMController omController;
    public MainFrame(Shop shop){
        this.shop = shop;
        this.pmController = new PMController(shop.getPm());
        this.omController = new OMController(shop.getOm());
        initComponents();
    }
    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(shop.getName());
        setLocation(400,200);
        setSize(600,400);
    }
}

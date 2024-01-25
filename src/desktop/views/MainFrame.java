package desktop.views;

import desktop.controllers.OMController;
import desktop.controllers.PMController;
import entities.Shop;
import pm.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MainFrame extends JFrame {
    private Shop shop;
    private PMController pmController;
    private OMController omController;
    private JPanel mainPanel;
    private JLabel clockLabel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JLabel appsTitle;
    private JPanel currentPanel;
    private JTabbedPane tabbedPane1;
    private JButton printAllProductButton;
    private JButton findAProductButton;
    private JButton addProductButton;
    private JTextArea productDisplayArea;
    private JLabel messageLabel;
    private JButton addOrderButton;
    private JTable orderTable;

    public MainFrame(Shop shop){
        this.shop = shop;
        this.pmController = new PMController(shop.getPm());
        this.omController = new OMController(shop.getOm());
        initComponents();
        //listener
        printAllProductButton.addActionListener(e -> {
           for (Product p : pmController.getAllProducts()){
               productDisplayArea.append(p+"\n");
           }
        });
    }
    public Shop getShop() {
        return shop;
    }
    public PMController getPmController() {
        return pmController;
    }
    public OMController getOmController() {
        return omController;
    }
    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(shop.getName());
        getContentPane().add(mainPanel);
        setLocation(200,100);
        setSize(900,600);
        setVisible(true);
        initial();
    }

    private void initial() {
        sendMessage("PDO Apps Ready");
        //listener untuk modul product manager
        printAllProductButton.addActionListener(e -> {
            for(Product product : pmController.getAllProducts()){
                productDisplayArea.append(product+"\n");
            }
        });
        findAProductButton.addActionListener(e -> {
            String skuCode = JOptionPane.showInputDialog("Masukkan SKUCODE ?");
            Optional<Product> p = pmController.getPmModel().getProductList()
                    .stream()
                    .filter(product -> product.getId().equals(skuCode))
                    .findAny();
            sendMessage(p.toString());
        });
        addProductButton.addActionListener(e -> {
        //open Register Product Dialog
            RegisterProductDialog dialog = new RegisterProductDialog(this);
            dialog.setVisible(true);
        });
        //Listener untuk Order Modul
        addOrderButton.addActionListener(e -> {
            OrderDialog dialog = new OrderDialog(this);
            dialog.setVisible(true);
        });
        //harus di bawah sendiri
        showOrderTable();
        clock();
    }

    public void showOrderTable(){
        Object [] column = {"Invoice","Customer","Total"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null,column);
        orderTable.setModel(defaultTableModel);
    }

    private void clock() {
        while (true) {
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");
                clockLabel.setText(now.format(format).toString());
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void sendMessage(String text){
        messageLabel.setText(text);
    }
}

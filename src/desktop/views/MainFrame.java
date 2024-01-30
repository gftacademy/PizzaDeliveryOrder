package desktop.views;

import desktop.Apps;
import desktop.controllers.OMController;
import desktop.controllers.PMController;
import entities.Shop;
import om.Order;
import pm.Product;
import utilities.DataAction;
import utilities.FileServices;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    private JButton actionButton;
    private JComboBox cbDataAction;

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
            if(p.isEmpty()){
                sendMessage("Product "+skuCode+ " tidak ditemukan.");
            }else{
                //Detail Product
            }
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
        //Operasi file - persistence
        cbDataAction.setModel(new DefaultComboBoxModel(DataAction.values()));
        actionButton.addActionListener(e -> {
            switch (cbDataAction.getSelectedIndex()){
                case 0: {importDataTxt();break;}
                case 1: {
                        saveData();
                    break;}
                case 2: {
                    try {
                        backUpData();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;}
                case 3: {
                    try {
                        restoreData();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    break;}
                case 4: {clearData();break;}
                default: break;
            }
        });
        //harus di bawah sendiri
        showOrderTable();
        clock();
    }
    private void importDataTxt(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files","txt");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        List<Product> parser = FileServices.readProductFile(filename);
        pmController.getPmModel().setProductList(parser);
        sendMessage("Data telah ditambahkan ke Product Manager");
    }
    private void saveData() {
        if(JOptionPane.showConfirmDialog(this,"Simpan data?") == 0){
            try {
                FileServices.saveObjectToFile(shop,Apps.DEFAULT_OBJECT_FILENAME);
                sendMessage("Simpan Update data berhasil");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    private void backUpData() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDO file system","pdo");
        chooser.setFileFilter(filter);
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        FileServices.saveObjectToFile(shop,filename);
        sendMessage("Backup File "+filename);
    }
    private void restoreData() throws IOException, ClassNotFoundException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDO file system","pdo");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(this);
        File filename = chooser.getSelectedFile();
        if (filename != null){
            this.shop = (Shop) FileServices.readObjectFromFile(filename.getAbsolutePath());
            pmController.setPmModel(shop.getPm());
            omController.setOmModel(shop.getOm());
            sendMessage("Data shop telah dipulihkan");
        }
    }
    private void clearData(){
        if(JOptionPane.showConfirmDialog(this,"Anda Yakin mau hapus semua data?") == 0){
            this.shop = new Shop();
            pmController.setPmModel(shop.getPm());
            omController.setOmModel(shop.getOm());
            productDisplayArea.setText("");
            sendMessage("Data shop Telah dikosongkan.");
            productDisplayArea.setText("");
            showOrderTable();
        }
    }
    public void showOrderTable(){
        Object [] column = {"Invoice","Customer","Total"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null,column);
        for(Order order : getOmController().getOmModel().getOrderList()){
            Object [] record = {order.getInvoice()};
            defaultTableModel.addRow(record);
        }
        orderTable.setModel(defaultTableModel);
        //mengatur lebar kolom
        orderTable.getColumn("Invoice").setPreferredWidth(70);
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

package desktop.views;

import desktop.Apps;
import pm.Product;
import pm.ProductCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class DetailProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton editButton;
    private JButton buttonCancel;
    private JComboBox cbCategory;
    private JTextField skuCodeTxt;
    private JTextField nameTxt;
    private JTextField priceTxt;
    private JLabel imageLabel;
    private JLabel stockLabel;
    private JButton uploadButton;
    private MainFrame parent;
    private Product product;
    private ImageIcon icon100;

    public DetailProductDialog(MainFrame parent, Product product) {
        this.parent = parent;
        this.product = product;
        initComponents();
        //display product
        skuCodeTxt.setText(product.getId());
        nameTxt.setText(product.getName());
        String category = product.getCategory();
        cbCategory.setSelectedItem(category);
        priceTxt.setText(product.getPrice()+"");
        if (product.getImage() != null) imageLabel.setIcon(product.getImage());
        //
        editButton.addActionListener(e -> {
            //editable true
            if(editButton.getText().equals("Save")){
                Product newProduct = new Product();
                newProduct.setId(product.getId());
                newProduct.setName(nameTxt.getText());
                newProduct.setPrice(Integer.parseInt(priceTxt.getText()));
                newProduct.setCategory(cbCategory.getSelectedItem().toString());
                newProduct.setImage(icon100);
                if(parent.getPmController().getAllProducts().remove(product)) {
                    parent.getPmController().registerProduct(newProduct);
                    parent.sendMessage("Update product "+product.getId()+"Berhasil");
                    dispose();
                }else parent.sendMessage("Update Gagal");
            }else{
                uploadButton.show();
                nameTxt.setEnabled(true);
                priceTxt.setEnabled(true);
                cbCategory.setEnabled(true);
                editButton.setText("Save");
            }
        });
        //upload
        uploadButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            File file = chooser.getSelectedFile();
            if (file != null){
                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                icon100 = new ImageIcon(icon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
                imageLabel.setIcon(icon100);
            }
        });
        buttonCancel.addActionListener(e -> dispose());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initComponents() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(editButton);
        setLocation(parent.getX()+200,parent.getY()+140);
        cbCategory.setModel(new DefaultComboBoxModel(ProductCategory.values()));
        //disable
        skuCodeTxt.setEnabled(false);
        nameTxt.setEnabled(false);
        priceTxt.setEnabled(false);
        cbCategory.setEnabled(false);
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(Apps.DEFAULT_NOIMAGE_ICON));
        Image image = icon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        imageLabel.setText("");
        imageLabel.setIcon(new ImageIcon(image));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        imageLabel.setSize(100,100);
        setSize(300,420);
        uploadButton.hide();
        stockLabel.setText("0");
    }
}

package desktop.views;

import desktop.Apps;
import pm.Product;
import pm.ProductCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbCategory;
    private JTextField skuCodeTxt;
    private JTextField nameTxt;
    private JTextField priceTxt;
    private JLabel imageLabel;
    private MainFrame parent;
    private Product product;

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
        imageLabel.setIcon(product.getImage());
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initComponents() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocation(parent.getX()+200,parent.getY()+140);
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(Apps.DEFAULT_NOIMAGE_ICON));
        Image image = icon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        imageLabel.setSize(150,150);
        setSize(300,400);
        cbCategory.setModel(new DefaultComboBoxModel(ProductCategory.values()));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}

package desktop.views;

import pm.ProductCategory;
import pm.Product;

import javax.swing.*;
import java.awt.event.*;

public class RegisterProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField skuCodeTxt;
    private JTextField nameTxt;
    private JComboBox categoryCbx;
    private JTextField priceTxt;
    private MainFrame parent;

    public RegisterProductDialog(MainFrame mainFrame) {
        this.parent = mainFrame;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300,400);
        setLocationRelativeTo(this);
        //comboBox
        categoryCbx.setModel(new DefaultComboBoxModel(ProductCategory.values()));
        buttonOK.addActionListener(e -> {
            Product product = new Product(skuCodeTxt.getText(), nameTxt.getText(),categoryCbx.getSelectedItem().toString()
            ,Integer.parseInt(priceTxt.getText()));
            parent.getPmController().getPmModel().registerProduct(product);
            parent.sendMessage(product+ "telah ditambahkan");
            dispose();
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

}

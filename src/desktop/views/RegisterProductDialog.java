package desktop.views;

import desktop.Apps;
import pm.ProductCategory;
import pm.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class RegisterProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField skuCodeTxt;
    private JTextField nameTxt;
    private JComboBox<ProductCategory> categoryCbx;
    private JTextField priceTxt;
    private JButton uploadButton;
    private JLabel imageLabel;
    private MainFrame parent;
    private ImageIcon icon100;

    public RegisterProductDialog(MainFrame mainFrame) {
        this.parent = mainFrame;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(350,450);
        setLocationRelativeTo(this);
        //comboBox
        categoryCbx.setModel(new DefaultComboBoxModel<>(ProductCategory.values()));
        //ImageIcon
        imageLabel.setSize(100,100);
        imageLabel.setText("");
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ImageIcon imageIcon = new ImageIcon((getClass().getClassLoader().getResource(Apps.DEFAULT_NOIMAGE_ICON)));
        Image image = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
        buttonOK.addActionListener(e -> {
            Product product = new Product();
            product.setId(skuCodeTxt.getText());
            product.setName(nameTxt.getText());
            product.setCategory(categoryCbx.getSelectedItem().toString());
            product.setPrice(Integer.parseInt(priceTxt.getText()));
            product.setImage(icon100);
            parent.getPmController().registerProduct(product);
            parent.sendMessage(product+ "telah ditambahkan");
            dispose();
        });
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

}

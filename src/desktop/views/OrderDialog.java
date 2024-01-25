package desktop.views;

import om.Order;
import om.SaleLineItem;
import pm.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.GregorianCalendar;
import java.util.Random;

public class OrderDialog extends JDialog {
    private JPanel contentPane;
    private JButton checkOutButton;
    private JButton buttonCancel;
    private JTable sliTable;
    private JButton itemButton;
    private JLabel totalLabel;
    private JTextField searchCustomer;
    private JButton findButton;
    private final Order order = new Order();
    private MainFrame parent;

    public OrderDialog(MainFrame mainFrame) {
        this.parent = mainFrame;
        order.setInvoice(getInvoice());
        setTitle("Order");
        setContentPane(contentPane);
        //setModal(true);
        setLocation(parent.getX()+150,parent.getY()+150);
        setSize(500,400);
        getRootPane().setDefaultButton(checkOutButton);
        //add Salelineitem
        itemButton.addActionListener(e -> {
            String skuCode = JOptionPane.showInputDialog(this,"Masukkan SKUCode ?");
            Product product = parent.getPmController().getPmModel().findProductById(skuCode);
            if (product != null){
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(this,"Jumlah ?"));
                order.addItem(new SaleLineItem(product,quantity));
                showDataTable();
            }
            totalLabel.setText("TOTAL :"+order.getTotal());
        });
        //checkout
        checkOutButton.addActionListener(e -> {
            order.setOrderDate(GregorianCalendar.getInstance().getTime());
            parent.getOmController().getOmModel().addOrder(order);
            parent.sendMessage(order.getInvoice()+" berhasil disimpan -> "+parent.getOmController().getOmModel().getOrderList().size());
        });
    }
    private String getInvoice(){
        Random rnd = new Random();
        return "PDO"+ rnd.nextInt();
    }
    private void showDataTable(){
        Object [] colom = {"Id","Product","Price","Quantity","SubTOtal"};
        DefaultTableModel model = new DefaultTableModel(null, colom);
        for(SaleLineItem sli : order.getSaleLineItems()){
            Object [] data = {sli.getProduct().getId(),sli.getProduct().getName(),sli.getProduct().getPrice()
            ,sli.getQuantity(),sli.getSubTotal()};
            model.addRow(data);
        }
        sliTable.setModel(model);
    }
}

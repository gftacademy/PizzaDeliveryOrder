package desktop;

import desktop.views.MainFrame;
import entities.Shop;
import om.Order;
import om.SaleLineItem;
import utilities.FileServices;

import javax.swing.*;
import java.io.IOException;
import java.util.GregorianCalendar;

public class Apps {
    private final static String DEFAULT_SHOP = "Pizza Store Delivery Order 24/7";
    private final static String DEFAULT_DATA_PRODUCT = "src/data/products.txt";
    public final static String DEFAULT_OBJECT_FILENAME = "src/data/shop.pdo";
    private static Shop shop;
    private static MainFrame mainFrame;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        startApps();
    }
    private static void startApps() throws IOException, ClassNotFoundException {
        initial();
    }
    private static void initial()  {
        try {
            shop = (Shop) FileServices.readObjectFromFile(DEFAULT_OBJECT_FILENAME);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(shop == null ) {
                shop = new Shop(DEFAULT_SHOP);
                shop.getPm().setProductList(FileServices.readProductFile(DEFAULT_DATA_PRODUCT));
                JOptionPane.showMessageDialog(null, "shop null");
            }
        }
        mainFrame = new MainFrame(shop);
    }
}

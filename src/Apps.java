import desktop.views.MainFrame;
import entities.Shop;
import om.Order;
import om.SaleLineItem;
import utilities.FileServices;

import java.io.IOException;
import java.util.GregorianCalendar;

public class Apps {
    private static Shop shop;
    private final static String DEFAULT_SHOP = "Pizza Store Delivery Order 24/7";
    private final static String DEFAULT_DATA_PRODUCT = "src/data/products.txt";
    private final static String DEFAULT_OBJECT_FILENAME = "src/data/shop.pdo";
    private static MainFrame mainFrame;
    public static void main(String[] args) {
        startApps();
    }
    private static void startApps() {
        initial();
        mainFrame = new MainFrame(shop);
    }
    private static void initial() {
        if(shop == null ) {
            shop = new Shop(DEFAULT_SHOP);
            shop.getPm().setProductList(FileServices.readProductFile(DEFAULT_DATA_PRODUCT));
            shop.info();
        }
    }
}

import desktop.views.MainFrame;
import entities.Shop;
import om.Order;
import om.SaleLineItem;
import utilities.FileServices;

import java.util.GregorianCalendar;

public class Apps {
    private static Shop shop;
    private final static String DEFAULT_SHOP = "Pizza Store Delivery Order 24/7";
    private final static String DEFAULT_DATA_PRODUCT = "src/data/products.txt";
    private static MainFrame mainFrame;
    public static void main(String[] args) {
        startApps();
    }
    private static void startApps() {
        initial();
        mainFrame = new MainFrame(shop);
        mainFrame.setVisible(true);
    }
    private static void initial() {
        if(shop == null ) {
            shop = new Shop(DEFAULT_SHOP);
            shop.getPm().setProductList(FileServices.readProductFile(DEFAULT_DATA_PRODUCT));
            shop.info();
        }
        //Order test Unit
        Order order = new Order("1234", GregorianCalendar.getInstance().getTime(),shop);
        order.addItem(new SaleLineItem(shop.getPm().findProductById("SKU6645"),2));
        order.addItem(new SaleLineItem(shop.getPm().findProductById("SKU5643"),10));
        order.checkout();
        shop.info();
    }
}

import desktop.MainFrame;
import entities.Shop;
import utilities.FileServices;

public class Apps {
    private static Shop shop;
    private final static String DEFAULT_DATA_PRODUCT = "src/data/products.txt";
    private static MainFrame mainFrame;
    public static void main(String[] args) {
        startApps();
    }

    private static void startApps() {
        initial();
//        mainFrame = new MainFrame(shop);
//        mainFrame.setVisible(true);
    }

    private static void initial() {
        if(shop == null ) {
            shop = new Shop("Pizza Store");
            shop.getPm().setProductList(FileServices.readProductFile(DEFAULT_DATA_PRODUCT));
            shop.info();
        }
    }
}

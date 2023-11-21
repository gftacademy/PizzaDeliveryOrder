import desktop.MainFrame;
import utilities.FIleServices;

public class Apps {
    public static void main(String[] args) {
        initial();
        new MainFrame().setVisible(true);
    }

    private static void initial() {
        FIleServices.readProductFile("src/products.txt");
    }
}

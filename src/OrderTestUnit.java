import java.util.Date;
import java.util.GregorianCalendar;

public class OrderTestUnit {
    public static void main(String[] args) {
        //Master
        Shop shop = new Shop("PDO Shop");
        //Usecase Register Product
        Katalog katalog = new Katalog(shop);
        katalog.registerProduct(new Product("1","Pizza Meat lover",40));
        katalog.registerProduct(new Product("2","Salad",10));
        katalog.printAllProduct();
        System.out.println(katalog.findProductById("2"));
        //Usecase Order
        Date d = GregorianCalendar.getInstance().getTime();
        Order order = new Order("INV-2301",d, shop);
        order.addItem(new Item(katalog.findProductById("1"),3));
        order.addItem(new Item(katalog.findProductById("2"),10));
        order.checkout();
    }
}

import pm.Product;
import entities.Shop;
import om.SaleLineItem;
import om.Order;
import pm.ProductManager;

import java.util.Date;
import java.util.GregorianCalendar;

public class OrderTestUnit {
    public static void main(String[] args) {
        //Master
        Shop shop = new Shop("PDO Shop");
        //Usecase Register Product
        ProductManager productManager = new ProductManager();
        productManager.registerProduct(new Product("1","Pizza Meat lover","Pizza",40));
        productManager.registerProduct(new Product("2","Salad","Pizza",10));
        //productManager.printAllProduct();
        //System.out.println(productManager.findProductById("2"));
        //Usecase Order
        Date d = GregorianCalendar.getInstance().getTime();
//        Order order = new Order("INV-2301",d, shop);
//        order.addItem(new SaleLineItem(productManager.findProductById("1"),3));
//        order.addItem(new SaleLineItem(productManager.findProductById("2"),10));
//        order.checkout();
    }
}

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
        Product p = new Product("2","Salad","Pizza",10);
        productManager.registerProduct(new Product("1","Pizza Meat lover","Pizza",40));
        productManager.registerProduct(p);
        productManager.getProductList().remove(p);
        productManager.printAllProduct();
        //System.out.println(productManager.findProductById("2"));
        //Usecase Order
        Date d = GregorianCalendar.getInstance().getTime();


    }
}

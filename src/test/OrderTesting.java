package test;
import entities.Shop;
import om.SaleLineItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pm.Product;
import om.Order;
import java.util.GregorianCalendar;

public class OrderTesting {
    private static Shop shop = new Shop("GFT Store");
    private static Product product = new Product("1","Pizza Meat Lover","Pizza",34);
    @Test
    @DisplayName(value = "Pengujian chart empty, 2 items & check total")
    public void add2SaleLineItemTest(){
        Order order = new om.Order();
        Assertions.assertTrue(order.getSaleLineItems().isEmpty());
        order.addItem(new SaleLineItem(product,1));
        Product p = new Product("2","Salad Buah","Food",4);
        order.addItem(new SaleLineItem(p,3));
        Assertions.assertEquals(2,order.getSaleLineItems().size(),"add Item sudah masuk ke chart");
        Assertions.assertEquals(46,order.getTotal(),"Total sudah benar");
    }
}

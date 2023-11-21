package entities;

import om.OrderManager;
import pm.ProductManager;

public class Shop {
    private String name;
    private ProductManager pm = new ProductManager();
    private OrderManager om = new OrderManager();
    public Shop(String name) {
        this.name = name;
    }
    public ProductManager getPm() {
        return pm;
    }
    public void info(){
        System.out.println("---------SHOP---------");
        System.out.println("Name\t: "+name);
        System.out.println("PM Size\t: "+pm.getProductList().size());
        System.out.println("OM Size\t: "+om.getOrderList().size());
        System.out.println("-------------------");
    }
}

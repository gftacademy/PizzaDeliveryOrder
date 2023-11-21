package om;

import entities.Shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String invoice;
    private Date orderDate;
    private Shop shop;
    private List<Item> items = new ArrayList<>();

    public Order(String invoice, Date orderDate, Shop shop) {
        this.invoice = invoice;
        this.orderDate = orderDate;
        this.shop = shop;
    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void checkout() {
        for(Item item : items){
            System.out.println(item);
        }
    }
}

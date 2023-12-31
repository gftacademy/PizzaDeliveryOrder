package om;

import entities.Shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String invoice;
    private Date orderDate;
    private Shop shop;
    private List<SaleLineItem> saleLineItems = new ArrayList<>();

    public Order(String invoice, Date orderDate, Shop shop) {
        this.invoice = invoice;
        this.orderDate = orderDate;
        this.shop = shop;
    }
    public void addItem(SaleLineItem saleLineItem) {
        saleLineItems.add(saleLineItem);
    }

    public void checkout() {
        for(SaleLineItem saleLineItem : saleLineItems){
            System.out.println(saleLineItem);
        }
    }
}

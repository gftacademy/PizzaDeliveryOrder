package om;

import entities.Shop;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = -75751962238871108L;
    private String invoice;
    private Date orderDate;
    private List<SaleLineItem> saleLineItems = new ArrayList<>();
    public Order() {
    }
    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
    public String getInvoice() {
        return invoice;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public void addItem(SaleLineItem saleLineItem) {
        saleLineItems.add(saleLineItem);
    }
    public void checkout() {
        for(SaleLineItem saleLineItem : saleLineItems){
            System.out.println(saleLineItem);
        }
    }
    public double getTotal(){
        double total = 0;
        for(SaleLineItem sli : saleLineItems){
            total += sli.getProduct().getPrice() * sli.getQuantity();
        }
        return total;
    }
    public List<SaleLineItem> getSaleLineItems() {
        return saleLineItems;
    }
}

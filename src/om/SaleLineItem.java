package om;

import pm.Product;

import java.io.Serial;
import java.io.Serializable;

public class SaleLineItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 3943243562936946334L;
    private final Product product;
    private final int quantity;

    public SaleLineItem(Product product, int jumlah) {
        this.product = product;
        this.quantity = jumlah;
    }
    public int getQuantity() {
        return quantity;
    }
    public Product getProduct() {
        return product;
    }
    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", jumlah=" + quantity +
                '}';
    }

    public int getSubTotal() {
        return quantity * getProduct().getPrice();
    }
}

package om;

import pm.Product;

public class SaleLineItem {
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
}

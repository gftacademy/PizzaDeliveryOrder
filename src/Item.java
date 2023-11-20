public class Item {
    private final Product product;
    private final int jumlah;

    public Item(Product product, int jumlah) {
        this.product = product;
        this.jumlah = jumlah;
    }
    public int getJumlah() {
        return jumlah;
    }
    public Product getProduct() {
        return product;
    }
}

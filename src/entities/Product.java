package entities;

public class Product {
    private String id, name, category;
    private int price;
    public Product(String id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

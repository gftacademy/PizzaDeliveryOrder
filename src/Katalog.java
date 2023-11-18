import java.util.ArrayList;
import java.util.List;

public class Katalog {
    private Shop shop;
    private List<Product> productList = new ArrayList<>();
    public Katalog(Shop shop) {
        this.shop = shop;
    }
    public void printAllProduct() {
        for(Product p : productList){
            System.out.println(p);
        }
    }
    public void registerProduct(Product product) {
        productList.add(product);
    }
    public Product findProductById(String id) {
        for(Product p : productList){
            if(p.getId().equals(id)) return p;
        }
        return null;
    }
}

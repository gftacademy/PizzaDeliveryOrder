package pm;

import entities.Shop;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ProductManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 2292678315472879958L;
    private List<Product> productList = new ArrayList<>();
    public ProductManager() {
    }
    public void printAllProduct() {
        for(Product p : productList){
            System.out.println(p);
        }
    }
    public List<Product> getProductList() {
        return productList;
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
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

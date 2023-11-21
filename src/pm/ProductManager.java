package pm;

import entities.Shop;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();
    public ProductManager() {
        productList.add(new Product("1","1","1",1));
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

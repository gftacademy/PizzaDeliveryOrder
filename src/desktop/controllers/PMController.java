package desktop.controllers;

import pm.Product;
import pm.ProductManager;

import java.util.List;

public class PMController {
    private ProductManager pmModel;
    public PMController(ProductManager pmModel) {
        this.pmModel = pmModel;
    }
    public void registerProduct(Product product){
        pmModel.registerProduct(product);
    }
    public List<Product> getAllProducts(){
        return pmModel.getProductList();
    }

}

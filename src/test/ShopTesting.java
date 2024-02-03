package test;

import entities.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pm.Product;

public class ShopTesting {
    private static Shop shop = new Shop("GFT Store");
    private static Product product = new Product("1","Pizza Meat Lover","Pizza",34);
    @Test
    @DisplayName(value = "Pengujian remove product")
    public void removeProductTest(){
        shop.getPm().registerProduct(product);
        shop.getPm().printAllProduct();
        Assertions.assertTrue(shop.getPm().getProductList().remove(product),"Penghapusan product berhasil");
        Assertions.assertTrue(shop.getPm().getProductList().isEmpty());
    }
}
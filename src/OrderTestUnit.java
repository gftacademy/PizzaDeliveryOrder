public class OrderTestUnit {
    public static void main(String[] args) {
        //Master
        Shop shop = new Shop("PDO Shop");
        //Usecase Register Product
        Katalog katalog = new Katalog(shop);
        katalog.registerProduct(new Product("1","Pizza Meat lover",40));
        katalog.registerProduct(new Product("2","Salad",10));
        katalog.printAllProduct();
        katalog.findProductById("1");
        //Usecase Order
    }
}

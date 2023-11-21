package utilities;

import pm.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServices {
    public static List<Product> readProductFile(String filename){
        try{
            List<Product> products = new ArrayList<>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String data[] = scanner.nextLine().split("/");
                Product product = new Product(data[0],data[1],data[2],Integer.parseInt(data[3]));
                products.add(product);
            }
            return products;
        }catch (Exception ex){

        }
        return null;
    }
}

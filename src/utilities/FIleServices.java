package utilities;

import entities.Product;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FIleServices {
    public static List<Product> readProductFile(String filename){
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
        }catch (Exception ex){

        }
        return null;
    }
}

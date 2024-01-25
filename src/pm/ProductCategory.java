package pm;

import java.io.Serializable;

public enum ProductCategory {
    Pizza,Pasta_Rice,Drink,Appetizer,Accessories;
    @Override
    public String toString() {
        switch (ProductCategory.this){
            case Pizza: return "Pizza";
            case Pasta_Rice: return "Pasta & Rice";
            case Drink: return "Drink";
            case Appetizer: return "Appetizer";
            default: return null;
        }
    }
}

package om;

import pm.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Serializable {
    @Serial
    private static final long serialVersionUID = 4897768996194756427L;
    private List<Order> orderList = new ArrayList<>();
    public List<Order> getOrderList() {
        return orderList;
    }
    public void addOrder(Order order){
        orderList.add(order);
    }

}

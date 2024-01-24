package om;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orderList = new ArrayList<>();
    public List<Order> getOrderList() {
        return orderList;
    }
    public void addOrder(Order order){
        orderList.add(order);
    }
}

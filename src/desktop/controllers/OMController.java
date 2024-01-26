package desktop.controllers;

import om.OrderManager;

public class OMController {
    private OrderManager omModel;
    public OMController(OrderManager omModel) {
        this.omModel = omModel;
    }
    public OrderManager getOmModel() {
        return omModel;
    }
    public void setOmModel(OrderManager omModel) {
        this.omModel = omModel;
    }
}

package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {

    }

    Order createOrder() {
        return new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }

    Order createOrderAndCallMethods() {
        Order orderObjectChange = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        orderObjectChange.confirmOrder();
        orderObjectChange.checkPrice();
        orderObjectChange.isValidType();
        return orderObjectChange;
    }
}

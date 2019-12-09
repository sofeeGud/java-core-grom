package lesson35.demo;

import lesson35.controller.OrderController;

import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        OrderController orderController = new OrderController();
        orderController.bookRoom(1575751357313L, 1575747311933L, 1575747517072L, new Date(1575947517072L));
    }
}

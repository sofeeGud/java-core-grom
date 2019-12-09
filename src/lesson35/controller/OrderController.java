package lesson35.controller;
import lesson35.service.OrderService;

import java.util.Date;

public class OrderController {
    private OrderService orderService;


    public OrderController() throws Exception {
        orderService = new OrderService();
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date dateTo) throws Exception {
        orderService.bookRoom(roomId, userId, hotelId, dateTo);
    }
}

package lesson35.controller;

import lesson35.demo.Demo;
import lesson35.model.UserType;
import lesson35.service.OrderService;

import java.util.Date;

public class OrderController extends Controller {
    private OrderService orderService;


    public OrderController() throws Exception {
        orderService = new OrderService();
        authorization = Demo.auth;
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date dateTo) throws Exception {
        isAccess(UserType.USER);
        orderService.bookRoom(roomId, userId, hotelId, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        isAccess(UserType.USER);
        orderService.cancelReservation(roomId, userId);
    }
}

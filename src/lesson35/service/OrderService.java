package lesson35.service;

import lesson35.repository.OrderRepository;

import java.util.Date;


public class OrderService {
    private OrderRepository orderRepository;


    public OrderService() throws Exception {
        orderRepository = new OrderRepository();
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date dateTo) throws Exception {
        if (!orderRepository.validateOrder(roomId, userId, hotelId)) {
            System.err.println("Failed to place an order. Check incoming parameters. In method bookRoom");
        } else
            orderRepository.bookRoom(roomId, userId, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        orderRepository.cancelReservation(roomId, userId);
    }


}

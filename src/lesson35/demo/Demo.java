package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.controller.OrderController;
import lesson35.model.Authorization;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.repository.RoomRepository;
import lesson35.service.RoomService;

import java.util.Date;

public class Demo {

    public static Authorization auth;

    public static void main(String[] args) throws Exception {
        auth = new Authorization();
        auth.login("login11", "password1");


        HotelController hotelController = new HotelController();
        Hotel hotel10 = new Hotel(0, "hotel456", "country9876", "city1", "street1");

        //hotelController.deleteHotel(1576006222633L);
        //auth.logout();
        //hotelController.addHotel(hotel10);

        //OrderController orderController = new OrderController();
        //orderController.bookRoom(1576409565661L, 1575747311933L, 1575747517072L, new Date(1595947517072L));
        //orderController.cancelReservation(1576409565661L, 1575747311933L);

        RoomService roomService = new RoomService();
        Filter filter = new Filter(3, 460.0, true, true, new Date(), "country1", "city1");
        System.out.println(roomService.findRooms(filter));
    }
}

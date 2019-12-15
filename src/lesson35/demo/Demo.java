package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.controller.OrderController;
import lesson35.model.Authorization;
import lesson35.model.Hotel;

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
        hotelController.addHotel(hotel10);

        OrderController orderController = new OrderController();
        orderController.bookRoom(1575751357313L, 1575747311933L, 1575747517072L, new Date(1595947517072L));
        //orderController.cancelReservation(1575751357313L, 1575747311933L);


    }
}

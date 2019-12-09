package lesson35.controller;

import lesson35.model.Authorization;
import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {
    private HotelService hotelService;
    Authorization authorization = new Authorization();

    public HotelController() throws Exception {
        hotelService = new HotelService();
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        if ((!authorization.checkIn()) || (!authorization.isAdmin()))
            System.err.println("You can not using this function");
            return hotelService.addHotel(hotel);
    }
}

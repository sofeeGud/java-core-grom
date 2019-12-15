package lesson35.controller;

import lesson35.demo.Demo;
import lesson35.model.Hotel;
import lesson35.model.UserType;
import lesson35.service.HotelService;

public class HotelController extends Controller {
    private HotelService hotelService;

    public HotelController() {
        hotelService = new HotelService();
        authorization = Demo.auth;
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        isAccess(UserType.ADMIN);
        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        isAccess(UserType.ADMIN);
        hotelService.deleteHotel(hotelId);
    }

    public Hotel findHotelByName(String name) throws Exception {
        isAccess(UserType.USER);
        return hotelService.findHotelByName(name);

    }

    public Hotel findHotelByCity(String city) throws Exception {
        isAccess(UserType.USER);
        return hotelService.findHotelByCity(city);
    }
}

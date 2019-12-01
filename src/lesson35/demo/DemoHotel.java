package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelController hotelController = new HotelController();

        Hotel hotel1 = new Hotel(0, "hotel11", "country1", "city1", "street1");
        Hotel hotel2 = new Hotel(0, "hotel22", "country2", "city2", "street2");
        Hotel hotel3 = new Hotel(0, "hotel32", "country3", "city1", "street3");
        Hotel hotel4 = new Hotel(0, "hotel4", "country3", "city1", "street1");
        Hotel hotel5 = new Hotel(0, "hotel5", "country3", "city3", "street1");
        Hotel hotel6 = new Hotel(0, "hotel3", "country6", "city3", "street3");
        Hotel hotel7 = new Hotel(0, "hotel1", "country7", "city7", "street7");

        Hotel[] hotels = {hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7};

        try {
            for (Hotel ho : hotels) {
                hotelController.addHotel(ho);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

            for (StackTraceElement stackTrace : e.getStackTrace()) {
                System.err.println(stackTrace);
            }
        }
    }

}

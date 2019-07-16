package lesson11.homework11;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1, 60, 5, new Date(), "Bratislava", "Kiev");
        Room room2 = new Room(2, 0, 5, new Date(), "Kiev", "Kiev");
        Room room3 = new Room(3, 1000, 5, new Date(), "Golosievo", "Kiev");
        Room room4 = new Room(4, 565, 5, new Date(), "Mir", "Kiev");
        Room room5 = new Room(5, 0, 5, new Date(), "Drujba", "Kiev");

        Room[] rooms = new Room[]{room1, room2, null, room4, room5, room3};

        BookingComAPI api1 = new BookingComAPI(rooms);
        API api2 = new TripAdvisorAPI(rooms);
        API api3 = new GoogleAPI(rooms);


        API[] apis = new API[]{
                new BookingComAPI(rooms),
                new TripAdvisorAPI(rooms),
                new GoogleAPI(rooms)
        };

        Controller  controller = new Controller(apis);



        System.out.println((controller.cheapestRoom() != null ? controller.cheapestRoom().getHotelName() : null));
    }

    public static void roomsF(API api, Room[] room) {
        api.findRooms(60, 5, null, null);
    }


}

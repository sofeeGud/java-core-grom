package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Authorization;
import lesson35.model.Room;
import lesson35.repository.HotelRepository;

import java.util.Date;

import static lesson35.demo.Demo.auth;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        auth = new Authorization();
        auth.login("login11", "password1");

        RoomController roomController = new RoomController();
        Room room1 = new Room(0, 2, 210, false, false, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room room2 = new Room(0, 4, 560, true, false, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room room3 = new Room(0, 3, 460, false, false, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room room4 = new Room(0, 3, 330, true, false, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room room5 = new Room(0, 4, 1200, true, true, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room room6 = new Room(0, 2, 600, true, true, new Date(), new HotelRepository().findHotelById(1575747517072L));
        Room[] rooms = {room1, room2, room3, room4, room5, room6};


        try {
            for (Room room : rooms) {
                roomController.addRoom(room);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

            for (StackTraceElement stackTrace : e.getStackTrace()) {
                System.err.println(stackTrace);
            }
        }
    }

}

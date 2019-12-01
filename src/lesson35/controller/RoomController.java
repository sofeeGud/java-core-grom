package lesson35.controller;

import lesson35.model.Room;
import lesson35.service.RoomService;

public class RoomController {

    private RoomService roomService;

    public RoomController() throws Exception {
        roomService = new RoomService();
    }

    public Room addRoom(Room room) {
        return roomService.addRoom(room);
    }
}

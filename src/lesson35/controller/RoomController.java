package lesson35.controller;

import lesson35.demo.Demo;
import lesson35.model.Room;
import lesson35.model.UserType;
import lesson35.service.RoomService;

public class RoomController extends Controller {

    private RoomService roomService;

    public RoomController() throws Exception {
        roomService = new RoomService();
        authorization = Demo.auth;
    }

    public Room addRoom(Room room) throws Exception {
        isAccess(UserType.ADMIN);
        return roomService.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        isAccess(UserType.ADMIN);
        roomService.deleteRoom(roomId);
    }
}

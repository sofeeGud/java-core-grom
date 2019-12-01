package lesson35.service;

import lesson35.model.Room;
import lesson35.repository.RoomRepository;

public class RoomService {

    private RoomRepository roomRepository;

    public RoomService() throws Exception {
        roomRepository = new RoomRepository();
    }

    public Room addRoom(Room room) throws NullPointerException {
        room.setId(roomRepository.genId());
        try {
            if (!validateRoom(room))
                System.err.println("Room with id=" + room.getId() + " can not be registered");
            else
                roomRepository.insertRoom(room);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return room;
    }

    private boolean validateRoom(Room room) {
        if ((room.getNumberOfGuests() == 0) || (room.getPrice() == 0) ||
                (room.getDateAvailableFrom() == null) || (room.getHotel() == null)) {
            System.err.println("Empty fields for room registration");
            return false;
        }
        return true;
    }
}

package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.Set;

public class RoomService {

    private RoomRepository roomRepository;

    public RoomService() throws Exception {
        roomRepository = new RoomRepository();
    }

    public Room addRoom(Room room) throws Exception {
        room.setId(roomRepository.genId());
        try {
            if (!validateRoom(room))
                System.err.println("Room with id=" + room.getId() + " can not be registered in method addRoom");
            else
                roomRepository.insertRoom(room);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return room;
    }

    private boolean validateRoom(Room room) {
        if ((room.getNumberOfGuests() == 0) || (room.getPrice() == 0) ||
                (room.getHotel() == null)) {
            System.err.println("Empty fields for room registration in method validateRoom");
            return false;
        }
        return true;
    }

    public void deleteRoom(long roomId) throws Exception {
        roomRepository.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws Exception {
       return roomRepository.findRooms(filter);
    }
}

package lesson35.repository;

import lesson35.model.Room;

import java.text.SimpleDateFormat;

public class RoomRepository extends Repository<Room> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/RoomDb.txt";

    public RoomRepository() {
        super(path);
    }

    public Room insertRoom(Room room) throws Exception {
        getAll();
        return writeToFile(room);
    }

    @Override
    public Room parse(String line) throws Exception {
        String[] roomArr = line.split(",");
        return new Room(Long.parseLong(roomArr[0]), Integer.parseInt(roomArr[1]), Double.parseDouble(roomArr[2]),
                Boolean.parseBoolean(roomArr[3]), Boolean.parseBoolean(roomArr[4]),
                new SimpleDateFormat("dd-MM-yyyy").parse(roomArr[5]),
                new HotelRepository().findHotelById(Long.parseLong(roomArr[6])));
    }

    public Room findRoomById(Long id) throws Exception {
        for (Room room : getAll()) {
            if (room.getId() == id)
                return room;
        }
        return null;
    }

    public void deleteRoom(long roomId) throws Exception {
        cleanFromDb(findRoomById(roomId).getId());
    }
}

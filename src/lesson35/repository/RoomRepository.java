package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class RoomRepository extends Repository<Room> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/RoomDb.txt";

    public RoomRepository() {
        super(path);
    }

    public Room insertRoom(Room room) throws Exception {
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

    public Long updateDateRoom(Room room) throws Exception {
        for (Room ro : getAll()) {
            if (ro.getId() == room.getId()) {
                deleteRoom(room.getId());
                Date newDate = room.setDateAvailableFrom(new Date());
                Room newDateRoom = new Room(room.getId(), room.getNumberOfGuests(), room.getPrice(), room.isBreakfastIncluded(),
                        room.isPetsAllowed(), newDate, room.getHotel());
                writeToFile(newDateRoom);
            }
        }
        return room.getId();
    }

    public Set<Room> findRooms(Filter filter) throws Exception {
        Set<Room> rooms = new HashSet<>();
            for (Room room : getAll()) {
                if ((filter.getNumberOfGuests() == room.getNumberOfGuests()) &&
                        (filter.getPrice() == room.getPrice()) &&
                        (filter.getDateAvailableFrom().after(room.getDateAvailableFrom())) &&
                        (filter.isBreakfastIncluded() == room.isBreakfastIncluded()) &&
                        (filter.isPetsAllowed() == room.isPetsAllowed()) &&
                        (filter.getCity().equals(room.getHotel().getCity())) &&
                        (filter.getCountry().equals(room.getHotel().getCountry())))
                    rooms.add(room);
            }

            if (rooms.isEmpty())
                System.out.println("Rooms not be found");

        return rooms;
    }

}

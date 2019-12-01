package lesson35.repository;

import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class RoomRepository extends Repository<Room> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/RoomDb.txt";

    public RoomRepository() throws Exception {
        super(path);
    }

    public Room insertRoom(Room room) throws Exception {
        mapping();
        return writeToFile(room);
    }


    public Set<Room> mapping() throws Exception {

        Set<Room> users = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(parseRoom(line));
            }
        } catch (IOException e) {
            throw new Exception("Reading from file " + path + " failed");
        }
        return users;
    }

    private Room parseRoom(String line) throws Exception {
        String[] roomArr = line.split(",");
        return new Room(Long.parseLong(roomArr[0]), Integer.parseInt(roomArr[1]), Double.parseDouble(roomArr[2]),
                Boolean.parseBoolean(roomArr[3]), Boolean.parseBoolean(roomArr[4]),
                new SimpleDateFormat("dd-MM-yyyy").parse(roomArr[5]),
                new HotelRepository().findHotelById(Long.parseLong(roomArr[6])));
    }


}

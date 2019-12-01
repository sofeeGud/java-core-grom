package lesson35.repository;

import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HotelRepository extends Repository<Hotel> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/HotelDb.txt";

    public HotelRepository() {
        super(path);
    }

    public Hotel insertHotel(Hotel hotel) throws Exception {
        mapping();
        return writeToFile(hotel);

    }

    public Set<Hotel> mapping() throws Exception {

        Set<Hotel> users = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(parseHotel(line));
            }
        } catch (IOException e) {
            throw new Exception("Reading from file " + path + " failed");
        }
        return users;
    }

    private Hotel parseHotel(String line) {
        String[] hotelArr = line.split(",");
        return new Hotel(Long.parseLong(hotelArr[0]), hotelArr[1], hotelArr[2], hotelArr[3], hotelArr[4]);
    }

    public Hotel findHotelById(Long id) throws Exception {
        for (Hotel hotel : mapping()) {
            if (hotel.getId() == id)
                return hotel;
        }
        return null;
    }
}

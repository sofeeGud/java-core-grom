package lesson35.repository;

import lesson35.model.Hotel;

public class HotelRepository extends Repository<Hotel> {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/HotelDb.txt";

    public HotelRepository() {
        super(path);
    }

    public Hotel insertHotel(Hotel hotel) throws Exception {
        getAll();
        return writeToFile(hotel);
    }

    @Override
    public Hotel parse(String line) {
        String[] hotelArr = line.split(",");
        return new Hotel(Long.parseLong(hotelArr[0]), hotelArr[1], hotelArr[2], hotelArr[3], hotelArr[4]);
    }

    public Hotel findHotelById(Long id) {
        try {
            for (Hotel hotel : getAll()) {
                if (hotel.getId() == id)
                    return hotel;
            }
        } catch (Exception e) {
            System.err.println("Hotel with id=" + id + " was not found in method findHotelById");
        }
        return null;
    }

    public Hotel findHotelByName(String name) {
        try {
            for (Hotel hotel : getAll()) {
                if (hotel.getName().equals(name))
                    return hotel;
            }
        } catch (Exception e) {
            System.err.println("Hotel with name= " + name + " was not found in method findHotelByName");
        }
        return null;
    }

    public Hotel findHotelByCity(String city) {
        try {
            for (Hotel hotel : getAll()) {
                if (hotel.getCity().equals(city))
                    return hotel;
            }
        } catch (Exception e) {
            System.err.println("Hotel with city= " + city + " was not found  in method findHotelByCity");
        }
        return null;
    }

    public void deleteHotel(long hotelId) throws Exception {
        cleanFromDb(findHotelById(hotelId).getId());
    }
}

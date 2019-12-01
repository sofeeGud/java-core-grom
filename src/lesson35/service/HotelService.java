package lesson35.service;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService() throws Exception {
        hotelRepository = new HotelRepository();
    }

    public Hotel addHotel(Hotel hotel) throws NullPointerException {
        hotel.setId(hotelRepository.genId());
        try {

            if (!validateHotel(hotel) || hotel.getName() == null || hotel.getStreet() == null
                    || hotel.getCountry() == null || hotel.getCity() == null) {
                System.err.println("Hotel with id=" + hotel.getId() + " can not be registered");
            } else hotelRepository.insertHotel(hotel);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hotel;
    }

    public boolean validateHotel(Hotel hotel) throws Exception {
        for (Hotel ho : hotelRepository.mapping()) {
            if ((ho.getName().equals(hotel.getName())) && (ho.getCity().equals(hotel.getCity())) &&
                    (ho.getCountry().equals(hotel.getCountry())) && (ho.getStreet().equals(hotel.getStreet()))) {
                System.err.println("Hotel is already registered");
                return false;
            }

        }
        return true;
    }
}

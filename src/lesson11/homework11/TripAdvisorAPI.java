package lesson11.homework11;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int len = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (persons > 0 && room.getPersons() > 0) {
                    if (price == room.getPrice() && city == room.getCityName() && hotel == room.getHotelName()) {
                        if (persons == room.getPersons()
                                || persons == (room.getPersons() - 1)
                                || persons == (room.getPersons() + 1)) {
                            len++;
                        }
                    }
                }
            }
        }
        Room[] roomPer = new Room[len];
        int i = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (persons > 0 && room.getPersons() > 0) {
                    if (price == room.getPrice() && city == room.getCityName() && hotel == room.getHotelName()) {
                        if (persons == room.getPersons()
                                || persons == (room.getPersons() - 1)
                                || persons == (room.getPersons() + 1)) {
                            roomPer[i++] = room;
                        }
                    }
                }
            }
        }



//        for (Room room : rooms) {
//            if (room != null && persons > 0 && room.getPersons() > 0 && price == room.getPrice()
//                    && persons > (room.getPersons() - 1) && persons < (room.getPersons() + 1)
//                    && city == room.getCityName()
//                    && hotel == room.getHotelName()) {
//                roomPer[i++] = room;
//            } else
//                return null;
//        }
        return roomPer;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

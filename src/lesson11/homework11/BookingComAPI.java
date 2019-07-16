package lesson11.homework11;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int len = 0;
        for (Room room : rooms) {
            if (room != null && (price > (room.getPrice() - 100) && price < (room.getPrice() + 100))
                    && persons == room.getPersons() && city == room.getCityName()
                    && hotel == room.getHotelName()) {
                len++;
            }
        }
        Room[] roomPr = new Room[len];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && (price > (room.getPrice() - 100) && price < (room.getPrice() + 100))
                    && persons == room.getPersons() && city == room.getCityName()
                    && hotel == room.getHotelName()){
                roomPr[i++] = room;
            }
        }
        return roomPr;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

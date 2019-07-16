package lesson11.homework11;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {


        int len = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && persons == room.getPersons()
                    && city == room.getCityName() && hotel == room.getHotelName()) {
                len++;
            }
        }
        Room[] roomAll = new Room[len];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && persons == room.getPersons()
                    && city == room.getCityName() && hotel == room.getHotelName()) {
                roomAll[i++] = room;
            }
        }
        return roomAll;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

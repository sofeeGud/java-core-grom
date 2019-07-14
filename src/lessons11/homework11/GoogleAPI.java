package lessons11.homework11;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {


        int len = 0;
        for (Room room : rooms) {
            if (room != null && price == price && persons == persons && city == city && hotel == hotel) {
                len++;
            }
        }
        Room[] roomAll = new Room[len];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && price == price && persons == persons && city == city && hotel == hotel) {
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

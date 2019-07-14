package lessons11.homework11;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int len = 0;
        for (Room room : rooms) {
            if (room != null && price == price && (persons > (persons - 1) || persons < (persons + 1)) && city == city && hotel == hotel) {
                len++;
            }
        }
        Room[] roomPer = new Room[len];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && price == price && (persons > (persons - 1) || persons < (persons + 1)) && city == city && hotel == hotel) {
                roomPer[i++] = room;
            }
        }
        return roomPer;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

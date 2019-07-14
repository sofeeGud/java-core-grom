package lessons11.homework11;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int len = 0;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room != null && price == room.getPrice() &&
                        persons == room.getPersons() &&
                        city == room.getCityName() &&
                        hotel == room.getHotelName()) {
                    len++;
                }
            }
        }

        int i = 0;
        Room[] roomReq = new Room[len];
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room != null && price == room.getPrice() &&
                        persons == room.getPersons() &&
                        city == room.getCityName() &&
                        hotel == room.getHotelName()) {
                    roomReq[i++] = room;
                }
            }

        }
        return roomReq;

    }

    public Room[] check(API api1, API api2) {

        int len = 0;
        for (Room room1 : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room1.getCityName() == room2.getCityName()
                        && room1.getHotelName() == room2.getHotelName()
                        && room1.getPersons() == room2.getPersons()
                        && room1.getPrice() == room2.getPrice())
                    len++;
            }
        }

        Room[] arr = new Room[len];
        int i = 0;
        for (Room room1 : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room1.getCityName() == room2.getCityName()
                        && room1.getHotelName() == room2.getHotelName()
                        && room1.getPersons() == room2.getPersons()
                        && room1.getPrice() == room2.getPrice())
                    arr[i++] = room1;
            }
        }


        return arr;
    }


    public Room cheapestRoom() {
        Room roomCh = null;
        int priceMin = 0;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (priceMin > room.getPrice()) {
                    roomCh = room;
                }
            }
        }
        return roomCh;

    }


}

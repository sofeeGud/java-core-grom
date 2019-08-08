package lesson11.homework11;

import java.util.Arrays;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        Room[] roomReq;
        Room[] result = new Room[0];
        for (API api : apis) {
            if (api != null){
                 roomReq = api.findRooms(price, persons, city, hotel);
                  if (roomReq != null) result = arrayPush(result, roomReq);
            }
        }

        return result;
    }

    public Room[] arrayPush(Room[] roomReq, Room[] result) {
        Room[] sum = new Room[roomReq.length + result.length];

        int i = 0;
        for (Room room : roomReq) {
            sum[i++] = room;
        }
        for (Room room : result) {
            sum[i++] = room;
        }
        return sum;
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
        int priceMin = 9999999;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room != null && room.getPrice() <= priceMin) {
                    priceMin = room.getPrice();
                    roomCh = room;
                }
            }
        }
        return roomCh;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Controller that = (Controller) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(apis, that.apis);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(apis);
    }
}

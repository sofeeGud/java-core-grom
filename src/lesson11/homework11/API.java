package lesson11.homework11;

public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();

}

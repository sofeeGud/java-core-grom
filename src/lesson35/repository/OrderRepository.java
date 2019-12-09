package lesson35.repository;

import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderRepository extends Repository {
    private static final String path = "C:/Users/Lenovo T540p/Desktop/OrderDb.txt";
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();
    HotelRepository hotelRepository = new HotelRepository();

    public OrderRepository() throws Exception {
        super(path);
    }

    @Override
    public Order parse(String line) throws Exception {
        String[] orderArr = line.split(",");
        return new Order(Long.parseLong(orderArr[0]), new UserRepository().findUserById(Long.parseLong(orderArr[1])),
                new RoomRepository().findRoomById(Long.parseLong(orderArr[2])),
                new SimpleDateFormat("dd-MM-yyyy").parse(orderArr[3]),
                new SimpleDateFormat("dd-MM-yyyy").parse(orderArr[4]), Double.parseDouble(orderArr[5]));
    }

    public void bookRoom(long roomId, long userId, Date dateTo) throws Exception {
        OrderRepository orderRepository = new OrderRepository();
        User user = new UserRepository().findUserById(userId);
        Room room = new RoomRepository().findRoomById(roomId);
        long orderId = genId();
        double price = (room.getPrice()) * (countDayBooking(new RoomRepository().findRoomById(roomId).getDateAvailableFrom(), dateTo));
        Order order = new Order(orderId, user, room, room.getDateAvailableFrom(), dateTo, price);
        orderRepository.writeToFile(order);
    }

    void cancelReservation(long roomId, long userId) {

    }

    private Long countDayBooking(Date from, Date to) {
        long time = to.getTime() - from.getTime();
        return (time / (24 * 60 * 60 * 1000));
    }

    public boolean validateOrder(long roomId, long userId, long hotelId) throws Exception {
        if ((userRepository.findUserById(userId)!=null) || (roomRepository.findRoomById(roomId)!=null) ||
        ( (hotelRepository.findHotelById(hotelId).getId()) == (roomRepository.findRoomById(roomId).getHotel().getId()))){
    return true;
        }
        return false;
    }
}

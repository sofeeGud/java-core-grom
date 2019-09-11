package lesson26;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest {
    public static void main(String[] args) {
        Order order1 = new Order(1, 20, "eur", "order1", "111");
        Order order2 = new Order(2, 233, "eur", "order2", "111");
        Order order3 = new Order(3, 56, "eur", "order3", "111");
        Order order4 = new Order(4, 598, "eur", "order4", "111");
        Order order5 = new Order(5, 200000, "eur", "order5", "111");

        Order[] orders1 = {order1, order2, order3};
        Order[] orders2 = {order4, order5};

        ArrayList<Order> orders_1 = new ArrayList<>();
        ArrayList<Order> orders_2 = new ArrayList<>();

        System.out.println(useList(orders1, orders_1));


    }

    private static ArrayList<Order> useList(Order[] order, ArrayList<Order> arrayList){
        arrayList.add(order[0]);
        arrayList.add(order[1]);
        arrayList.add(order[2]);
        arrayList.add(order[0]);
        arrayList.add(order[1]);

        return arrayList;
    }
}

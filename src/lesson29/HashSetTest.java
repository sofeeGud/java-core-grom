package lesson29;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Order order1 = new Order(1, 21, "eur", "order1", "235");
        Order order2 = new Order(2, 223, "eur", "order2", "598");
        Order order3 = new Order(3, 57, "eur", "order3", "15898");
        Order order4 = new Order(4, 598, "eur", "order4", "26584");
        Order order5 = new Order(5, 200000, "eur", "order5", "kiui");

        try {
            Order[] orders = {order1, order2, order3, order4, order5};
            Order[] orders1 = new Order[5];
            System.out.println(useHashSet(orders1));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static Set<Order> useHashSet(Order[] order) throws Exception {
        Set<Order> orders = new HashSet<>();
        if (order == null) {
            throw new Exception("null can't be used");
        } else {
            orders.add(order[0]);
            orders.add(order[1]);
            orders.add(order[2]);
            orders.remove(order[1]);
            System.out.println(orders);
            orders.removeAll(orders);
            orders.add(order[3]);
            orders.add(order[4]);
            Iterator<Order> iterator = orders.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getItemName());
            }

            Object[] hashSet = orders.toArray();
            for (int i = 0; i < hashSet.length; i++) {
                System.out.println(hashSet[i]);
            }
            System.out.println(orders.size());

            return orders;
        }
    }
}

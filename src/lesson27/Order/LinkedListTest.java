package lesson27.Order;


import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        Order order1 = new Order(1, 20, "eur", "order1", "235");
        Order order2 = new Order(2, 233, "eur", "order2", "598");
        Order order3 = new Order(3, 56, "eur", "order3", "15898");
        Order order4 = new Order(4, 598, "eur", "order4", "26584");
        Order order5 = new Order(5, 200000, "eur", "order5", "kiui");


        try {
            Order[] orders1 = {order1, order2, order3, order4, order5};
            Order[] orders2 = {order4, order5};
            Order[] orders3 = null;

            LinkedList<Order> orders_1 = new LinkedList<>();
            LinkedList<Order> orders_2 = new LinkedList<>();
            System.out.println(useList(orders1, orders_1, orders_2));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }

    private static LinkedList<Order> useList(Order[] orders, LinkedList<Order> linkedList1, LinkedList<Order> linkedList2) throws Exception {
        if (orders == null || linkedList1 == null) {
            throw new Exception("null can't be used");
        } else {

            linkedList1.add(orders[0]);
            linkedList1.add(orders[1]);
            linkedList1.add(orders[2]);
            linkedList1.add(orders[3]);
            linkedList1.add(1, orders[4]);
            linkedList1.remove(orders[0]);
            linkedList1.remove(0);
            linkedList2.add(orders[0]);
            linkedList2.add(orders[4]);
            linkedList1.addAll(linkedList2);
            linkedList1.subList(0, 2);
            linkedList1.set(2, orders[2]);
            linkedList1.contains(orders[3]);

            Object[] listArray = linkedList1.toArray();
            for (int i = 0; i < listArray.length; i++) {
                System.out.println(listArray[i]);
            }
            linkedList2.clear();

            return linkedList1;
        }
    }
}

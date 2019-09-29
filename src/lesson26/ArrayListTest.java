package lesson26;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        Order order1 = new Order(1, 20, "eur", "order1", "111");
        Order order2 = new Order(2, 233, "eur", "order2", "111");
        Order order3 = new Order(3, 56, "eur", "order3", "111");
        Order order4 = new Order(4, 598, "eur", "order4", "111");
        Order order5 = new Order(5, 200000, "eur", "order5", "111");


        try {
            Order[] orders1 = {order1, order2, order3, order4,order5};
            Order[] orders2 = {order4, order5};
            Order[] orders3 = null;

            ArrayList<Order> orders_1 = new ArrayList<>();
            ArrayList<Order> orders_2 = new ArrayList<>();
            System.out.println(useList(orders1, orders_1, orders_2));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }

    private static ArrayList<Order> useList(Order[] orders, ArrayList<Order> arrayList1, ArrayList<Order> arrayList2) throws Exception{
        if (orders == null || arrayList1 == null){
            throw new Exception("null can't be used");}
        else {

            arrayList1.add(orders[0]);
            arrayList1.add(orders[1]);
            arrayList1.add(orders[2]);
            arrayList1.add(orders[3]);
            arrayList1.add(1, orders[4]);
            arrayList1.remove(orders[0]);
            arrayList1.remove(0);
            arrayList2.add(orders[0]);
            arrayList2.add(orders[4]);
            arrayList1.addAll(arrayList2);
            arrayList1.subList(0,2);
            arrayList1.set(2, orders[2]);
            arrayList1.contains(orders[3]);

            Object[] listArray = arrayList1.toArray();
            for (int i = 0; i < listArray.length; i++) {
                System.out.println(listArray[i]);
            }
            arrayList2.clear();

            return arrayList1;
        }
    }
}

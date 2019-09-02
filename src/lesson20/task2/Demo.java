package lesson20.task2;


import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1, "Odessa", 10, "222", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Lvov", 5, "333", TransactionType.INCOME, new Date());
        Transaction transaction3 = null;
        Transaction transaction4 = new Transaction(4, "Kiev", 10, "222", TransactionType.INCOME, new Date());
        Controller controller = new Controller();
        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction4};

        for (Transaction transaction : transactions) {
            try {
                controller.save(transaction);
                ;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println(Arrays.deepToString(controller.transactionList()));
        System.out.println(Arrays.deepToString(controller.transactionList("Odessa")));
        System.out.println(Arrays.deepToString(controller.transactionList(10)));
    }
}

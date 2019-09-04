package lesson22.task2;


import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1, "Odessa", 10, "222", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Lvov", 5, "333", TransactionType.INCOME, new Date());
        Transaction transaction3 = null;
        Transaction transaction4 = new Transaction(4, "Kiev", 10, "222", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(4, "Kiev", 10, "222", TransactionType.INCOME, new Date());
        //Controller controller = new Controller();
        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction4, transaction5};

        for (Transaction transaction : transactions) {
            try {
                Controller.save(transaction);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.println(Arrays.deepToString(Controller.transactionList()));
        System.out.println(Arrays.deepToString(Controller.transactionList("Odessa")));
        System.out.println(Arrays.deepToString(Controller.transactionList(10)));
    }
}

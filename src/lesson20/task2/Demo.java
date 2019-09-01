package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {

        Transaction transaction0 = new Transaction(0, "Kiev", 5, "111", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(1, "Odessa", 12, "222", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Lvov", 10, "333", TransactionType.INCOME, new Date());
        Controller controller = new Controller();
        Transaction[] list = {transaction0, transaction1, null, null, null};


        try {
            System.out.println(controller.save(new Transaction(3, "Lvov", 100, "333", TransactionType.INCOME, new Date())).getId());

        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
        } catch (InternalServerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println(Arrays.toString(controller.transactionList("Odessa")));
        System.out.println(Arrays.toString(controller.transactionList(10)));

    }
}

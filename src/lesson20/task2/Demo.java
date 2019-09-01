package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

import java.util.Arrays;
import java.util.Date;


public class Demo {
    public static void main(String[] args) {
        Transaction transaction0 = new Transaction(0, "Kiev", 10, "nnn", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(1, "Poltava", 15, "nnn", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Odessa", 105, "nnn", TransactionType.INCOME, new Date());
        Transaction[] list = {transaction0, transaction1, transaction2, null};
        Controller controller = new Controller();
        try {controller.save(transaction0) ;
            //Transaction transaction0 = new Transaction(0, "Kiev", 10, "nnn", TransactionType.INCOME, new Date());

        } catch (Exception e){
            System.out.println("error");}
        System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(controller.transactionList(10)));
        System.out.println(Arrays.toString(controller.transactionList()));


    }
    }

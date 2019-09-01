package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {


    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);

    }

    public Transaction[] transactionList(){

        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city){
        return transactionDAO.transactionList(city);

    }

    Transaction[] transactionList(int amount){
        return transactionDAO.transactionList(amount);

    }
}

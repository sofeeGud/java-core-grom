package lesson22.task2;


public class Controller {
    //private static TransactionDAO transactionDAO = new TransactionDAO();


    public static Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) {

        return TransactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) {

        return TransactionDAO.transactionList(amount);
    }

}
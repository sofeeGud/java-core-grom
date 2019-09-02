package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];

    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {

        validate(transaction);

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[i] = transaction;
                return transactions[i];
            }
            i++;
        }

        throw new InternalServerException("No free space for transaction " + transaction.getId());
    }

    private void validate(Transaction transaction) throws BadRequestException {

        if (transaction == null)
            throw new BadRequestException("Transaction is null. Can't be saved");

        for (Transaction tr : transactions) {
            if (tr != null && tr.getId() == transaction.getId())
                throw new BadRequestException("Transaction already used " + transaction.getId() + ". Can't be saved");
        }


        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");


        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            if (tr != null) {
                sum += tr.getAmount();
                count++;
            }
        }


        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count >= utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }


//        for (String city : utils.getCities()) {
//            if (city != null && city.equals(transaction.getCity()))
//                return;
//        }
//        throw new BadRequestException("Transaction in city: " + transaction.getCity() + " Can't be saved");


    }

    public Transaction[] transactionList() {
        int len = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                len++;
        }

        Transaction[] transactionList = new Transaction[len];

        if (len == 0) return transactionList;

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                transactionList[i] = tr;
                i++;
            }
        }
        return transactionList;
    }

    public Transaction[] transactionList(String city) {

        int len = 0;
        for (Transaction tr : transactions) {
            if (city != null && tr != null && city.equals(tr.getCity())) {
                len++;
            }
        }

        Transaction[] transactionList = new Transaction[len];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && city != null && city.equals(tr.getCity())) {
                transactionList[i] = tr;
                i++;
            }
        }
        return transactionList;
    }

    public Transaction[] transactionList(int amount) {

        int len = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                len++;
            }
        }

        Transaction[] transactionList = new Transaction[len];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                transactionList[i] = tr;
                i++;
            }
        }
        return transactionList;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trYear = calendar.get(Calendar.YEAR);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trYear == year && trMonth == month && trDay == day)
                    count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trYear = calendar.get(Calendar.YEAR);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trYear == year && trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
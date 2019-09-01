package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws InternalServerException, BadRequestException {

        validate(transaction);

        for (int i= 0;i< transactions.length;i++){
            if (transactions[i] == null) {
                transactions[i] = transaction;
                return transactions[i];
            }
        }
        throw new InternalServerException("No free space for transaction " + transaction.getId());
    }

    private void validate(Transaction transaction) throws BadRequestException, InternalServerException {

        if(transaction==null)
            throw new BadRequestException("Transaction can't be null");

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit  exceed " + transaction.getId() + ". Can't be saved");

        long sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount()> utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (count  >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        boolean flagCity = false;
        for (String city : utils.getCities()) {
            if (city == transaction.getCity())
                flagCity = true;
        }

        if (!flagCity)
            throw new BadRequestException("Transaction in city: " + transaction.getCity() + " Can't be saved");

        boolean flagFreeSpace = false;
        for (Transaction tr : transactions)
            if (tr == null)
                flagFreeSpace = true;

        if (!flagFreeSpace)
            throw new InternalServerException("No free space for transaction " + transaction.getId());

        for (Transaction tr : transactions)
            if (tr != null && tr.equals(transaction))
                throw new BadRequestException("Transaction already exist id: " + transaction.getId());


    }
        public Transaction[] transactionList () {

            int len = 0;
            Transaction[] transactionsList = new Transaction[len];
            for (Transaction tr : transactions) {
                transactions[len] = tr;
                len++;
            }

            return transactionsList;

        }

        public Transaction[] transactionList (String city){

            int count = 0;

            for (Transaction tr : transactions) {
                if (tr != null && tr.getCity().equals(city))
                    transactions[count] = tr;
                count++;
            }

            int i = 0;
            Transaction[] transactionsList = new Transaction[count];
            for (Transaction tr : transactions) {
                if (tr != null && tr.getCity().equals(city))
                    transactions[i] = tr;
                i++;
            }

        return transactionsList;
    }

    public Transaction[] transactionList(int amount) {

        if (transactions == null)
            return  new Transaction[0];
        int count = 0;
        for (Transaction tr : transactions)
            if (tr != null &&tr.getAmount()>0)
                count++;

        if (count == 0)
            return  new Transaction[0];

        Transaction[] transactionList = new Transaction[count];
        int i = 0;
        for (Transaction tr : transactions)
            if (tr != null&&tr.getAmount()>0) {
                transactionList[i] = tr;
                i++;
            }
        return transactionList;

    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }


}

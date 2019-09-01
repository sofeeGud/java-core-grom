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


    private void validate(Transaction transaction) throws InternalServerException, BadRequestException {

        /*сумма транзакции больше указанного лимита +
        - сумма транзакций за день больше дневного лимита +
        - количество транзакций за день больше указанного лимита +
        - если город оплаты (совершения транзакции) не разрешен +
        - нет места + */

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
            if (sum > utils.getLimitTransactionsPerDayAmount())
                throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");


            if (count > utils.getLimitTransactionsPerDayCount())
                throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");

            boolean flagCity = false;
            for (String city : utils.getCities()) {
                if (city == transaction.getCity())
                    flagCity = true;
            }

            if (!flagCity)
                throw new BadRequestException("Transaction in city: " + transaction.getCity() + " Can't be saved");

            boolean flagFreeSpace = false;
            for (Transaction tr1 : transactions)
                if (tr1 == null)
                    flagFreeSpace = true;

            if (!flagFreeSpace)
                throw new InternalServerException("No free space for transaction " + transaction.getId());

            for (Transaction tr2 : transactions)
                if (tr2 != null && tr2.equals(transaction))
                    throw new InternalServerException("No free space for transaction " + transaction.getId());
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

        int count = 0;

        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount)
                transactions[count] = tr;
            count++;
        }

        int i = 0;
        Transaction[] transactionsList = new Transaction[count];
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount)
                transactions[i] = tr;
            i++;
        }
        return transactionsList;

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

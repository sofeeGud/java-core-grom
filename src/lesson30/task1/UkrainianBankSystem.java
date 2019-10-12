package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {


        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(),TransactionType.WITHDRAWAL, amount, "sdsdc" );
    }


    @Override
    public void fund(User user, int amount) {

        if (!checkLimitOfFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount); // - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(),TransactionType.FUNDING, amount, "sdsdc" );



    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            System.err.println("Change currency...");

        } else {

            if (!checkWithdraw(fromUser, amount))
                return;

            if (!checkLimitOfFunding(toUser, amount))
                return;

            fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

            toUser.setBalance(toUser.getBalance() + amount);
        }

        createAndSaveTransaction(new Date(),TransactionType.TRANSFER, amount, "sdsdc" );

    }

    @Override
    public void paySalary(User user) {
        if (!checkLimitOfFunding(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

        createAndSaveTransaction(new Date(),TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc" );

    }

    private boolean checkWithdraw(User user, int amount) {
        return checkLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkLimits(user, amount, user.getBalance());
    }

    private boolean checkLimitOfFunding(User user, int amount) {
        return checkLimits(user, amount, user.getBank().getLimitOfFunding());
    }


    private boolean checkLimits(User user, int amount, double limit) {
        if (amount + amount * user.getBank().getCommission(amount) > limit) {
            printWihtdrawalErrorMsg(amount, user);
            return false;
        }
        return true;


    }

    private void printWihtdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money" + amount + "from use" + user.toString());
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}

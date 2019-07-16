package lesson12;

public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {


        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }


    @Override
    public void fund(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() + amount - amount * user.getBank().getCommission(amount));


    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (!checkWithdraw(fromUser, amount))
            return;

        if (!checkWithdraw(toUser, amount))
            return;

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

        toUser.setBalance(toUser.getBalance() + amount - amount * toUser.getBank().getCommission(amount));





    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBank().getAvrSalaryOfEmployee());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }
    private boolean checkLimitOfFunding(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfFunding());
    }


    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWihtdrawalErrorMsg(amount, user);
            return false;
        }
        return true;

    }

    private void printWihtdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money" + amount + "from use" + user.toString());
    }
}

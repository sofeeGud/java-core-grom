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

        if (!checkLimitOfFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount); // - amount * user.getBank().getCommission(amount));


    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()){
            System.err.println("Change currency...");

        } else {

            if (!checkWithdraw(fromUser, amount))
                return;

            if (!checkLimitOfFunding(toUser, amount))
                return;

            fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

            toUser.setBalance(toUser.getBalance() + amount);
        }
    }

    @Override
    public void paySalary(User user) {
        if (!checkLimitOfFunding(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkLimits(user, amount, user.getBalance());
    }
    private boolean checkLimitOfFunding(User user, int amount) {
        return checkLimits(user, amount, user.getBank().getLimitOfFunding());
    }


    private boolean checkLimits(User user, int amount, double limit) {
        if (amount + amount* user.getBank().getCommission(amount) > limit) {
            printWihtdrawalErrorMsg(amount, user);
            return false;
        }
        return true;

    }

    private void printWihtdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money" + amount + "from use" + user.toString());
    }

}

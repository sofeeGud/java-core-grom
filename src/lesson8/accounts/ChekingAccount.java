package lesson8.accounts;

public class ChekingAccount extends Account {
    int limitOfExpenses;


    public ChekingAccount(String bankName, String ownerName, int moneyAmount, int limitOfExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOfExpenses = limitOfExpenses;
    }

    void wihtdraw(int amount) {
        if (moneyAmount > limitOfExpenses)
            return;
        moneyAmount -= amount;
    }


}

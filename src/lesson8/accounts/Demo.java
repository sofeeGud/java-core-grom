package lesson8.accounts;

public class Demo {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("Some Bank", "Denis", 1000, 50);
        savingAccount.depositMoney(100);

        System.out.println(savingAccount.moneyAmount);

        savingAccount.chageOwnerName("Oleg");
        System.out.println(savingAccount.ownerName);

        ChekingAccount chekingAccount = new ChekingAccount("Some Bank", "Denis", 1000, 500);
        chekingAccount.chageOwnerName("Oleg");
        System.out.println(chekingAccount.ownerName);


    }
}

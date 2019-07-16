package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 4443434);

        User user = new User(1001, "Denis", 12200, 40,"GMD",1500, usBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        //bankSystem.withdraw(user, 150);
        bankSystem.fund(user, 200);

        System.out.println(user.getBalance());
    }
}

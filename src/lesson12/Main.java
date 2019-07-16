package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 4443434);
        Bank chinaBank = new ChinaBank(1222, "Sweden", Currency.USD, 100, 1400, 4, 4443434);

        User user = new User(1001, "Denis", 12200, 40,"GMD",1500, usBank);
        User user2 = new User(1001, "Denis", 12200, 40,"GMD",1500, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.transferMoney(user, user2, 10);

        System.out.println(user.getBalance());
        System.out.println(user2.getBalance());
    }
}

package lesson5;

import java.util.Arrays;

public class Withdraw {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8732, -99, 12000, -54, 0};
        //withdraw(names, balances, "Ann", 500);
        //System.out.println(Arrays.toString(balances));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount) {

        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
            int balance = balances[clientIndex];
            if (amount > balance){
                return -1;
            }
            int res = balances[clientIndex] - amount;
            return res;

    }
}
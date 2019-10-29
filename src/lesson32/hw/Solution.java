package lesson32.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public void readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter 10 numbers:");

        byte count = 3;

        while (count != 0) {
            String input = br.readLine();
            String[] number = input.split(" ");

            if (!validateNumber(number)) {
                if (count == 1) {
                    System.err.println("Your numbers are wrong. Number attempts exceeded");
                }
                System.err.println("Your numbers are wrong. You have " + --count + " attempts to try again");
            } else
                System.out.println(sumOfNumbers(number));
        }
        br.close();
    }


    private boolean validateNumber(String[] numbers) {
        if (numbers.length != 10)
            return false;

        for (String num : numbers) {
            for (char ch : num.toCharArray())
                if (!Character.isDigit(ch))
                    return false;

            if (Integer.parseInt(num) > 100)
                return false;
        }
        return true;
    }

    private int sumOfNumbers(String[] numbers) {
        int sum = 0;
        for (String num : numbers)
            sum += Integer.parseInt(num);

        return sum;
    }
}


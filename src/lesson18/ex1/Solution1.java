package lesson18.ex1;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        String test = "22 jfufy56 455.58 fkdkde    5656 djffkg 2.569 ";
        //Sys.out.println(Arrays.toString(parseWords(test)));
        System.out.println((Arrays.toString(findNumbers(test))));
    }


    public static int[] findNumbers(String text) {
        String[] words = text.split(" ");
        double[] numbers = new double[words.length];

        for (int j = 0; j < words.length; j++) {
            try {
                numbers[j] = Double.parseDouble(words[j]);
            } catch (Exception e) {
                System.out.println("not a number");
            }
        }

        int n = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && numbers[i] != 0 && numbers[i] % 2 == 0)
                n++;
        }
        int[] foundNum = new int[n];
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && numbers[i] != 0 && numbers[i] % 2 == 0) {
                foundNum[k++] = (int) numbers[i];
            } else
                System.out.println("not a number");
        }
        return foundNum;
    }
}


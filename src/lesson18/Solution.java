package lesson18;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "jfufy 455.58 fkdkde 5656 djffkg 2.569 ";
        System.out.println(Arrays.toString(parseWords(test)));
        System.out.println(findNumbers(test));
    }

    public static String[] parseWords(String input) {
        String[] words = input.split(" ");
        String[] arr = new String[0];

        for (String word : words) {
            if (!word.isEmpty()) {
                char[] wordToChar = word.toCharArray();
                boolean flag = false;
                for (char sim : wordToChar) {
                    if (!Character.isLetter(sim))
                        flag = true;
                }
                if ( flag )  {
                    arr = arrayPush(arr, word);
                }
            }
        }

        return arr;
    }

    public static String[] arrayPush(String[] base_array, String new_word) {
        int array_len = base_array.length + 1;

        String[] new_array = new String[array_len];

        int i = 0;
        while (i < base_array.length) {
            new_array[i] = base_array[i];
            i++;
        }
        new_array[i] = new_word;

        return new_array;

    }

   public static int[] findNumbers(String text){
       String[] words = parseWords(text);
       double[] numbers = new double[words.length];
       int[] foundNum = new int[10];

       for (String word:words){
       for (int j = 0; j < words.length; j++) {
           numbers[j] = Double.parseDouble(word);
       }
       }
       for (int i = 0; i < words.length; i++) {
           if (numbers[i] % 2 == 0)
               numbers[i] = foundNum[i];
       }

       return foundNum;
   }
}

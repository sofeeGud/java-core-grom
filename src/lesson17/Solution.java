package lesson17;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "nn 655555555  h 555555 h  test23 h kkk AsrfdZ1 h YYYYkkjuh   nn j495   Ikmm^   jjjjj kkk  kkk";
        String test2 = "";
        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test2));


    }

    public static int countWords(String input) {
        String[] words = input.split(" ");
        int res = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                char[] wordToChar = word.toCharArray();
                boolean flag = true;
                for (char sim : wordToChar) {
                    if ((sim < 65 || sim > 90) && (sim < 97 || sim > 122))
                        flag = false;
                }
                if (flag)
                    res++;
            }
        }
        return res;
    }

    public static String[] parseWords(String input) {
        String[] words = input.split(" ");
        String[] arr = new String[0];

        for (String word : words) {
            if (!word.isEmpty()) {
                char[] wordToChar = word.toCharArray();
                boolean flag = false;
                for (char sim : wordToChar) {
                    if ((sim >= 65 && sim <= 90) || (sim >= 97 && sim <= 122))
                        flag = true;
                }
                if (flag) {
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


    public static String maxWord(String input) {
        String[] words = parseWords(input);
        String maxWord = null;
        if (words.length > 0) {
            maxWord = words[0];

            for (String word : words) {

                if (word.toCharArray().length > maxWord.toCharArray().length)
                    maxWord = word;
            }
        }

        return maxWord;
    }

    public static String minWord(String input) {
        String[] words = parseWords(input);
        String minWord = null;
        if (words.length > 0) {
            minWord = words[0];

            for (String word : words) {
                if (word.toCharArray().length < minWord.toCharArray().length) minWord = word;
            }
        }

        return minWord;
    }


    public static String mostCountedWord(String input) {
        String[] words = parseWords(input);


        if (words.length > 0) {
            int[] res = new int[words.length];

            for (String word : words) {
                for (int i = 0; i < words.length; i++) {
                    if (word.equals(words[i])) {
                        res[i]++;
                    }
                }
            }

            int maxCount = res[0];
            int iW = 0;
            for (int i = 0; i < res.length; i++) {
                if (res[i] > maxCount) {
                    maxCount = res[i];
                    iW = i;
                }
            }
            return words[iW];
        }
        return null;
    }

    public static boolean validate(String address){
        if (address == null || address.isEmpty())
            return false;

        address = address.trim();

        if (!address.startsWith("http://") && !address.startsWith("https://"))
            return false;

        if (!address.endsWith(".com") && !address.endsWith(".net") && !address.endsWith(".org"))
            return false;

        address = address.replaceAll("www.", "");
        address = address.replaceAll("http://", "");
        address = address.replaceAll("https://", "");
        address = address.replaceAll(".com", "");
        address = address.replaceAll(".net", "");
        address = address.replaceAll(".org", "");

        return chek(address);
    }

    private static boolean chek(String body){
        char[] chars = body.trim().toCharArray();
        for (char c : chars) {
            if (!Character.isLetterOrDigit(c)){
                return false;
            }
        }
        return true;
    }
}
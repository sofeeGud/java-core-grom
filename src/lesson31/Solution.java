package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public Map countSymbols(String text) {
        Map<Character, Integer> countSymb = new HashMap<>();
        if (text.isEmpty() && text.length() == 0)
            return null;

        char[] symbols = text.toCharArray();

        for (Character s : symbols) {
            if (Character.isLetter(s)) {
                if (!countSymb.containsKey(s))
                    countSymb.put(s, 1);
                else countSymb.put(s, countSymb.get(s) + 1);
            }
        }

        return countSymb;
    }


    public Map words(String text) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (text.isEmpty() && text.length() == 0)
            return null;

        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 1) {
                if (!wordsCount.containsKey(word))
                    wordsCount.put(word, 1);
                else wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }
        return wordsCount;

    }
}

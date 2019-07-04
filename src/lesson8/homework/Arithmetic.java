package lesson8.homework;

public class Arithmetic {
    int[] array;

    boolean check(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i : array) {
            if (min > i)
                min = i;
        }

        for (int i : array) {
            if (max < i)
                max = i;
        }
        System.out.println(min);
        System.out.println(max);
        int sum = max + min;
        if (sum > 100) return true ;
        else
            return false;
    }
}

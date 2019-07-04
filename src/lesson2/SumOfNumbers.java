package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {

        long sum = 0;
        for (long a = 0; a <= 10000000; a++) {
            sum += a;
        }

        System.out.println(sum);
    }
}

package lesson4;

public class Sums {
    public static void main(String[] args) {

        System.out.println(compareSums(1, 2, 1, 4));
    }
    public static long sum(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean compareSums(int a, int b, int c, int d) {

        if (sum(a, b) > sum(c, d))
            return true;
        else return false;
    }


}

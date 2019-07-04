package lesson4;

public class Div {
    public static void main(String[] args) {

        short a = 1;
        short b = 5;

        System.out.println(findDivCount(a,b,2));

    }

    public static int findDivCount(short a, short b, int n) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                sum++;

        }
        return sum;
    }
}

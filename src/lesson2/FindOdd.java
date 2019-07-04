package lesson2;

public class FindOdd {
    public static void main(String[] args) {
        int sum = 0;
        int result;
        for (int a = 0; a <= 1000; a++) {

            if (a % 2 != 0) {
                System.out.println("Found");
                sum += a;
            }

        }
        result = sum * 5;
        if (result > 5000)
            System.out.println("Bigger");
        else {
            System.out.println("Smaller or equal");
        }
    }
}

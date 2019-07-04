package lesson4;

public class Cont {
    public static void main(String[] args) {
        String one = "11111";
        String two = "222";
        String three = "33";

        System.out.println(concat(one,two, three));
    }

    public static String concat (String a, String b, String c) {
        String res = a + b + c;
        return res;
    }
}

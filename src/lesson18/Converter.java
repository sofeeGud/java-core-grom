package lesson18;

public class Converter {
    public static void main(String[] args) {
        System.out.println(stringToInt("11"));
        System.out.println(intToString(111321));

        System.out.println(stringToInt("1050a"));


    }

    public static int stringToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }

    public static String intToString(int input) {
        return String.valueOf(input);

    }
}

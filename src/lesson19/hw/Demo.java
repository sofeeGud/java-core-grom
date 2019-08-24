package lesson19.hw;

public class Demo {
    public static void main(String[] args) {

        try{
            File file_1 = new File(1, "asdgsdgdfgsfdgsdfgdf", "doc", 12);

            System.out.println(file_1.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}

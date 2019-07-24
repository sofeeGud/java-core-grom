package lesson15;

public class Demo {
    public static void main(String[] args) {
     File file1 = new File(111, "home/documents/test", "txt");
     File file2 = new File(111, "home/documents/image", "jpg");
     File file3 = new File(111, "home/documents/test", "txt");

     System.out.println(file1.equals(file2));
     System.out.println(file1.equals(file3));
    }
}

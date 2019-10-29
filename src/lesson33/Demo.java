package lesson33;

public class Demo {
    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.readFile("C:/Users/Lenovo T540p/Desktop/test.txt");
        readWriteFile.writeFile("C:/Users/Lenovo T540p/Desktop/test1.txt");
    }
}

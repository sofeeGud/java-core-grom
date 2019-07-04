package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
       int sum = 0;
       int celoe;
       int ostatok;
       for(int a = 1; a <= 1000; a++){
           sum += a;
       }
       celoe = sum/1234;
       ostatok = sum%1234;
       System.out.println(sum>ostatok);
    }
}

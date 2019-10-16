package lesson31;

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();


        String testSymbol1 = "qweqweeq";
        String testSymbol2 = "";
        String testSymbol3 = "qweqweeq  ";
        String testSymbol4 = "qw22eqweeq";
        String testSymbol5 = "  qweq//weeq";


        String testWord1 = "qqq eee qqq e qq e";
        String testWord2  = "4568  kuyutt 4568 kuy   ";
        String testWord3  = "";
        String testWord4  = "89 56 12 89 21";
        String testWord5  = "r r r r t t t t ";

        System.out.println(solution.countSymbols(testSymbol1));
        System.out.println(solution.countSymbols(testSymbol2));
        System.out.println(solution.countSymbols(testSymbol3));
        System.out.println(solution.countSymbols(testSymbol4));
        System.out.println(solution.countSymbols(testSymbol5));

        System.out.println("-------------------------------------------------");

        System.out.println(solution.words(testWord1));
        System.out.println(solution.words(testWord2));
        System.out.println(solution.words(testWord3));
        System.out.println(solution.words(testWord4));
        System.out.println(solution.words(testWord5));
    }
}

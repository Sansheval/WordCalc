import com.sun.jdi.Value;

import javax.management.StringValueExp;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите желаемую операцию");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(('"')+(Word.calc(input)+('"')));
    }
}
class Word {

    public static String calc(String input) {


        String[] stringsplit = input.split("\" ");
        String[] args = input.split(" [-+*/] ");
        String firstWord = args[0];
        String secondWord = args[1];
        String operation = input.substring(firstWord.length() + 1, firstWord.length() + 2);
        if (!firstWord.contains("\"")) {
            throw new RuntimeException("Первый аргумент должен быть словом");
        }
        firstWord = firstWord.replace("\"", "");
        boolean secondArgIsNumber = !secondWord.contains("\"");
        secondWord = secondWord.replace("\"","");
        if (firstWord.length() > 10) {
            throw new RuntimeException("Слово должно быть не длинее 10 символов");
        }
        if (secondWord.length() > 10) {
            throw new RuntimeException("Слово должно быть не длинее 10 символов");
        }

        if (stringsplit.length > 4)
        {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (secondArgIsNumber) {
            switch (operation) {
                case "/":
                    return delenieStroki(firstWord, Integer.valueOf(secondWord));
                case "*":
                    return stringMultiply(firstWord, Integer.valueOf(secondWord));
                default:
                    throw new RuntimeException("формат математической операции не удовлетворяет заданию");
            }
        }else {
            switch (operation){
                case "-":
                    if (secondArgIsNumber) {
                        throw new RuntimeException("Нельзя вычитать из строки число");
                    }
                    return strokiMinus(firstWord,secondWord);
                case "+":
                    if (secondArgIsNumber) {
                        throw new RuntimeException("Нельзя складывать строки и числа");
                    }
                    return strokiPlus(firstWord,secondWord);
                default:
                    throw new RuntimeException("формат математической операции не удовлетворяет заданию");
            }
        }
    }

        public static String delenieStroki (String a, int b) {

        return a.substring(0,(a.length()/b));
    }
    public static String strokiMinus (String a, String b) {
        StringBuilder sb = new StringBuilder();
        String c = a.replace(b,"");
        return c;
    }
    public static String stringMultiply(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static String strokiPlus (String a,String b){
        return a + b;
    }
}
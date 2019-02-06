/**
 * Created by ulya on 06.02.19.
 */
import java.util.HashSet;

/**
 * Created by yuliav on 04/02/2019.
 */
public class NumeralSystemConverter {
    public static void main(String[] args) {
        final Integer[] values = new Integer[] { 32767, 514, 3456, 109485 };
        for(int value: values){
            printInThreeSystems(value);
            System.out.println("\n\n\n");
        }
    }
    public static void printInThreeSystems(int number){
        System.out.println(String.format("Число %2d в деситичной системе счисления:", number));
        System.out.printf("%d", number);
        System.out.println("\n");
        System.out.println(String.format("Число %2d в восмиричной системе счисления:", number));
        System.out.printf("%o", number);
        System.out.println("\n");
        System.out.println(String.format("Число %2d в двоичной системе счисления:", number));
        System.out.printf(Long.toString(number,2));
        System.out.println("\n");
        System.out.println(String.format("Число %2d в шестнадцетиричной системе счисления:", number));
        System.out.printf("%x", number);
        System.out.println("\n");
    }
}
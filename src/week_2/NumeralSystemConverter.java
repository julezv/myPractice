package week_2;

/**
 * /**
 * Created by yuliav on 04/02/2019.
 */
public class NumeralSystemConverter {
    public static void main(String[] args) {
        int[] values = new int[]{32767, 514, 3456, 109485};
        for (int value : values) {
            printInThreeSystems(value);
            System.out.println("\n\n\n");
        }
    }

    private static void printInThreeSystems(int number) {
        System.out.printf("Число %2d в десятичой системе счисления:  %d \n", number, number);
        System.out.printf("Число %2d в двоичной системе счисления: %s \n", number, Integer.toBinaryString(number));
        System.out.printf("Число %2d в восьмеричной системе счисления: %o \n", number, number);
        System.out.printf("Число %2d в шестнадцатеричной системе счисления: %x \n", number, number);
    }
}
package week_2;

/**
 * Created by yuliav on 06/02/2019.
 */
//Класс - объединение полей и методов для работы с ними
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwoIntegerClass(32));

        System.out.println(isPowerOfTwo(31));
    }

    public static void convertToBinary(int no) { //сигнатура метода
        int container[] = new int[100];
        int i = 0;
        while (no > 0){
            container[i] = no%2;
            i++;
            no = no/2;
        }
        for (int j = i -1 ; j >= 0 ; j--) {
        }
    }

    public static boolean isPowerOfTwo(int value) {
        if (value == 0) {
            return false;
        }
        int absValue =  Math.abs(value);
        /*int previousValue = absValue-1;
        convertToBinary(absValue);
        convertToBinary(previousValue);
        return ((absValue & previousValue) == 0);*/

        return (absValue & absValue - 1) == 0;
    }

    public static boolean isPowerOfTwoIntegerClass(int value) {
        int absValue =  Math.abs(value);
        return Integer.bitCount(absValue) == 1;
    }


}

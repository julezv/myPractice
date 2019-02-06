/**
 * Created by yuliav on 05/02/2019.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Написать программу, которая выводит для целого (в том числе, возможно,
 отрицательного) числа его представление в прямом, обратном,
 дополнительном и “Юлином” кодах. Вот тут попробуйте самостоятельно
 реализовать перевод в двоичную систему счисления с запоминанием всех
 остатков.
 Kакие методы выделить ?
 */

public class BinaryScaleConverter {
    public static void main(String[] args) {
        System.out.println(convertToJoinedString(SimpleConverter(-0)));
    }

    public static ArrayList dealWithNegativeNumbers(int a){
        int b = Math.abs(a);
        ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 1) );

        if (Math.abs(a) > 128) {
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
        }

        while (!(b < 2)) {
            for (int i = 0; i < 7; i++) {
                ar.set(i, b % 2);
                b = b / 2;
            }
        }
        Collections.reverse(ar);
        return ar;
    }

    public static ArrayList dealWithPositiveNumbers(int a){
        ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0) );
        if(a > 127){
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
        }
        while (!(a < 2)) {
            for (int i = 0; i < 7; i++) {
                ar.set(i, a % 2);

                a = a / 2;
            }
        }
        Collections.reverse(ar);
        return ar;
    }


    public static ArrayList SimpleConverter(int a){
        ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0) );
        ArrayList<Integer> ar2 = new ArrayList<Integer>(Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 1) );

        if (a>0){
            return dealWithPositiveNumbers(a);
        }
        if (a<0) {
            return dealWithNegativeNumbers(a);

        }
        if (a == 0) {
            return ar;

        }
        return ar2;
    }

    public static String convertToJoinedString(ArrayList<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number);
        }
        return builder.toString();
    }


    public static Long convertToLong(ArrayList a){
        String result = convertToJoinedString(a);
        Long resultInt = Long.parseLong(result);
        return resultInt;
    }
}

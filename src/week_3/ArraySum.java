package week_3;

import java.util.Arrays;

/**
 * Написать программу, которая вычисляет поэлементную сумму двух массивов.
 * То есть если заданы два массива, возможно разной длины, то программа формирует
 * по ним третий массив, элементами которого являются поэлементные суммы для тех индексов,
 * для которых есть элементы в обоих заданных массивах, и элементы более длинного массива для остальных индексов.
 */
public class ArraySum{
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6};
        String s1 = "";
        for (int i = 0; i < a.length; i++) {
            s1 += a[i]; //1 => "1" => s1 =  "" + "1" = "1"
            //2 => "2" => s1 = "1" + "2" = "12"
            //3 => "3" => s1 = "12" + "3" = "123"
            // ... s2 = "123456"
        }
        System.out.println(s1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        System.out.println(sb); //System.out.println(sb.toString());

        System.out.println(a); // System.out.println(a.toString())

        System.out.println(Arrays.toString(a));

        System.out.println(convertToJoinedString(a));


        System.out.println(convertToJoinedString(sum(new int []{-3, 40}, new int []{-3,-5,-4, 6, 5, 3})));
    }
    public static int[] sum(int[] a, int[] b) {
        if (a.length < b.length) {
            int[] c = a;
            a = b;
            b = c;
        } // a.length >= b.length

        int[] sum = new int[a.length];
        for (int i = 0; i < b.length; ++i) {
            sum[i] =  a[i] + b[i];
        }
        for (int i = b.length; i < a.length; i++){
            sum[i] = a[i];
        }

        return sum;
    }

    private static String convertToJoinedString(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; ++i) {
            builder.append(numbers[i] + " ");
        }
        return builder.toString(); //{1, 2, 3, 4, 5} => "1 2 3 4 5"
    }
}

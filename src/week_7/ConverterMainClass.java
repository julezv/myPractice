package week_7;

import java.util.Arrays;

/**
 * Created by yuliav on 14/03/2019.
 */
public class ConverterMainClass {
    public static void main(String[] args) {
        System.out.println(binArrayToString(toBinary(-3, 24)));

    }

    //works for bases <= 31
    public static int[] toBinary(int a, int base) {
        // char code
        //int base = 8;

        //calculating a mod 2^base
        a = a % (1 << base);//(int)(Math.pow(2, base));
        if (a < 0) {
            a = a + (1 << base);
        }
        int[] res = new int[base];
        for (int i = 0; i < base; ++i) {
            res[i] = a % 2;
            a = a / 2;
            if (a == 0)
                break;
        }

        return res;
    }

    public static String binArrayToString(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[a.length - i - 1] + " ");
            if (i % 8 == 7) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}

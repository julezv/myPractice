package week_4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yuliav on 20/02/2019.
 */

public class YulinCode {
    private static void reverse(int[] data) {
        int left = 0;
        for (int right = data.length - 1; left < right; --right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            ++left;
        }
    }

    private static int[] convertToBinary(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 256) {
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 256");
        } else {
            while (a >= 2) {
                for (int i = 0; i < 7; ++i) {
                    ar[i] = a % 2;
                    a /= 2;
                }
            }
            reverse(ar);
            return ar;
        }
    }

    private static int[] dealWithPositiveNumbersYulinCode(int a) {
        if (a > 128) {
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
        } else {
            HashMap<Integer, Integer> positiveMap = new HashMap<>();
            int j = 2;
            for (int i = 1; i <= 128; ++i) {
                positiveMap.put(i, j);
                j += 2;
            }
            return (convertToBinary(positiveMap.get(a)));
        }
    }

    public static int[] dealWithNegativeNumbersYulinCode(int a) {
        if (Math.abs(a) > 128) {
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
        } else {
            HashMap<Integer, Integer> negativeMap = new HashMap<>();
            int j = 1;
            for (int i = -1; i >= -128; --i) {
                negativeMap.put(i, j);
                j += 2;
            }
            return (convertToBinary(negativeMap.get(a)));
        }
    }

    public static String yuliaComplementRepresentation(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 0) {
            return Arrays.toString(dealWithPositiveNumbersYulinCode(a));
        }
        if (a < 0) {
            return Arrays.toString(dealWithNegativeNumbersYulinCode(a));
        }
        return Arrays.toString(ar);
    }
}

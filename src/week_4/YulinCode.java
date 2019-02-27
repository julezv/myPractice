package week_4;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by yuliav on 20/02/2019.
 */

public class YulinCode {
    public static void main(String[] args) {
        System.out.println((yuliaComplementRepresentation(0)));
    }

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
        if (a == 0) {
            return ar;
        }
        if (a > 255) {
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


    public static String yuliaComplementRepresentation(int a) {
        if (a > 0 && a > 127) {
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
        }
        if (a < 0 && Math.abs(a) > 128) {
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
        }
        int[] arr = new int[256];
        int j = -1;
        int k = 1;
        for (int i = 0; i <= 255; ++i) {
            if (i == 0) {
                arr[i] = 0;
                continue;
            }
            if (i % 2 == 0) {
                arr[i] = k;
                k++;
            }
            if (i % 2 != 0) {
                arr[i] = j;
                j--;
            }
        }
        System.out.println(findIndex(arr, a));
        return Arrays.toString(convertToBinary(findIndex(arr, a)));
    }


    public static int findIndex(int[] a, int target) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList())
                .indexOf(target);
    }

}

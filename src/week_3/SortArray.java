package week_3;

import java.util.Arrays;

/**
 * Created by yuliav on 13/02/2019.
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел
 * в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
 * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
 * он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
 * Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
 **/
public class SortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedJoin(new int[]{}, new int[]{5})));
    }

    private static int[] sortedJoin(int[] a, int[] b) {
        if (a.length < b.length) {
            int[] c = a; // c < b
            a = b; // c < a,b
            b = c; // b equal to smallest
        } // a.length >= b.length

        int[] sortedResult = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k;
        for (k = 0; i < a.length && j < b.length && k < sortedResult.length; ++k) {
            /*if (i == a.length) {
                c[k] = b[j];
                j++;
                continue;
            }
            if (j == b.length) {
                c[k] = a[i];
                i++;
                continue;
            }*/
            if (a[i] < b[j]) {
                sortedResult[k] = a[i++];
            } else if (a[i] >= b[j]) {
                sortedResult[k] = b[j++];
            }
        }
        if (i <= j) {
            System.arraycopy(a, i, sortedResult, k, a.length - i);
        } else {
            System.arraycopy(b, j, sortedResult, k, b.length - j);
        }
        return sortedResult;
    }

    private static int[] sortArrayWithWhile(int[] a, int[] b) {
        int c[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length && k < c.length) {
            c[k++] = a[i++];
        }
        while (j < b.length && k < c.length) {
            c[k++] = b[j++];
        }
        return c;
    }
}

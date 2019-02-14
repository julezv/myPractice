package week_3;

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
        System.out.println(convertToJoinedString(sortArrayWithWhile(new int[]{1, 2}, new int[]{1})));
    }

    private static int[] sortArray(int[] a, int[] b) {
        int c[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        for (int x = 0; x < c.length; x++) {
            if (i == a.length) {
                c[x] = b[j];
                j++;
                continue;
            }
            if (j == b.length) {
                c[x] = a[i];
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                c[x] = a[i];
                i++;
            } else {
                c[x] = b[j];
                j++;
            }
        }
        return c;
    }

    private static int[] sortArrayWithWhile(int[] a, int[] b) {
        int c[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int x = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[x] = a[i];
                i++;
                x++;
            } else {
                c[x] = b[j];
                j++;
                x++;
            }
        }
        while (i < a.length && x < c.length) {
            c[x] = a[i];
            i++;
            x++;
        }
        while (j < b.length && x < c.length) {
            c[x] = b[j];
            j++;
            x++;
        }
        return c;
    }

    private static String convertToJoinedString(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        int[] var2 = numbers;
        int var3 = numbers.length;
        for (int var4 = 0; var4 < var3; ++var4) {
            int number = var2[var4];
            builder.append(number + " ");
        }
        return builder.toString();
    }
}

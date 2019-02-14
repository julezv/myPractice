package week_3;

/**
 * Написать программу, которая вычисляет поэлементную сумму двух массивов.
 * То есть если заданы два массива, возможно разной длины, то программа формирует
 * по ним третий массив, элементами которого являются поэлементные суммы для тех индексов,
 * для которых есть элементы в обоих заданных массивах, и элементы более длинного массива для остальных индексов.
 */
public class ArraySum {
    public static void main(String[] args) {
        System.out.println(convertToJoinedString(sum(new int []{-3,-5,-4, 6, 5, 3}, new int []{-3, 40})));
    }
    public static int[] sum(int [] a, int [] b) {
        int i;
        int j;
        int container[] = new int[a.length];
        if (a.length >= b.length) {
            container = new int[a.length];
            for (i = 0; i < b.length; ++i) {
                container[i] =  a[i] + b[i];
            }
            for(j = i; j < a.length; j++ ){
                container[j] = a[j];
            }
        }
        if (b.length > a.length) {
            container = new int[b.length];
            for (i = 0; i < a.length; ++i) {
                container[i] =  a[i] + b[i];
            }
            for(j = i; j < b.length; j++ ){
                container[j] = b[j];
            }
        }
        return container;
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

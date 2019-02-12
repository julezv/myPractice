package week_3;

/**
 * Created by ulya on 12.02.19.
 */
public class ConvertToBinary_upd {
    public static void main(String[] args) {
        System.out.println(convertToJoinedString(convertToBinary(2)));
    }

    static int[] convertToBinary(int no) {
        if (no == 0) {
            return new int[]{0};
        }
        int container[] = new int[100];
        int i = 0;
        while (no > 0) {
            container[i] = no % 2;
            i++;
            no = no / 2;
        }
        int[] anotherArray = new int[i];
        int x = 0;
        for (int j = i - 1; j >= 0; j--) {
            anotherArray[x] = container[j];
            x++;
        }
        return anotherArray;
    }

    private static String convertToJoinedString(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        int[] var2 = numbers;
        int var3 = numbers.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            int number = var2[var4];
            builder.append(number);
        }
        return builder.toString();
    }
}

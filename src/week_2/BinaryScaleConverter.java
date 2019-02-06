package week_2; /**
 * Created by yuliav on 05/02/2019.
 */

/**
 * Написать программу, которая выводит для целого (в том числе, возможно,
 * отрицательного) числа его представление в прямом, обратном,
 * дополнительном и “Юлином” кодах. Вот тут попробуйте самостоятельно
 * реализовать перевод в двоичную систему счисления с запоминанием всех
 * остатков.
 * Kакие методы выделить ?
 */

public class BinaryScaleConverter {
    public static SignedMagnitudeRepresentation signedMagnitude = new SignedMagnitudeRepresentation();
    public static OnesComplementRepresentation onesComplement = new OnesComplementRepresentation();

    public static void main(String[] args) {
        System.out.println(convertToJoinedString(signedMagnitude.simpleConverter(-3)));
        System.out.println(convertToJoinedString(onesComplement.simpleConverter(-128)));
    }

    public static class SignedMagnitudeRepresentation {
        private int[] dealWithNegativeNumbers(int a) {
            int b = Math.abs(a);
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 1};


            if (Math.abs(a) > 128) {
                throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
            }

            while (!(b < 2)) {
                for (int i = 0; i < 7; i++) {
                    ar[i] = b % 2;
                    b = b / 2;
                }
            }
            reverse(ar);
            return ar;
        }

        private int[] dealWithPositiveNumbers(int a) {
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            if (a > 127) {
                throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
            }
            while (!(a < 2)) {
                for (int i = 0; i < 7; i++) {
                    ar[i] = a % 2;
                    a = a / 2;
                }
            }
            reverse(ar);
            return ar;
        }

        private int[] simpleConverter(int a) {
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            int[] ar2 = new int[]{0, 0, 0, 0, 0, 0, 0, 1};

            if (a > 0) {
                return dealWithPositiveNumbers(a);
            }
            if (a < 0) {
                return dealWithNegativeNumbers(a);

            }
            if (a == 0) {
                return ar;

            }
            return ar2;
        }
    }

    public static class OnesComplementRepresentation {
        private int[] dealWithNegativeNumbers(int a) {
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            int[] ar2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            int b = Math.abs(a);
            if (b > 128) {
                throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
            }
            while (!(b < 2)) {
                for (int i = 0; i < 7; i++) {
                    ar[i] = b % 2;
                    b = b / 2;
                }
            }
            reverse(ar);
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] == 0) {
                    ar2[i] = 1;
                } else {
                    ar2[i] = 0;
                }
            }
            return ar2;
        }

        private int[] dealWithPositiveNumbers(int a) {
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            if (a > 127) {
                throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
            }
            while (!(a < 2)) {
                for (int i = 0; i < 7; i++) {
                    ar[i] = a % 2;
                    a = a / 2;
                }
            }
            reverse(ar);
            return ar;
        }

        private int[] simpleConverter(int a) {
            int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            int[] ar2 = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
            if (a > 0) {
                return dealWithPositiveNumbers(a);
            }
            if (a < 0) {
                return dealWithNegativeNumbers(a);
            }
            if (a == 0) {
                return ar;
            }
            return ar2;
        }
    }


    private static String convertToJoinedString(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number);
        }
        return builder.toString();
    }

    private static void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
//    public static Long convertToLong(int[] a) {
//        String result = convertToJoinedString(a);
//        Long resultInt = Long.parseLong(result);
//        return resultInt;
//    }
}



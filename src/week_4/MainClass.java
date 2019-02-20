package week_4;

import java.util.Arrays;

/**
 * Created by ulya on 12.02.19.
 */
public class MainClass {
    private static void reverse(int[] data) {
        int left = 0;
        for (int right = data.length - 1; left < right; --right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            ++left;
        }
    }

    private static int[] dealWithNegativeNumbersSignedMagnitude(int a) {
        if (a == -1) {
            return new int[]{1, 0, 0, 0, 0, 0, 0, 1};
        }
        int b = Math.abs(a);
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
        if (Math.abs(a) > 127) {
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 127");
        } else {
            while (b >= 2) {
                for (int i = 0; i < 7; ++i) {
                    ar[i] = b % 2;
                    b /= 2;
                }
            }
            reverse(ar);
            return ar;
        }
    }

    private static int[] dealWithNegativeNumbersOnesComplement(int a) {
        if (a == -1) {
            return new int[]{1, 1, 1, 1, 1, 1, 1, 0};
        }
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] ar2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int b = Math.abs(a);
        if (b > 127) {
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 127");
        } else {
            int i;
            while (b >= 2) {
                for (i = 0; i < 7; ++i) {
                    ar[i] = b % 2;
                    b /= 2;
                }
            }
            reverse(ar);
            for (i = 0; i < ar.length; ++i) {
                if (ar[i] == 0) {
                    ar2[i] = 1;
                } else {
                    ar2[i] = 0;
                }
            }

            return ar2;
        }
    }

    private static int[] dealWithPositiveNumbers(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 127) {
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
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

    public static String signedMagnitudeRepresentation(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 0) {
            return Arrays.toString(dealWithPositiveNumbers(a));
        }
        if (a < 0) {
            return Arrays.toString(dealWithNegativeNumbersSignedMagnitude(a));
        }

        return Arrays.toString(ar);

    }
    public static String twosComplementRepresentation(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 0) {
            return Arrays.toString(dealWithPositiveNumbers(a));
        }
        if (a < 0) {
            return Arrays.toString(dealWithNegativeNumbersOnesComplement(a+1));
        }

        return Arrays.toString(ar);

    }

    public static String onesComplementRepresentation(int a) {
        int[] ar = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (a > 0) {
            return Arrays.toString(dealWithPositiveNumbers(a));
        }
        if (a < 0) {
            return Arrays.toString(dealWithNegativeNumbersOnesComplement(a));
        }
        return Arrays.toString(ar);
    }
}


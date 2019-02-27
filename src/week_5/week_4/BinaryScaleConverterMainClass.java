package week_5.week_4;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by ulya on 26.02.19.
 */
public class BinaryScaleConverterMainClass {

    public static void main(String[] args) {
        System.out.println(signedMagnitudeRepresentation(-2));
        System.out.println(onesComplementRepresentation(-2));
        System.out.println(twosComplementRepresentation(-2));
        System.out.println(yuliaComplementRepresentation(-2));
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
            return Arrays.toString(dealWithNegativeNumbersOnesComplement(a + 1));
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
        //System.out.println(findIndex(arr, a));
        return Arrays.toString(convertToBinary(findIndex(arr, a)));
    }


    public static int findIndex(int[] a, int target) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList())
                .indexOf(target);
    }
}


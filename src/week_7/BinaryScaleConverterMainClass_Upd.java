package week_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by ulya on 13.03.19.
 */
public class BinaryScaleConverterMainClass_Upd {
    public static void main(String[] args) {

        //usage: n -s -t n -y - o

        ArrayList<String> myList = new ArrayList<>();
        for (int i = 0; i < args.length; ++i) {
            if (isNumeric(args[i])) {
                if (i == 0) {
                    myList.add(args[i]);
                    continue;
                } else {
                    System.out.println(myList);
                    processBlock(myList);
                    myList = new ArrayList<>();
                }
            }
            myList.add(args[i]);
        }
        System.out.println(myList);
        processBlock(myList);

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void processBlock(ArrayList<String> blockArgs) {
        Integer a = 0;

        for (int i = 0; i < blockArgs.size(); ++i) {
            if (i == 0) {
                if (isNumeric(blockArgs.get(i))) {
                    a = Integer.parseInt(blockArgs.get(i));

                } else {
                    System.out.println("first arg should be an int, otherwise all conversions are performed for 0");
                    a = 0;
                }
            }
            if (blockArgs.get(i).equals("-s")) {
                System.out.printf("%d in signed magnitude representation:  ", a);
                try {
                    System.out.println(signedMagnitudeRepresentation(a));

                } catch (ArithmeticException e) {
                    System.out.println("Value out of bounds");
                }

            } else if (blockArgs.get(i).equals("-o")) {
                System.out.printf("%d in one's complement representation:  ", a);
                try {
                    System.out.println(onesComplementRepresentation(a));

                } catch (ArithmeticException e) {
                    System.out.println("Value out of bounds");
                }
            } else if (blockArgs.get(i).equals("-t")) {
                System.out.printf("%d in two's complement representation:  ", a);
                try {
                    System.out.println(twosComplementRepresentation(a));

                } catch (ArithmeticException e) {
                    System.out.println("Value out of bounds");
                }
            } else if (blockArgs.get(i).equals("-y")) {
                System.out.printf("%d in yulia's complement representation:  ", a);

                try {
                    System.out.println(yuliaComplementRepresentation(a));

                } catch (ArithmeticException e) {
                    System.out.println("Value out of bounds");
                }
            } else if (!isNumeric(blockArgs.get(i))) {
                System.out.println("unknown parameter: " + blockArgs.get(i));
            }
        }
        if (blockArgs.size() - 1 == 0) {
            System.out.printf("No format, converting %d to two's complement: ", a);
            try {
                System.out.println(twosComplementRepresentation(a));

            } catch (ArithmeticException e) {
                System.out.println("Value out of bounds");
            }
        }
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
        if (a > 127) { //a > 127
            throw new ArithmeticException("Absolute value of positive input cannot be larger than 127");
        }
        if (a < -128) { //a < -128
            throw new ArithmeticException("Absolute value of negative input cannot be larger than 128");
        }
        if (a < 0) {
            return Arrays.toString(convertToBinary((a * (-1) * 2) - 1));
        } else {
            return Arrays.toString(convertToBinary(a * 2));
        }
    }
    //66: odd/even? => even => 66 / 2 = 33 => 33
    //51: odd/even? => odd => (51 + 1) / 2 = 26 => -26

    //System.out.println(findIndex(arr, a));

    // 123, 432, 563, 982, 728, 123, 555
    // O(n)
    //   563
    //  /    \
    //432     728
    //      / \      \
    //    123 555    982
    // O(log_2 n) - MAP
    // O(1) - Hash-Map


    public static int findIndex(int[] a, int target) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList())
                .indexOf(target);
    }
}


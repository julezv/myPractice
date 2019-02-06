package week_2;

/**
 * Created by yuliav on 06/02/2019.
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }

    public static boolean isPowerOfTwo(int value) {
        if (value == 0) {
            return false;
        }
        if (value == 1) {
            return true;
        }
        int absValue =  Math.abs(value);
        String binaryRepresentation = Integer.toBinaryString(absValue-1);
        return !binaryRepresentation.contains("0");
    }
}

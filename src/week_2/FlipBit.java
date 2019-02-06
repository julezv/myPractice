package week_2;

/**
 * Created by yuliav on 06/02/2019.
 */
public class FlipBit {
    public static void main(String[] args) {
        System.out.println(flipBit(35, 2));
    }
    public static int flipBit(int value, int bitIndex) {
        return value^(1<<bitIndex-1);
    }

}

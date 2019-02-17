package week_3;

/**
 * Created by ulya on 12.02.19.
 */
public class MaxFinder {
    public static void main(String[] args) {
        System.out.println(findMax(-3, -5, -4));
    }
    public static int findMax(int... a) {
        int max = a[0];
        for(int i = 0; i < a.length; ++i){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
}

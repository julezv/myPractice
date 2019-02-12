package week_3;
import java.util.Scanner;


/**
 * Created by ulya on 12.02.19.
 * Написать программу, которая запрашивает у пользователя
 * несколько положительных чисел и затем выводит их на экран в обратном порядке.
 * В начале программы пользователь вводит числа до тех пор, пока не введет отрицательное число или 0.
 */
public class InputReverser {
    public static void main(String[] args) {
        int n;
        StringBuilder sb = new StringBuilder();

        Scanner input = new Scanner(System.in);
        System.out.println("Input an integer");
        while ((n = input.nextInt())  >0) {
            sb.append(n + "\n");
            System.out.println("You entered " + n);
            System.out.println("Input an integer");
        }
        System.out.println(sb.reverse());
    }
}

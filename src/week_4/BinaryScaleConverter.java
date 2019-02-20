package week_4; /**
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

    public static String getOnesComplementRepresentation(int a) {
        return MainClass.onesComplementRepresentation(a);
    }
    public static String getSignedMagnitudeRepresentation(int a) {
        return MainClass.signedMagnitudeRepresentation(a);
    }
    public static String getTwosComplementRepresentation(int a) {
        return MainClass.twosComplementRepresentation(a);
    }
    public static String getYuliaRepresentation(int a) {
        return YulinCode.yuliaComplementRepresentation(a);
    }

    public static void main(String[] args) {
        System.out.println(getSignedMagnitudeRepresentation(-2));
        System.out.println(getOnesComplementRepresentation(-2));
        System.out.println(getTwosComplementRepresentation(-2));
        System.out.println(getYuliaRepresentation(-2));
    }
}



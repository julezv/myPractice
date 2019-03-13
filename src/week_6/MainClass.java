package week_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by yuliav on 06/03/2019.
 */
public class MainClass {
    public static void main(String[] args) {
        Test[] a = new Test[]{new Test(1), new Test(2), new Test(3)};
        /*Test[] newA = new Test[a.length + 1]; //add element to array
        for (int i = 0; i < a.length; i++) {
            newA[i] = a[i];
        }
        newA[a.length] = new Test(555);
        a = newA;*/

        List<Test> l = Arrays.asList(a);
        System.out.println("l: " + l);
        Test t = l.get(1);
        t.setA(444);
        System.out.println("l: " + l);
        System.out.println(Arrays.toString(a));

        System.out.println(l.get(0) == a[0]);

        List<Test> newL = new ArrayList<Test>(Arrays.asList(a));
        newL.add(new Test(777));
        t = newL.get(1);
        t.setA(9999);
        System.out.println("newL: " + newL);
        System.out.println("a: " + Arrays.toString(a));
        System.out.println(newL.get(0) == a[0]); //проверяем, что список и массив состоят физически из одних и тех же экземпляров класса Test
        newL.add(2, new Test(101010));
        newL.remove(0);
        System.out.println("newL: " + newL);
        System.out.println("a: " + Arrays.toString(a));


        int x = 7;
        int y = 7;
        System.out.println("x == y: " + (x == y));

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println(s1 + " == " + s2 + ": " + (s1 == s2));
        System.out.println(s1 + " == " + s3 + ": " + (s1 == s3));
        System.out.println(s1 + " equals " + s2 + ": " + (s1.equals(s2)));
        System.out.println(s1 + " equals " + s3 + ": " + (s1.equals(s3)));

        Test t1 = new Test(1);
        Test t2 = new Test(1);
        System.out.println(t1 + " == " + t2 + ": " + (t1 == t2));
        System.out.println(t1 + " equals " + t2 + ": " + (t1.equals(t2)));

        String t3 = "1";
        System.out.println(t1 + " equals " + t3 + ": " + (t1.equals(t3)));


    }
}

class Test {
    int a;
    Test() {
        a = 0;
    }
    Test(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Test{" +

                "a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Test otherTest = (Test) other;

        return this.a == otherTest.a;
    }
}
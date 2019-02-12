package week_2;

/**
 * Created by yuliav on 07/02/2019.
 */
public class Point {
    private int x;
    private int y;
    private static int count = 0; //поле count будет общим для всех экземпляров класса Point

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) { //x, y  - это формальные параметры
        this.x = x;
        this.y = y;
        Point.count++;
    }

    //Если определяем конструктор с параметрами, конструктора по умолчанию больше нет, поэтому надо определить руками конструктор без параметров
    public Point() {
        x = 0;
        y = 0;
        Point.count++;
    }

    public static int getCount() {
        return Point.count;
    }
}

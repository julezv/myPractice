package week_2;

/**
 * Created by yuliav on 07/02/2019.
 */
public class MainClass {
    public static void main(String[] args) {
        //Создадим экземпляр класса Point = объявить и инициализировать переменную типа Point
        Point point = new Point(2, 3); // 2,3 - фактические парметры


        //объявление
        int a;
        Point p1;

        //инициализация
        a = 5;
        p1 = new Point(); //вызов конструктора класса Point без параметров (пока мы не написали своего конструктора, это конструктор по умолчанию)

        p1.setX(4); //p1.x = 4
        p1.setY(5);//p1.y = 5;

        Point p2 = new Point();

        System.out.println("we have " + Point.getCount() + " points");

        int x;
        int y;


    }
}

//MainClass.main()
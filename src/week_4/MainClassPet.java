package week_4;

/**
 * Created by yuliav on 20/02/2019.
 */
public class MainClassPet {
    public static void main(String[] args) {
        Cat cat = new Cat("Kesha", 3);
        System.out.println(cat.talk());
        System.out.println(cat.getName());

        Dog dog = new Dog("Jinny", 12);
        System.out.println(dog.talk());
        System.out.println(dog.getName());
    }
}

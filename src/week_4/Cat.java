package week_4;

/**
 * Created by yuliav on 20/02/2019.
 */

public class Cat extends Pet {
    @Override
    public String talk(){
        return ("Meow meow");
    }

    Cat(String name, int age) {
        super(name, age);
    }
}

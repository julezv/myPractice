package week_4;

/**
 * Created by yuliav on 20/02/2019.
 */
public class Dog extends Pet{
    @Override
    public String talk(){
        return ("Bark bark");
    }

    Dog(String name, int age) {
        super(name, age);
    }
}

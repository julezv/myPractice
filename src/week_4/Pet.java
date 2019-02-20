package week_4;

/**
 * Created by yuliav on 20/02/2019.
 */
public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
        name = "unnamed";
        age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name =  name;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age =  age;
    }

    public String talk(){
        return ("Hello, I am a pet");
    }

}
package main.java.com.HeadFirst.chapter4.Dog;

public class Dog {
    int size;
    String name;

    void bark() {
        if (size > 60) {
            System.out.println("Гав Гав!");
        } else if (size > 14) {
            System.out.println("Вуф Вуф!");
        } else {
            System.out.println("Тяф Тяф!");
        }
    }
}

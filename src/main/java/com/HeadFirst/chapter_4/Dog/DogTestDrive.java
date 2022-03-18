package main.java.com.HeadFirst.chapter_4.Dog;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog();
        Dog two = new Dog();
        Dog three = new Dog();
        one.size = 70;
        two.size = 8;
        three.size = 35;
        one.bark();
        two.bark();
        three.bark();
    }
}

package main.java.com.HeadFirst.chapter_9.Duck;

public class Duck {
    int pounds = 6;
    float floatAbility = 2.1F;
    String name = "Универсальная";
    long[] feathers = {1, 2, 3, 4, 5, 6, 7};
    boolean canFly = true;
    int maxSpeed = 25;

    public Duck() {
        System.out.println("Duck 1");
    }

    public Duck(boolean canFly) {
        this.canFly = canFly;
        System.out.println("Duck 2");
    }

    public Duck(String name, long[] feathers) {
        this.name = name;
        this.feathers = feathers;
        System.out.println("Duck 3");
    }

    public Duck(int w, float f) {
        pounds = w;
        floatAbility = f;
        System.out.println("Duck 4");
    }

    public Duck(float density, int max) {
        floatAbility = density;
        maxSpeed = max;
        System.out.println("Duck 5");
    }
}

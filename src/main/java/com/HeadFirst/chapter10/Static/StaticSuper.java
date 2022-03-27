package main.java.com.HeadFirst.chapter10.Static;

public class StaticSuper {
    static {
        System.out.println("Родительский статический блок");
    }

    StaticSuper() {
        System.out.println("Родительский конструктор");
    }
}

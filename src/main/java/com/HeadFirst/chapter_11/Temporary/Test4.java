package main.java.com.HeadFirst.chapter_11.Temporary;

public class Test4 {
    public static void main(String[] args) {
        int[] array = {4, 8, 1};
        System.out.println("U nas est massiv");

        try {
            System.out.println(array[2]);
            System.out.println(array[5]);
            System.out.println("Vsem horoshego dnia");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bil poiman exception " + e);
        }
        finally {
            System.out.println("eto finally block");
        }
    }
}

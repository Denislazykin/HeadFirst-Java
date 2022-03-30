package main.java.com.HeadFirst.chapter_12.SimpleGui1;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создали фрейм
        JButton button = new JButton("Click me"); //создали кнопку и передали в конструктор текст
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершение работы при закрытии окна
        frame.getContentPane().add(button); //добавим кнопку на панель фрейма
        frame.setSize(500, 500); //установим размер
        frame.setVisible(true); //сделаем фрейм видимым
    }
}

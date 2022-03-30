package main.java.com.HeadFirst.chapter_12.SimpleGui1B;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Реализуем интерфейс ActionListener
 */
public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Нажми, что бы война закончилась");
        /*
         * Регистрируем кнопку(сообщаем ей
         * что мы хотим отслеживать ее события)
         */
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    /**
     * Определяем метод обработки событий
     * (реализуем метод из интерфейса)
     * @param event принимает событие
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        button.setText("А хуй тебе");
    }
}

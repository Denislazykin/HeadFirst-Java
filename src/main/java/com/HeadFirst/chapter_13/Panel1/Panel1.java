package main.java.com.HeadFirst.chapter_13.Panel1;

import javax.swing.*;
import java.awt.*;

public class Panel1 {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        /*
         * Сделаем панель серой,
         * что бы различать ее на фоне фрейма
         */
        panel.setBackground(Color.DARK_GRAY);
        /*
         * Изменяем диспечер компоновки на новый экземпляр BoxLayout
         */
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        /*
         * Создаем кнопки
         */
        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");
        /*
         * Добавляем кнопки на панель
         */
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        /*
         * Добавим панель внутрь фрейма
         * диспечер компоновки панели(Flow) контролирует кнопку,
         * диспечер компоновки фрейма(Boarder) управляет панелью
         */
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

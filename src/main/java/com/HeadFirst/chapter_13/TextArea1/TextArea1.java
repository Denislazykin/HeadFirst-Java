package main.java.com.HeadFirst.chapter_13.TextArea1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class TextArea1 implements ActionListener {
    JTextArea text;

    public static void main(String[] args) {
        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame(); // создали фрейм
        JPanel panel = new JPanel();    // создали панель
        JButton button = new JButton("Just Click It");  // создали кнопку
        button.addActionListener(this); // зарегистрировали слушателя для кнопки
        text = new JTextArea(10, 20);   // создали объект для текста
        text.setLineWrap(true); // разрешили перенос текста на новую строку
        JScrollPane scrolled = new JScrollPane(text); // создали прокручивающуюся панель и передали ей объект для ввода текста
        scrolled.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // разрешили прокручивающейся панели вертикальную прокрутку
        scrolled.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  // и запретили горизонтальную
        panel.add(scrolled); // в панель добавили прокручивающуся панель
        frame.getContentPane().add(BorderLayout.CENTER, panel); // в центр фрейма добавили панель
        frame.getContentPane().add(BorderLayout.SOUTH, button); // в нижнюю часть добавили кнопку
        frame.setSize(350, 300); // установили размеры
        frame.setVisible(true); // сделали фрейм видимым
    }

    @Override
    public void actionPerformed(ActionEvent e) { // при щелчке по кнопке формируем действие
        text.append("Button Clicked! \n");  // в текстовое поле добавляем текст
    }
}

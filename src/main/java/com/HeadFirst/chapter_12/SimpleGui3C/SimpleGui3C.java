package main.java.com.HeadFirst.chapter_12.SimpleGui3C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener {
    private JFrame frame;
    private JButton button;
    private static int count;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Нажми меня, я же кнопка");
        /*
         * добавляем слушателя (this) к кнопке
         */
        button.addActionListener(this);
        MyDrawPanel panel = new MyDrawPanel();
        /*
         * добавляем виджеты - кнопку и панель
         * в две области фрейма
         */
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    /*
     * при нажатии кнопки вызываем для фрейма метод repaint()
     */
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
        button.setText("Ещееее!!! " + (++count));
    }
}

class MyDrawPanel extends JPanel {
    /**
     * метод вызывается при каждом нажатии кнопки методом repain()
     * @param g принимает объект
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        /*
         * закрасим всю панель цветом по умолчанию
         */
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Image image = new ImageIcon("D:\\IMG_1364.jpg").getImage();
        g.drawImage(image, 10, 10, this);
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);
        GradientPaint gradient = new GradientPaint(5, 5, randomColor, 150, 150, endColor);
        g.setColor(randomColor);
        g2d.setPaint(gradient);
        g.fillOval(5, 5, 100, 100);
    }
}

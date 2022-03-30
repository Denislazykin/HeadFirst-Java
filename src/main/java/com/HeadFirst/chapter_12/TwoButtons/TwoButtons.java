package main.java.com.HeadFirst.chapter_12.TwoButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * В данный момент главный класс GUI
 * не реализует интерфейс ActionListener
 */
public class TwoButtons {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    private void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton labelButton = new JButton("Change label");//методу регистрации слушателя кнопки передается
        /*
         * Методу регистрации слушателя кнопки передается
         * экземпляр соответствующего класса слушателя
         */
        labelButton.addActionListener(new LabelListener());
        JButton colorButton = new JButton("Change circle");
        /*
         * Методу регистрации слушателя кнопки передается
         * экземпляр соответствующего класса слушателя
         */
        colorButton.addActionListener(new ColorListener());
        label = new JLabel("I'm label");
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    /**
     * Теперь у нас будет 2 ActionListener
     * в одном классе
     */
    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            /*
             * Внутренний класс знает о label
             */
            label.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            /*
             * Внутренний класс использует переменную экземпляра frame
             * без явной ссылки на объект внешнего класса
             */
            frame.repaint();
        }
    }
}

class MyDrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(5, 5, 100, 100);
    }
}

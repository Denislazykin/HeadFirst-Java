package main.java.com.HeadFirst.chapter_12.SimpleAnimation;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    /*
     * Создаем два поля в главном
     * классе GUI для координат х и у для круга
     */
    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            /*
             * Говорим панели, что бы она себя перерисовала
             * и мы смогли увидеть уркг на новом месте
             */
            panel.repaint();
            try {
                /*
                 * замедляем процесс
                 */
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }

    }

    class MyDrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, 100, 100);
        }
    }
}

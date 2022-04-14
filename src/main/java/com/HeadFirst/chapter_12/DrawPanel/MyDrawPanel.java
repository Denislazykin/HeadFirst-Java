package main.java.com.HeadFirst.chapter_12.DrawPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(20, 50, 100, 100);
    }
}

package main.java.com.HeadFirst.chapter_13.Button1;

import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click");
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(500, 100);
        frame.setVisible(true);
    }
}

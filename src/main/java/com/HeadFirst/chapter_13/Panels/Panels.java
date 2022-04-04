package main.java.com.HeadFirst.chapter_13.Panels;

import javax.swing.*;
import java.awt.*;

public class Panels {
    public static void main(String[] args) {
        Panels gui = new Panels();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        JButton button = new JButton("tesuiji");
        JButton buttonTwo = new JButton("watari");
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        panel.add(buttonTwo);
        frame.getContentPane().add(BorderLayout.NORTH, button);


        frame.setVisible(true);
    }
}

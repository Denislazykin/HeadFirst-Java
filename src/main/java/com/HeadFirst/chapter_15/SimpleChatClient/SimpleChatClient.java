package main.java.com.HeadFirst.chapter_15.SimpleChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void go() {
        JFrame frame = new JFrame("Очень простой чат клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        incoming = new JTextArea(15, 20);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendBtn = new JButton("Отправить");
        sendBtn.addActionListener(new SendButtonListener());
        panel.add(qScroller);
        panel.add(outgoing);
        panel.add(sendBtn);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        SetUpNetworking();
        /*
         * Запускаем новый поток, используя класс
         * в качестве Runnable (задачи)
         */
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    public class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("прочитать " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void SetUpNetworking() {
        try {
            socket = new Socket("192.168.1.134", 3333);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("устанавливаем соединение");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
                System.out.println("отправляем информацию");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }


    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }
}

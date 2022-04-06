package main.java.com.HeadFirst.chapter_15.DailyAdvice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = {"Ешьте меньшими порциями", "Купите облегающие джинсы. Нет, они не делают Вас полнее.",
            "Два слова: не годится",
            "Будьте честны хотя бы сегодня. Скажите своему начальнику все, что вы *на самом деле* о нем думаете",
            "Возможно, вам стоит подобрать другую прическу"};

    public void go() {
        try {
            /*
             * Благодаря ServerSocket приложение отслеживает клиентские
             * запросы на порту 3333 на том же компе, где писали код
             */
            ServerSocket serverSocket = new ServerSocket(3333);
            /*
             * Сервер входит в постоянный цикл, ожидая
             * клиентских подключений и обслуживая их
             */
            while (true) {
                /*
                 * accept(); блокирует приложение до тех пор, пока не поступит запрос
                 * после чего возвращает сокет(на анонимном порту) для взаимодействия
                 * с клиентом
                 */
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}

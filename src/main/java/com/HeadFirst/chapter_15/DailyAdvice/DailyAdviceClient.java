package main.java.com.HeadFirst.chapter_15.DailyAdvice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Программа создает сокет и объект BufferReader с помощью
 * других потоков, а затем считывает одну строку, которую ей
 * передает серверное приложение, работающее на порту 3333
 */
public class DailyAdviceClient {
    public void go() {
        try {
            /*
             * Создаем соединение черезсокет к приложению
             * работающему на порте 3333 на том же компе
             * где выполняется данный код
             */
            Socket socket = new Socket("192.168.1.134", 3333);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            /*
             * Подключаем BufferReader к InputStreamReader
             * который уже соединен с исходящим потоком сокета
             */
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Сегодня ты должен: " + advice);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}

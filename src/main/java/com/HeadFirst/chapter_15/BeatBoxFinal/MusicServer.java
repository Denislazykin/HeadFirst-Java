package main.java.com.HeadFirst.chapter_15.BeatBoxFinal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MusicServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Object o1 = null;
            Object o2 = null;
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();
                    System.out.println("Читаем второй объект");
                    tellEveryone(o1, o2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void go() {
        clientOutputStreams = new ArrayList<ObjectOutputStream>();
        try {
            ServerSocket serverSock = new ServerSocket(3333);
            System.out.println("Сервер запущен");
            while (true) {
                Socket clientSoket = serverSock.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSoket.getOutputStream());
                clientOutputStreams.add(out);
                Thread t = new Thread(new ClientHandler(clientSoket));
                t.start();
                System.out.println("Связь установлена");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
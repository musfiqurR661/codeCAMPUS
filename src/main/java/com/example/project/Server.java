package com.example.project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        try {
            serverSocket = new ServerSocket(8001);
            while(true) {
                System.out.println("Waiting for clients...");
                socket = serverSocket.accept();
                System.out.println("Connected");
                ClientHandler clientThread = new ClientHandler(socket, clients);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//
//package com.example.project;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class Server {
//    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
//
//    public static void main(String[] args) {
//        ServerSocket serverSocket;
//        Socket socket;
//        try {
//            serverSocket = new ServerSocket(8888);
//            System.out.println("Server started on port 8888");
//
//            while(true) {
//                System.out.println("Waiting for clients...");
//                socket = serverSocket.accept();
//                System.out.println("Connected to client");
//                ClientHandler clientThread = new ClientHandler(socket, clients);
//                clients.add(clientThread);
//                clientThread.start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

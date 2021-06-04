package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    private ServerSocket serverSocket;
    private int numPlayers;
    private int maxPlayers;

    public GameServer(){
        System.out.println("game server.");
        numPlayers = 0;
        maxPlayers = 10;

        try {
            serverSocket = new ServerSocket(1331);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptConnections (){
        try {
            System.out.println("waiting for connections.");

            while (numPlayers < maxPlayers){
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                numPlayers++;

                dos.writeInt(numPlayers);
                System.out.println("player "+numPlayers+" has connected.");
            }

            System.out.println("No longer accepting connections.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private class ReadFromClient

//    private class ServerConnection implements Runnable{
//        private Socket socket;
//        private DataInputStream dis;
//        private DataOutputStream dos;
//        private int playerID;
//
//        public ServerConnection (Socket s, int id){
//            socket = s;
//            playerID = id;
//
//            try {
//                dis = new DataInputStream(socket.getInputStream());
//                dos = new DataOutputStream(socket.getOutputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void run() {
//            try {
//                dos.writeInt(playerID);
//                dos.flush();
//
//                while (true){
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    /**
     *Main del servidor, Aqui se establece el servidor y las conexiones
     * @param args
     */
    public static void main(String args[]) {

        GameServer server = new GameServer();
        server.acceptConnections();

    }

}

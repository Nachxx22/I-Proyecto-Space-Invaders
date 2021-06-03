package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer extends Thread{

    private ServerSocket serverSocket;
    private int numPlayers;

    private ServerConnection player1;
    private ServerConnection player2;

    public GameServer(){
        System.out.println("game server.");
        numPlayers = 0;

        try {
            serverSocket = new ServerSocket(1331);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptConnections (){
        try {
            while (numPlayers < 2){
                Socket socket = serverSocket.accept();
                numPlayers++;
                System.out.println("player "+numPlayers+" has connected.");
                ServerConnection serverConnection = new ServerConnection(socket, numPlayers);
                if (numPlayers == 1){
                    player1 = serverConnection;
                }
                else{
                    player2 = serverConnection;
                }

                Thread thread = new Thread(serverConnection);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerConnection implements Runnable{
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        private int playerID;

        public ServerConnection (Socket s, int id){
            socket = s;
            playerID = id;

            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                dos.writeInt(playerID);
                dos.flush();

                while (true){

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     *Main del servidor, Aqui se establece el servidor y las conexiones
     * @param args
     */
    public static void main(String args[]) {

        GameServer server = new GameServer();

        server.acceptConnections();
    }

}

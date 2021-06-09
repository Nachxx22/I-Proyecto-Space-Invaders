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

    private Socket p1Socket;
    private Socket p2Socket;

    private ReadFromClient p1Read;
    private ReadFromClient p2Read;
    private WriteToClient p1Write;
    private WriteToClient p2Write;

    private int p1x, p1y,p2x, p2y;

    public GameServer(){
        System.out.println("game server.");
        numPlayers = 0;
        maxPlayers = 2;

        p1x = 280*3/2-25;
        p1y = 360/16*9*3-55;
        p2x = 280*3/2+25;
        p2y = 360/16*9*3-55;

        try {
            serverSocket = new ServerSocket(1331);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptConnections (){
        try {
            System.out.println("waiting for connections...");

            while (numPlayers < maxPlayers){
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                numPlayers++;

                dos.writeInt(numPlayers);
                System.out.println("player "+numPlayers+" has connected.");

                ReadFromClient rfc = new ReadFromClient(numPlayers, dis);
                WriteToClient wtc = new WriteToClient(numPlayers, dos);

                if (numPlayers == 1){
                    p1Socket = socket;
                    p1Read = rfc;
                    p1Write = wtc;
                } else{
                    p2Socket = socket;
                    p2Read = rfc;
                    p2Write = wtc;

                    p1Write.sendStart();
                    p2Write.sendStart();

                    Thread readThread1 = new Thread(p1Read);
                    Thread readThread2 = new Thread(p2Read);
                    readThread1.start();
                    readThread2.start();

                    Thread writeThread1 = new Thread(p1Write);
                    Thread writeThread2 = new Thread(p2Write);
                    writeThread1.start();
                    writeThread2.start();
                }
            }

            System.out.println("No longer accepting connections.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadFromClient implements Runnable {
        private int userID;
        private DataInputStream dataIn;

        public ReadFromClient (int uID, DataInputStream in){
            userID = uID;
            dataIn = in;
            System.out.println("RFC" + userID);
        }

        @Override
        public void run() {
            try{
                while(true){
                    if (userID == 1){
                        p1x = dataIn.readInt();
                        p1y = dataIn.readInt();
                    }else{
                        p2x = dataIn.readInt();
                        p2y = dataIn.readInt();
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private class WriteToClient implements Runnable {
        private int userID;
        private DataOutputStream dataOut;

        public WriteToClient (int uID, DataOutputStream out){
            userID = uID;
            dataOut = out;
            System.out.println("WTC" + userID);
        }

        public void sendStart(){
            try{
                dataOut.writeUTF("Ready. Set. Go!");
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try{
                while(true){
                    if(userID == 1){
                        dataOut.writeInt(p2x);
                        dataOut.writeInt(p2y);
                        dataOut.flush();
                    }else{
                        dataOut.writeInt(p1x);
                        dataOut.writeInt(p1y);
                        dataOut.flush();
                    }

                    Thread.sleep(25);
                }
            }catch(IOException | InterruptedException e){
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

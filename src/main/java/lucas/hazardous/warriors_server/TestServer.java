package lucas.hazardous.warriors_server;

import lucas.hazardous.warriors_server.PlayerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    private ServerSocket serverSocket;
    private int connectionCount = 0;

    private Socket socket;

    public TestServer(int portNumber, int maxConnectionCount) throws IOException, InterruptedException {

        serverSocket = new ServerSocket(portNumber);

        while (this.connectionCount < maxConnectionCount) {
            socket = serverSocket.accept();
            connectionCount++;

            PlayerThread playerThread1 = new PlayerThread(socket);

            socket = serverSocket.accept();
            connectionCount++;

            PlayerThread playerThread2 = new PlayerThread(socket);

            playerThread1.setOtherPlayer(playerThread2);
            playerThread2.setOtherPlayer(playerThread1);

            playerThread1.start();
            playerThread2.start();
        }
    }
}

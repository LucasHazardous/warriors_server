package lucas.hazardous.warriors_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    private ServerSocket serverSocket;

    private Socket socket;

    public TestServer(int portNumber) throws IOException, InterruptedException {

        serverSocket = new ServerSocket(portNumber);

        while (true) {
            socket = serverSocket.accept();

            PlayerThread playerThread1 = new PlayerThread(socket);

            socket = serverSocket.accept();

            PlayerThread playerThread2 = new PlayerThread(socket);

            playerThread1.setOtherPlayer(playerThread2);
            playerThread2.setOtherPlayer(playerThread1);

            playerThread1.start();
            playerThread2.start();
        }
    }
}

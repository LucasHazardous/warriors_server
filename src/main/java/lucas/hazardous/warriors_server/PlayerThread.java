package lucas.hazardous.warriors_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerThread extends Thread {
    private Socket socket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    private PlayerThread otherPlayer;

    public PlayerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socketOut = new PrintWriter(socket.getOutputStream(), true);

            socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                otherPlayer.sendData(socketIn.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOtherPlayer(PlayerThread otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void sendData(String data) {
        socketOut.println(data);
    }
}

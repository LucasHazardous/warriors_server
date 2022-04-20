package lucas.hazardous.warriors_server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            TestServer testServer = new TestServer(80);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

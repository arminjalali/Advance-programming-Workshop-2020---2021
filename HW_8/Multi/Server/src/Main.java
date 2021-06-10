import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        try {
            ServerSocket server = new ServerSocket(6185);
            System.out.println("Server started...");
            while (true){
                counter++;
                Socket socket = server.accept();
                th t = new th(socket , counter);
                t.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

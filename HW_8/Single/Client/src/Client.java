import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    public Client(String address , int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected to the server!");
            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text;
        while (true) {
            try {
                if (((text = input.readLine()).equals("over"))) {
                    break;
                }
                output.writeUTF(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            input.close();
            output.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

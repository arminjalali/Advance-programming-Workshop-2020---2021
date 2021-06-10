import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost" , 6185);
            System.out.println("Client connected to the sever!");
            DataInputStream in = new DataInputStream(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream messageFromServer = new DataInputStream(socket.getInputStream());
            String holder;
            String text = "";
            while (!(holder = in.readLine()).equals("over")){
                text += holder;
                text += "\n";
                out.writeUTF(text);
                String message = messageFromServer.readUTF();
                System.out.println("Server: " + message);

            }
            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

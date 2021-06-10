import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private DataInputStream input;
    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Waiting for client...");
            socket = server.accept();
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String text = "";
            String holder;
            while (!(holder = input.readUTF()).equals("over")){
                text += holder;
                text += "\n";
                System.out.println(text);
            }
        } catch (EOFException e){
            System.out.println("Finish!");
            try {
                socket.close();
                input.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

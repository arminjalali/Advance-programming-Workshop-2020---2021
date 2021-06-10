import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class th extends Thread{
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    int num;
    public th(Socket socket , int num){
        this.socket = socket;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            String text;
            while (!(text = in.readUTF()).equals("over")){
                System.out.println("Client NO" + num + ": ");
                System.out.println(text);
                out.writeUTF("Your message successfully received");
            }
            out.close();
            in.close();
            socket.close();

        }
        catch (EOFException e){
            System.out.println("Client NO" + num + " disconnected!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

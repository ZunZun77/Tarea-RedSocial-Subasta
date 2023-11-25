package ProyectoRedSocial;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.xml.crypto.Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;

//
public class SocketClient {

    private Socket client;

    public SocketClient(Socket socket ) throws IOException {
        this.client = socket;
        System.out.println("Client connected: " + client.getInetAddress().getHostAddress());
    }

    public DataInputStream getInputStream() throws IOException {
        try {
            Thread.sleep(1000);
            return new DataInputStream(client.getInputStream());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DataOutputStream sendstring(String message)  throws IOException{
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.write(message.getBytes());
        out.flush();
        System.out.println("Message sent: " + message);
        return out;
    }
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1050);
        SocketClient client = new SocketClient(socket);
        client.sendstring("Hola");
    }
    
}

package ProyectoRedSocial;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
public class Server {

    private ServerSocket server;
    private ArrayList<SocketClient> clients;
    public Server(int port) throws IOException {
        this.server = new ServerSocket(port);
        this.clients = new ArrayList<>();
    }

    public void start() throws IOException {
        System.out.println("Starting server on port " + server.getLocalPort());

        while (true) {
            // Wait for a client to connect
            
            Socket client = server.accept();
            SocketClient nuevo = new SocketClient(client);
            clients.add(nuevo);
            System.out.println("Client connected: " + client.getInetAddress().getHostAddress());
            // Handle the client in a separate thread
            
        }
    }

    public void messageReceived(SocketClient client) throws IOException {
        DataInputStream buffer = new DataInputStream(client.getInputStream());
        System.out.println("Message received: " + buffer.readUTF());
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(1050);
        server.start();
        server.messageReceived(null);


    }
}
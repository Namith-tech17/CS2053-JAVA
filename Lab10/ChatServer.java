import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client to connect...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            System.out.println("Type messages below to chat (type 'exit' to quit):");

            while (true) {
                // Read message from client
                clientMsg = input.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

                // Send reply to client
                System.out.print("You: ");
                serverMsg = console.readLine();
                output.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println(" Chat ended by server.");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

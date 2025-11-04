import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            System.out.println(" Type messages below to chat (type 'exit' to quit):");

            while (true) {
                System.out.print("You: ");
                clientMsg = console.readLine();
                output.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println(" Chat ended by client.");
                    break;
                }

                // Read server response
                serverMsg = input.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println(" Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

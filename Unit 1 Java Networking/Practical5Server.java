// Write java program to send hello message to the server using UDP
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Practical5Server {

    public static void main(String[] args) {
        int serverPort = 12345;
        byte[] buffer = new byte[1024];
        try (DatagramSocket socket = new DatagramSocket(serverPort)) {
            System.out.println("Server started and listening on port " + serverPort);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }
        } catch (SocketException e) {
            System.err.println("Error creating socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error receiving message: " + e.getMessage());
        }
    }
}

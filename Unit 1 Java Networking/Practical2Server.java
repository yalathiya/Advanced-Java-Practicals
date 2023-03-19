/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 * @author Yash
 */

//Write a java program (client) which accepts integer from user, send it to the server, server sorts 
//all the numbers and returns the sorted numbers to the clients. 
//Example: 
//Client enters and sends following number => 10, 25, 4, 29, and 15, exit. 
//Output on client program should be => 4, 10, 15, 25,29.


import java.io.*;
import java.net.*;
import java.util.*;

public class Practical2Server {
    
    /**
     * @param args the command line arguments
     * @param {numbers} List of num
     * @param {num} a number which is entered by client at command line
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000); // create server socket
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept(); // accept client connection
            System.out.println("Client connected.");

            // create input/output streams
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            List<Integer> numbers = new ArrayList<Integer>();
            while (true) {
                try {
                    int num = dis.readInt(); // read number sent by client
                    if (num == -1) { // client signals end of input
                        break;
                    }
                    numbers.add(num);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }

            Collections.sort(numbers); // sort the numbers

            // send sorted numbers back to client
            for (int num : numbers) {
                dos.writeInt(num);
            }
            dos.writeInt(-1); // signal end of output

            System.out.println("Numbers sorted and sent back to client.");
            serverSocket.close(); // close server socket
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


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

public class Practical2Client {

    /**
     * @param args the command line arguments
     * @param {numbers} List of num
     * @param {num} a number which is entered by client at command line
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000); // connect to server
            System.out.println("Connected to server.");

            // create input/output streams
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Scanner sc = new Scanner(System.in);
            List<Integer> numbers = new ArrayList<Integer>();

            System.out.println("Enter numbers to be sorted (enter -1 to stop):");

            // read numbers from user input and send to server
            while (true) {
                int num = sc.nextInt();
                if (num == -1) {
                    break;
                }
                numbers.add(num);
                dos.writeInt(num);
            }
            dos.writeInt(-1); // signal end of input

            // read sorted numbers from server and print
            System.out.println("Sorted numbers:");
            while (true) {
                try {
                    int num = dis.readInt();
                    if (num == -1) {
                        break;
                    }
                    System.out.print(num + " ");
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }

            socket.close(); // close socket
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 * @author Yash
 */

//  Write a java program(s) to implement simple chat application

import java.io.*;
import java.net.*;
import java.util.*;

public class Practical4Server {
    
    /**
     * @param args the command line arguments
     * @param {str} message which will be send to client
     * @param {msg} message which is send by client
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
            
            while (true) {
                try {
                    String str = dis.readUTF();
                    System.out.println(str);

                    try{
                        String msg = sc.nextLine();
                        dos.writeUTF(msg);
                    }
                    catch(Exception e){
                        System.out.println("");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
  
            serverSocket.close(); // close server socket
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


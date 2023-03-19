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

public class Practical4Client {

    /**
     * @param args the command line arguments
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

            System.out.println("Enter Message : ");

            // read numbers from user input and send to server
            while (true) {
                String str = sc.nextLine();
                dos.writeUTF(str);
                try{
                    String msg = dis.readUTF();
                }
                catch(Exception e){
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

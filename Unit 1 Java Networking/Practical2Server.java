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
     */
    public static void main(String args[]) {
        try{
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server started. Waiting for client...");

            Socket s = ss.accept();
            System.out.println("Client Connected");

            InputStream i = s.getInputStream();
            DataInputStream dis = new DataInputStream(i);
            OutputStream o = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(o);

            List<Integer> numbers = new ArrayList<Integer>();
            while(true){
                try{
                    int num = dis.readInt();
                    if(num == -1){
                        break;
                    }
                    numbers.add(num);
                }
                catch(Exception e){
                    System.out.println(e);
                    break;
                }
            } 

            Collections.sort(numbers); // sort the numbers 

            //send sorted numbers back to client
            for(int num : numbers){
                dos.writeInt(num);
            }
            dos.writeInt(-1); // signal end of output

            System.out.println("Numbers sorted and sent back to client.");
            ss.close(); // close server socket

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

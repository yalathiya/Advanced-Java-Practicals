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

import java.util.*;
import java.io.*;
import java.net.*;
public class Practical2Client {

    /**
     * @param args the command line arguments
     * @param {str} numbers which enters user for sorting
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try{
            Socket s = new Socket("localhost", 3000);
            System.out.println("Connected to server.");
            
            InputStream i = s.getInputStream();
            DataInputStream dis = new DataInputStream(i);
            OutputStream o = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(o);
            
            List<Integer> numbers = new ArrayList<Integer>();

            System.out.println("Enter positive numbers -- Write exit after entering all numbers");

            // read numbers from user input and send to server
            while(true){
                int str = sc.nextInt();
                if(str == -1){
                    break;
                }
                numbers.add(str);
                dos.writeInt(-1);
            }
            dos.writeInt(-1); // -1 for reference for Server -- data is ended

            //Sorted Numbers
            while(true){
                try{
                    int num = dis.readInt();
                    if(num == -1){
                        break;
                    }
                    System.out.println(num+" ");
                }
                catch(Exception e){
                    System.out.println(e);
                    break;
                }
            }
            
            s.close();
            sc.close();
        }
        catch(Exception e){
            System.out.println("Error to execute");
        }
        
    }
}

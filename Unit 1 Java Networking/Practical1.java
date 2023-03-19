/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 * @author Yash
 */

//Write java program(s) which accepts names of website from user and prints IP Address of it. The 
//program should be stopped when user enters �exit� as an input.

import java.util.Scanner;
import java.net.*;
public class Practical1 {

    /**
     * @param args the command line arguments
     * @param {str} URL of Website
     */
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(str != "exit"){
            str = sc.nextLine();
            try{
                InetAddress ip = InetAddress.getByName(new URL(str).getHost()); 
                System.out.println(ip);
            }
            catch(Exception e){
                System.out.println("Please enter correct URL");
            }
        }
    }
}

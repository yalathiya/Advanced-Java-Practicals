/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 * @author Yash
 */

//  Write a menu based java program which performs following. 
//  1. Reverse of the given string 
//  2. Converts string into upper case 
//  3. Converts string into lower case 
//  4. Counts string length 
 
import java.util.Scanner;
public class Practical3 {

    /**
     * @param args the command line arguments
     * @param {str} string on which operations to be performed
     * @param {operation} operation number {1 , 2, 3, 4} details mentioned on line 30- 33
     */
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter String -- enter exit to terminate program");
            String str = sc.nextLine();
            System.out.println("enter 1 for reverse the "+str);
            System.out.println("enter 2 for converting the "+str+ " into upper case");
            System.out.println("enter 3 for converting the "+str+ " into lower case");
            System.out.println("enter 4 for count length of the "+str);
            int operation = sc.nextInt();
            sc.nextLine();
            switch(operation){
                case 1: StringBuilder sb = new StringBuilder(); //reverse the string
                        sb.append(str);
                        sb.reverse();
                        System.out.println(sb);
                        break;

                case 2: System.out.println(str.toUpperCase()); // to upper case
                        break;

                case 3: System.out.println(str.toLowerCase()); //to lower case
                        break;

                case 4: System.out.println("length of string is "+str.length()); //length of string
                        break;
            }
        }
    }
}

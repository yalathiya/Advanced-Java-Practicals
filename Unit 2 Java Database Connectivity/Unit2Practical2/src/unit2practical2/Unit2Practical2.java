/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit2practical2;

//Write a java program to insert a student record in Student Table using Prepared Statement. 

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 * @author Yash
 */
public class Unit2Practical2 {

    /**
     * @param args the command line arguments
     * @param {con} object of Connection class
     * @param {stmt} object of PreparedStatement class
     * @param {sq} Insert SQL Query
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavapractical","root","Yash@2233");
            
            String sq = "INSERT INTO student (name, password, email, address, phone, id) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sq);
            stmt.setString(1, "Nishant");
            stmt.setString(2, "nishu");
            stmt.setString(3, "n@gmail.com");
            stmt.setString(4, "Ahemdabad");
            stmt.setLong(5, 8401055354L);
            stmt.setInt(6, 2);
            stmt.executeUpdate();
  
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Unit2Practical2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Unit2Practical2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

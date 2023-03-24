/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit2practical3;

//Write a java program to call a stored procedure using Callable Statement Interface

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
/**
 * @author Yash
 */
public class Unit2Practical3 {

   /**
     * @param args the command line arguments
     * @param {con} object of Connection class
     * @param {stmt} object of CallableStatement class
     * @param {sql} Calls stored procedure add_studentlocation 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavapractical","root","Yash@2233");
            
            String sql = "{CALL add_studentlocation(?,?)}";
            CallableStatement stmt = con.prepareCall(sql);
            
            stmt.setString(1, "Satyam");
            stmt.setString(2, "Bhavnagar");
            
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Unit2Practical3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Unit2Practical3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

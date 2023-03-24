/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unit2labpractical;

//Write a java program to insert a student record in Student Table. 

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Yash
 */
public class Unit2LABPractical {
    /**
     * @param args the command line arguments
     * @param {con} object of Connection class
     * @param {stmt} object of statement class
     * @param {sq} Insert SQL Query
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejavapractical","root","Yash@2233");
            
            Statement stmt = con.createStatement();
            String sq = "INSERT INTO student VALUES ('yash', 'ya', 'yash@gmail.com', 'surat',7046985354, 1)";
            stmt.executeUpdate(sq);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Unit2LABPractical.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Unit2LABPractical.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

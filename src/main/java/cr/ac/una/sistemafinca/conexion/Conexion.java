/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.sistemafinca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Conexion {
    private static Connection connection;
    
    public Conexion(){
        
    }
    
    public static Connection getConnection(){
        if(connection==null){
            try{
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "C##Sistemafinca";
                String password = "Joe1234";
                connection = DriverManager.getConnection(url,user,password);
            } catch(SQLException ex){
                System.out.println("Error: "+ex.getMessage());
                return null;
            }
        }
        return connection;
    }
}

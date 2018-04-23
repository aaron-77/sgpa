/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.fei.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rvo
 */
public class DataBase {
    private static Connection connection;    
    
    private static void makeConnection() throws SQLException{
        
            
            String url= "jdbc:mysql://localhost/";
            String databaseName = "sistemaacademias";
            String userName = "administrador";
            String password = "pass*.*777";
       
            connection = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
           
        
         
        
    }
    public static Connection getDataBaseConnection() throws SQLException {        
        makeConnection();
        return DataBase.connection;
 
    }
    
    public static void closeConnection(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();                
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

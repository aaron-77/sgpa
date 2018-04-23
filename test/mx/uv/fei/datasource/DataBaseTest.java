/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.fei.datasource;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaron
 */
public class DataBaseTest {
  
  public DataBaseTest() {
  }

  
  
  @Test
  public  void pruebaConexion(){
   try{
     DataBase.getDataBaseConnection();
   }catch(SQLException excepcionSQL){
     excepcionSQL.printStackTrace();
     fail();
   }
    
     
   
    
  
  }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sgpaDomain.Docente;

/**
 *
 * @author aaron
 */
public class DocenteDAOTest {
  
  public DocenteDAOTest() {
  }

  
  @Test
  public void pruebaBusquedaVacia(){
    
    
    try{
      DocenteDAO docente = new DocenteDAO();
      List<Docente> listaEncontrada= docente.buscaDocentesPorNombre("");
       assertTrue("esta vacia",listaEncontrada.isEmpty());
    }catch(SQLException excepcionSQL){
      excepcionSQL.printStackTrace();
      fail();
    }
  }
  
 @Test
  public void pruebaBusquedaConResultado(){
    
    try{
      DocenteDAO docente = new DocenteDAO();
       List<Docente> listaEncontrada= docente.buscaDocentesPorNombre("Newtton");
       assertTrue("esta vacia",!listaEncontrada.isEmpty());
    }catch(SQLException excepcionSQL){
      excepcionSQL.printStackTrace();
      fail();
    }
    
  }
  
  @Test
  public void pruebaConResultadoCorrecto(){
    ArrayList array = new ArrayList();
    String nombreEsperado = "Newtton";
   
    
    try{
      DocenteDAO docente = new DocenteDAO();
       List<Docente> listaEncontrada= docente.buscaDocentesPorNombre("Newtton");
       if(listaEncontrada.isEmpty()){
         fail();
       }
       for(Docente docenteResultado : listaEncontrada){
         assertEquals("resultado correcto",nombreEsperado,docenteResultado.getNombre());
       
       }
       assertTrue("esta vacia",!listaEncontrada.isEmpty());
    }catch(SQLException excepcionSQL){
      excepcionSQL.printStackTrace();
      fail();
    }
  
  
  }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDomain;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class SgpaValidadorLongitudCampos {
  
   /*Guardan los datos truncados cuando no pasan la validacion*/  
  String nombreTruncado ; 
  public boolean resultadoValidacionNombre;
  public boolean resultadoValidacionMatricula;
  public boolean resultadoValidacionGrado;
  public boolean resultadoValidacionCampoGrande;
  public int tamanoNombreTruncado;
  
  
  
  /*tamaños maximos permitidos para cada campo*/
  private final int TAMANO_MAXIMO_NOMBRE = 60;
  private final int TAMANO_MAXIMO_MATRICULA = 20;
  private final int TAMANO_MAXIMO_GRADO_ESTUDIO = 50;
  private final int TAMANO_MAXIMO_CAMPO_GRANDE = 255;
 
  
  /*Metodo que realiza la vadicacion de todos los campos*/
  public boolean sgpaValidarLongitudCampos(Docente docente) {
    nombreTruncado = validarTruncarLongitudNombre(docente.getNombre());
    boolean resultadoValidacionTotal = validarLongitudMatricula(docente.getMatricula()) 
                                      && validarLongitudGradoEstudio(docente.getGradoEstudio());
    docente.setNombre(nombreTruncado);
    return resultadoValidacionTotal;
  }
     
  /**trunca el nombre si es mayor a TAMANO_MAXIMO_NOMBRE*/
  private String validarTruncarLongitudNombre(String nombre) {
    String nombreTruncado="";
    if(nombre.length() > TAMANO_MAXIMO_NOMBRE) {
      resultadoValidacionNombre=false;
      char[]nombreEnArreglo = nombre.toCharArray();/*arreglo nos permite truncar el nombre*/
      for(int iterador = 1 ; iterador <= TAMANO_MAXIMO_NOMBRE ; iterador++) {
        nombreTruncado += nombreEnArreglo[iterador];
      } 
    }else {
      nombreTruncado = nombre;
    }
    tamanoNombreTruncado= nombreTruncado.length();
    return nombreTruncado ;    
  }
  
  /**verifica que se cumpla el tamaño maximo para la matrocula del docente*/
  private boolean validarLongitudMatricula(String matricula){
    resultadoValidacionMatricula = true;
    if(matricula.length() > TAMANO_MAXIMO_MATRICULA) {
     resultadoValidacionMatricula = false; 
    }
    return resultadoValidacionMatricula;    
  }
  //verifica qye se cumpla el tamaño maximo para el campo grado de estudio
  private boolean validarLongitudGradoEstudio(String gradoDeEstudio) {
    resultadoValidacionGrado = true;
    if(gradoDeEstudio.length()>TAMANO_MAXIMO_GRADO_ESTUDIO) {
      resultadoValidacionGrado = false;
    }
    return resultadoValidacionGrado;
  }
  
  private boolean revisarLongitudCamposLongitudGrande(String campo) {
    resultadoValidacionCampoGrande = true;
    if(campo.length()>TAMANO_MAXIMO_CAMPO_GRANDE){
      resultadoValidacionGrado = false;
    }
    return resultadoValidacionCampoGrande;
  }
  
}

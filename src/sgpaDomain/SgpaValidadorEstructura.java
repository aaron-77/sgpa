/*
 * Nombre de clase: sgpaValidadorEstructura
 * Descripcion:Valida la estructura de todos los datos introducidos por el usuario cuidando que cumpla con las estructuras determinadas
     1,0-Lanzamiento Original
   @autor Aaron Hernandez Lara
   @version 1.0 23/04/2018 
 */
package sgpaDomain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aaron
 */
public class SgpaValidadorEstructura {
  private Pattern patronDatos;/*almacena el patron que se usara para validar,este cambiara segun el atributo que se vaya a validar*/
  private Matcher comparaPatron;/**permite comprar el valor del atributo con el patron*/  
    
  public SgpaValidadorEstructura(){
    /*Inicializa la variables*/
    patronDatos = null;
    comparaPatron = null;
    
  }  
  
 /** verifica que todos los atributos de contacto cumpla con el patron adecuado*/
  public boolean sgpaRevisarEstructuraDeCampos(Docente docente) {
   
    boolean resultadoEvaluacion = sgpaRevisarEstructuraDeNombre(docente.getNombre())          
                                  &&  sgpaRevisarEstructuraMatricula(docente.getMatricula()
                                  );
    return resultadoEvaluacion;
  }
 
  /** verifica que el nombre de contacto cumpla con el patron adecuado y no este vacio */
  private boolean sgpaRevisarEstructuraDeNombre(String nombre) {  
    /*expresion regular para validar nombre*/
    String REGEX_PARA_NOMBRE="(^([a-zA-Z])+(([a-zA-Z]+))$"
                            + "|([a-zA-Z]+\\s+[a-zA-Z]+\\s+[a-zA-Z]+)"
                            + "|([a-zA-Z]+\\s+[a-zA-Z]+)&& [^><=*])";
    patronDatos = Pattern.compile(REGEX_PARA_NOMBRE);
    comparaPatron = patronDatos.matcher(nombre);
    boolean resultadoEvaluacion = comparaPatron.find();  
    return resultadoEvaluacion;
  }
  /** verifica que la direccion del contacto cumpla con el patron adecuado */
  private boolean sgpaRevisarEstructuraMatricula(String direccion) {
    /*Expresion regular para validar direccion*/
    String REGEX_PARA_MATRICULA = "^z?S[0-9]{8}$";
    patronDatos = Pattern.compile(REGEX_PARA_MATRICULA);
    comparaPatron = patronDatos.matcher(direccion);
    boolean resultadoEvaluacion=comparaPatron.find();
    return resultadoEvaluacion;
  }
  
  
  
  
 
}
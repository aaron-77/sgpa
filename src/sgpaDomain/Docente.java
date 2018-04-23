/*
 * Nombre de clase: Docente
 * Descripcion:Representa el docente y su informacion
     1,0-Lanzamiento Original
   @autor Aaron Hernandez Lara
   @version 1.0 16/04/2018 
 */
package sgpaDomain;

import java.util.Date;


public class Docente {
    
  private int id;
  private String nombre;
  private String matricula;
  private String gradoEstudio;

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
  
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGradoEstudio() {
    return gradoEstudio;
  }

  public void setGradoEstudio(String gradoEstudio) {
    this.gradoEstudio = gradoEstudio;
  }
  
    
}

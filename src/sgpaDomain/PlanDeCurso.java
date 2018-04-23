/*
 * Nombre de clase: Plan de curso
 * Descripcion: Contiene la informacion necesaria de los planes de curso
     1,0-Lanzamiento Original
   @autor Aaron Hernandez Lara
   @version 1.0 23/04/2018 
 */
package sgpaDomain;


public class PlanDeCurso {
  
  private int id;
  private int unidad;
  private String temas;
  private String tareasYPracticas;
  private String tecnicaDidactica;
  private String bibliografia;
  private String status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUnidad() {
    return unidad;
  }

  public void setUnidad(int unidad) {
    this.unidad = unidad;
  }

  public String getTemas() {
    return temas;
  }

  public void setTemas(String temas) {
    this.temas = temas;
  }

  public String getTareasYPracticas() {
    return tareasYPracticas;
  }

  public void setTareasYPracticas(String tareasYPracticas) {
    this.tareasYPracticas = tareasYPracticas;
  }

  public String getTecnicaDidactica() {
    return tecnicaDidactica;
  }

  public void setTecnicaDidactica(String tecnicaDidactica) {
    this.tecnicaDidactica = tecnicaDidactica;
  }

  public String getBibliografia() {
    return bibliografia;
  }

  public void setBibliografia(String bibliografia) {
    this.bibliografia = bibliografia;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  
  
}

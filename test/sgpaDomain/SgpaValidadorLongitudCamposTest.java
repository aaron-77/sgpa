/*
 * Nombre de clase: sgpaValidadorLongitudCampos
 * Descripcion:Valida que los campos introducidos por el usuario 
     1,0-Lanzamiento Original
   @autor Aaron Hernandez Lara
   @version 1.0 23/04/2018 
 */
package sgpaDomain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaron
 */
public class SgpaValidadorLongitudCamposTest {
  
  public SgpaValidadorLongitudCamposTest() {
  }

  @Test
  public void probarNombreMasDe60(){
    SgpaValidadorLongitudCampos validador = new SgpaValidadorLongitudCampos();
    int longitudEsperada = 60;
   
    Docente docente = new Docente();
    String nombreGrande = "";
    for(int iterador = 0 ; iterador<2000 ; iterador++){
      nombreGrande+="a";
    }
    docente.setNombre(nombreGrande);
    docente.setMatricula("S17028393");
    docente.setGradoEstudio("thegrado");
    validador.sgpaValidarLongitudCampos(docente);
    int longitudObtenida = validador.tamanoNombreTruncado;
    System.out.println("Longitud esperada: "+longitudEsperada+" Longitud obtenida: "+longitudObtenida+" Longitud Original:  "+nombreGrande.length());
    assertTrue("Longitud esperada: "+longitudEsperada+" Longitud obtenida: "+longitudObtenida,(longitudEsperada==longitudObtenida));
  }
  
  @Test
  public void probargradoEstudioMasDe50Caracteres(){
    SgpaValidadorLongitudCampos validador = new SgpaValidadorLongitudCampos();
    Docente docente = new Docente();
    String gradoDeEstudioLargo = "";
    for(int iterador = 0 ; iterador<10 ; iterador++){
      gradoDeEstudioLargo+="a";
    }
    docente.setNombre("Aaron");
    docente.setMatricula("S17028393");
    docente.setGradoEstudio(gradoDeEstudioLargo);
    validador.sgpaValidarLongitudCampos(docente);
    assertTrue("Validacion grado aprobada: ",validador.resultadoValidacionGrado);
  }
  
  @Test
  public void probarCampoGrande(){
    SgpaValidadorLongitudCampos validador = new SgpaValidadorLongitudCampos();
    AvanceProgramatico avance = new AvanceProgramatico();
    PlanDeCurso plan = new PlanDeCurso();
    plan.setTemas("introduccion a la contruccionde software\nprubas unitarias");
    plan.setTecnicaDidactica("retroalimentacion y trabajo autonomo");
    
  
  }
  
  
  
  
}

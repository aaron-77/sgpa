/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDomain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaron
 */
public class SgpaValidadorEstructuraTest {
  
  public SgpaValidadorEstructuraTest() {
  }
@Test
  public void revisarNombreVacio(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("");
    docente.setMatricula("");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("nombre y matricula vacia",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarEstructuraUnNombreYMatricula(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("S17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertTrue("solo un nombre y matricula",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarEstructuraNombreCompletoYMatricula(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron hernandez lara");
    docente.setMatricula("S17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertTrue("solo un nombre y matricula",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarEstructuraMultiplesNombresYMatricula(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron francisco diego abelardo de dios hernandez  lara");
    docente.setMatricula("S17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertTrue("muchos nombres y matricula",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarNombreConCaracteresInyeccion(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("'or 1=1 ;");
    docente.setMatricula("S17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("nombre con inyeccion",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarMatriculaSinUnDigito(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("S1702839");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
   @Test
  public void revisarMatriculaConZMinuscula(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("zS17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertTrue("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  @Test
  public void revisarMatriculaConZMayuscula(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("ZS17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula con Z mayuscula",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  
   @Test
  public void revisarMatriculaSinS(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
   @Test
  public void revisarMatriculaConZSinS(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("z17028393");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
   @Test
  public void revisarMatriculaConDigitosDeMas(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("S170283939");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
  
  
  @Test
  public void revisarMatriculaConCracteresInyeccion(){
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    Docente docente = new Docente();
    docente.setNombre("aaron");
    docente.setMatricula("S170'or1=1;83939");
    validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    assertFalse("matricula sin un digito",validadorEstructura.sgpaRevisarEstructuraDeCampos(docente));
  
  }
}

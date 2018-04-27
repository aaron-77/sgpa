/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDomain;

/**
 *
 * @author aaron
 */
public class SgpaValidadorDatos {
  
  public static boolean agendaRevisarValidezDeAtributos(Docente docente){
    SgpaValidadorLongitudCampos validadorLongitudes = new SgpaValidadorLongitudCampos();
    validadorLongitudes.sgpaValidarLongitudCampos(docente);
    SgpaValidadorEstructura validadorEstructura = new SgpaValidadorEstructura();
    boolean resultadoValidacion = validadorEstructura.sgpaRevisarEstructuraDeCampos(docente);
    return resultadoValidacion;    
  }
}

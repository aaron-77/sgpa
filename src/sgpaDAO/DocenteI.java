/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDAO;

import java.sql.SQLException;
import java.util.List;
import sgpaDomain.AvanceProgramatico;
import sgpaDomain.Docente;
import sgpaDomain.PlanDeCurso;

/**
 *
 * @author aaron
 */
public interface DocenteI {
  List<Docente> buscaDocentesPorNombre(String nombre) throws SQLException;
  Docente obtenDocentePorId(int idDocente) throws SQLException;
  Docente obtenDocentePorMatricula(String matricula) throws SQLException;
  List<Docente> obtenerTodosDocentes() throws SQLException;
  List<Docente>obtenerDocentesAcademia(int id) throws SQLException;
  boolean elaborarPlanDeCurso (PlanDeCurso planDeCurso) throws SQLException;
  boolean editarPlanDeCurso (PlanDeCurso planDeCurso) throws SQLException;
  boolean elaborarAvanceProgramatico (AvanceProgramatico avanceProgramatico) throws SQLException;
  boolean agregaDocente(Docente docente) throws SQLException;
  boolean eliminaDocente(int idDocente) throws SQLException;
  boolean actualizaDocente(int idDocente) throws SQLException;
    
}

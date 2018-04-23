/*
 * Nombre de clase: DocenteDAO
 * Descripcion:Data Acess Object Docente
     1,0-Lanzamiento Original
   @autor Aaron Hernandez Lara
   @version 1.0 16/04/2018 
 */
package sgpaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.uv.fei.datasource.DataBase;
import sgpaDomain.AvanceProgramatico;
import sgpaDomain.Docente;
import sgpaDomain.PlanDeCurso;

/**
 *
 * @author aaron
 */
public class DocenteDAO implements DocenteI {
  
  private ArrayList<Docente> listaDocentes;
  private String query;
  private String queryApoyo;
  private Connection connection;
  
    public DocenteDAO(){        
    }

  @Override
  public List<Docente> buscaDocentesPorNombre(String nombre) throws SQLException {
    listaDocentes= new ArrayList<>();
    query="select * from docente where nombre like ?";
    connection=DataBase.getDataBaseConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    statement.setString(1, "%"+nombre+"%");
    ResultSet result=statement.executeQuery();
    while(result.next()){
      Docente docente = new Docente();
      docente.setNombre(result.getString("nombre"));
      docente.setId(Integer.parseInt(result.getString("id")));
      docente.setGradoEstudio(result.getString("gradoEstudio"));
      docente.setMatricula(result.getString("matricula"));
      listaDocentes.add(docente);
    }   
    DataBase.closeConnection();
    return listaDocentes;
  }

  @Override
  public Docente obtenDocentePorId(int idDocente) throws SQLException {
    query = "SELECT d.idContacto,d.nombre,d.apellidos FROM docente d , where id = ?";
    connection=DataBase.getDataBaseConnection();
    Docente docente = new Docente();
    try {
      PreparedStatement statement=connection.prepareStatement(query);
      statement.setInt(1,idDocente);
      ResultSet result=statement.executeQuery();
      while(result.next()){
        docente.setNombre(result.getString("nombre"));
        docente.setMatricula(result.getString("matricula"));
        docente.setGradoEstudio(result.getString("gradoEstudio"));
        docente.setId(result.getInt("idContacto"));
      }     
    } catch (SQLException ex) {
        System.out.println("no se pudo encontrar el contacto");
        ex.printStackTrace();
      }finally{
          DataBase.closeConnection();
        }        
        return docente;
  }

  @Override
  public Docente obtenDocentePorMatricula(String matricula) throws SQLException {
    
    Docente docenteEncontrado = null;
    query="select * from docente where matricula = ?";
    connection=DataBase.getDataBaseConnection();  
    PreparedStatement statement=connection.prepareStatement(query);
    statement.setString(1,matricula);
    ResultSet result=statement.executeQuery();
    while(result.next()){
      Docente docente = new Docente();
      docente.setNombre(result.getString("nombre"));
      docente.setId(Integer.parseInt(result.getString("id")));
      docente.setGradoEstudio(result.getString("gradoEstudio"));
      docente.setMatricula(result.getString("matricula"));
      docenteEncontrado = docente;
    }
    DataBase.closeConnection();
                
    return docenteEncontrado;
  }

  @Override
  public List<Docente> obtenerTodosDocentes() throws SQLException {
    listaDocentes= new ArrayList<>();
    query="SELECT * FROM docente ";
    connection=DataBase.getDataBaseConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    ResultSet result=statement.executeQuery();
    while(result.next()){
      Docente docente = new Docente();
      docente.setNombre(result.getString("nombre"));
      docente.setId(Integer.parseInt(result.getString("id")));
      docente.setGradoEstudio(result.getString("gradoEstudio"));
      docente.setMatricula(result.getString("matricula"));
      listaDocentes.add(docente);
    }   
    DataBase.closeConnection();
    return listaDocentes;
  }

  @Override
  public List<Docente> obtenerDocentesAcademia(int idAcademia) throws SQLException {
   listaDocentes= new ArrayList<>();
    query="SELECT * FROM docente WHERE id IN(SELECT idDocente FROM `academiadocente` WHERE idAcademia = ?)";
    connection=DataBase.getDataBaseConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    statement.setInt(1,idAcademia);
    ResultSet result=statement.executeQuery();
    while(result.next()){
      Docente docente = new Docente();
      docente.setNombre(result.getString("nombre"));
      docente.setId(Integer.parseInt(result.getString("id")));
      docente.setGradoEstudio(result.getString("gradoEstudio"));
      docente.setMatricula(result.getString("matricula"));
      listaDocentes.add(docente);
    }   
    DataBase.closeConnection();
    return listaDocentes;
  }
  
  @Override
  public boolean elaborarPlanDeCurso(PlanDeCurso planDeCurso) throws SQLException {
    listaDocentes= new ArrayList<>();
    query="INSERT INTO plandecurso (unidad,temas,tareasYPracticas,tecnicaDidactica,bibliografia)(?,?,?,?,?)";
    connection=DataBase.getDataBaseConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    statement.setInt(1,planDeCurso.getUnidad());
    statement.setString(2,planDeCurso.getTemas());
    statement.setString(3,planDeCurso.getTareasYPracticas());
    statement.setString(4,planDeCurso.getTecnicaDidactica());
    statement.setString(5,planDeCurso.getBibliografia());
    int result=statement.executeUpdate();
    DataBase.closeConnection();
    return true;
  }
  
  

  @Override
  public boolean agregaDocente(Docente docente) throws SQLException {
     listaDocentes= new ArrayList<>();
    query="INSERT INTO docente  (nombre,matricula,gradoDeEstudio)(?,?,?)";
    connection=DataBase.getDataBaseConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    statement.setString(1,docente.getNombre());
    statement.setString(2,docente.getMatricula());
    statement.setString(3,docente.getNombre());
    int result=statement.executeUpdate();
    DataBase.closeConnection();
    return true;
  }
  
   @Override
  public boolean editarPlanDeCurso(PlanDeCurso planDeCurso) throws SQLException {
    
    PreparedStatement statement = connection.prepareStatement(query);
    query = "UPDATE plandecurso set unidad= ?,temas= ?,tareasYPracticas = ?,tecnicaDidactica = ?,blibliografia = ? WHERE id = ?";
    statement = connection.prepareStatement(query);
    statement.setInt(6,planDeCurso.getId());
    statement.setString(2,planDeCurso.getTemas());
    statement.setString(3,planDeCurso.getTareasYPracticas());
    statement.setString(4,planDeCurso.getTecnicaDidactica());
    statement.setString(5,planDeCurso.getBibliografia());
    int resultUpdate = statement.executeUpdate();
    DataBase.closeConnection();
    return true;  
  }
  
  @Override
  public boolean elaborarAvanceProgramatico(AvanceProgramatico avanceProgramatico) throws SQLException {
    
    
    return true;
  }

  @Override
  public boolean eliminaDocente(int idDocente) {
    return true;
  }

  @Override
  public boolean actualizaDocente(int idDocente) {
    return true;
  }

  

 

  
    
   
   
}

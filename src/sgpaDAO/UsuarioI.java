/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDAO;

import sgpaDomain.Usuario;
import java.util.List;

/**
 *
 * @author Andy
 */
public interface UsuarioI {
  List<Usuario> buscaUsuarioPorNombre(String usuario);
  Usuario obtenUsuarioPorId(int id);
  List<Usuario> obtenerTodosUsuarios();
  boolean agregaUsuario(Usuario usuario);
  boolean eliminaUsuario(int id);
  Usuario editarUsuario(int id, Usuario usuario);
}

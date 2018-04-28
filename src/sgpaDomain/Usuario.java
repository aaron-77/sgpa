/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpaDomain;


/**
 *
 * @author Andy
 */
public class Usuario {

  private int id;
  private String contraseña;
  private String usuario;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
  
  public String getUsuario() {
    return usuario;
  }
  
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
        
}
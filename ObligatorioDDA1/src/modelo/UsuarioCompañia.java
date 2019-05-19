/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gonzalo
 */
public final class UsuarioCompañia extends Usuario {
    private Compañia compañia;
    
    public Compañia getCompañia() {
        return compañia;
    } 
    
    public void setCompañia(Compañia compañia) {
        this.compañia = compañia;
    }
    
    public UsuarioCompañia() { }
    
    public UsuarioCompañia(String nombreUsuario, String nombreCompleto, String password, Rol rol, Compañia compañia) {
        super(nombreUsuario, nombreCompleto, password, rol);
        this.compañia = compañia;
    } 
    
    @Override
    public String getNombreTrabajo() {
      return compañia.getNombre();
   }
    
    @Override
    public Compañia getTrabajo() {
      return compañia;
   }
    
    @Override
    public String toString() {
        return super.getNombreCompleto() + " - " + this.getNombreTrabajo();
    }
}

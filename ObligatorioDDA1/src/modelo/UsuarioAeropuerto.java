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
public final class UsuarioAeropuerto extends Usuario {
    private Aeropuerto aeropuerto;
    
    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    } 
    
    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
    
    public UsuarioAeropuerto() { }
    
    public UsuarioAeropuerto(String nombreUsuario, String nombreCompleto, String password, Rol rol, Aeropuerto aeropuerto) {
        super(nombreUsuario, nombreCompleto, password, rol);
        this.aeropuerto = aeropuerto;
    } 
    
    @Override
    public String getNombreTrabajo() {
      return aeropuerto.getNombre();
   }
    
    @Override
    public Aeropuerto getTrabajo() {
      return aeropuerto;
   }
    
    @Override
    public String toString() {
        return super.getNombreCompleto() + " - " + this.getNombreTrabajo();
    }
}

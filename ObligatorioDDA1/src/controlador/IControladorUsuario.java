/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;

/**
 *
 * @author gonzalo
 */
public interface IControladorUsuario {
    public Usuario login(String cedula, String password);

    public Usuario getLogueado();
    
    public void setLogueado(Usuario Usuario);
    
    public void agregarUsuario(Usuario usuario);
}

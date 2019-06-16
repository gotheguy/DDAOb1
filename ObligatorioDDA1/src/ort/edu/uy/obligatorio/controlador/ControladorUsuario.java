/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.controlador;

import ort.edu.uy.obligatorio.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author gonzalo
 */
public class ControladorUsuario {
    private final IControladorUsuario IControladorUsuario;
    private Usuario logueado;
    private final ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    public ControladorUsuario(IControladorUsuario IControladorUsuario) {
        this.IControladorUsuario = IControladorUsuario;
    }
    
    public Usuario login(String nombre, String password) {
        for (Usuario u: listaUsuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombre) && u.getPassword().equalsIgnoreCase(password)) {
                this.logueado = u;
                return u;
            }
        }
        return null;
    }

    public Usuario getLogueado() {
        return this.logueado;
    }
    
    public void setLogueado(Usuario usuario) {
        this.logueado = usuario;
    }
    
    public void agregarUsuario(Usuario usuario) {
        if (!listaUsuarios.contains(usuario)) {
            this.listaUsuarios.add(usuario);
        }
    }
}

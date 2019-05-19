/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author gonzalo
 */
public class Aeropuerto implements Observer {
    private String nombre;
    private String ciudad;
    private ArrayList<Frecuencia> frecuencias = new ArrayList();
    private ArrayList<Usuario> usuariosAeropuerto = new ArrayList();
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public ArrayList<Frecuencia> getFrecuencias() {
        return frecuencias;
    }
    
    public void setFrecuencias(ArrayList<Frecuencia> frecuencias) {
        this.frecuencias = frecuencias;
    }
    
    public ArrayList<Usuario> getUsuariosAeropuerto() {
        return usuariosAeropuerto;
    }
    
    public void setUsuariosAeropuerto(ArrayList<Usuario> usuariosAeropuerto) {
        this.usuariosAeropuerto = usuariosAeropuerto;
    }
    
    public Aeropuerto() { }
    
    public Aeropuerto(String nombre, String ciudad, ArrayList<Frecuencia> frecuencias, ArrayList<Usuario> usuariosAeropuerto) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.frecuencias = frecuencias;
        this.usuariosAeropuerto = usuariosAeropuerto;
    }
    
    public void agregarFrecuencia(Frecuencia frecuencia) {
        if (!frecuencias.contains(frecuencia)) {
            this.frecuencias.add(frecuencia);
        }
    }
    
    @Override
    public void update(Observable o, Object frecuencia) {
        for (Frecuencia f : this.frecuencias) {
            f.actualizarFrecuencia((Frecuencia)frecuencia);
        }
    }
}
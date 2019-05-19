/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author gonzalo
 */
public class Compañia extends Observable {
    private String nombre;
    private String alias;
    private ArrayList<Frecuencia> frecuencias = new ArrayList();
    private ArrayList<Usuario> usuariosCompañia = new ArrayList();
    private ArrayList<Vuelo> vuelos = new ArrayList();
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAlias() {
        return alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public ArrayList<Frecuencia> getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(ArrayList<Frecuencia> frecuencias) {
        this.frecuencias = frecuencias;
    }
    
    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    public ArrayList<Usuario> getUsuariosCompañia() {
        return usuariosCompañia;
    }

    public void setUsuariosCompañia(ArrayList<Usuario> usuariosCompañia) {
        this.usuariosCompañia = usuariosCompañia;
    }
    
    public Compañia() { }
    
    public Compañia(String nombre, String alias, ArrayList<Frecuencia> frecuencias, ArrayList<Usuario> usuariosCompañia, ArrayList<Vuelo> vuelos) {
        this.nombre = nombre;
        this.alias = alias;
        this.frecuencias = frecuencias;
        this.usuariosCompañia = usuariosCompañia;
        this.vuelos = vuelos;
    }
        
    public void agregarFrecuencia(Frecuencia frecuencia){
        this.frecuencias.add(frecuencia);
        setChanged();
        notifyObservers(frecuencia);
    }
}

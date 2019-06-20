/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.modelo;

import java.util.*;

/**
 *
 * @author gonzalo
 */
public class AeropuertoConcreto extends Observable {
    private String nombre;
    private String ciudad;
    private ArrayList<Frecuencia> frecuencias = new ArrayList();
    private ArrayList<Usuario> usuariosAeropuerto = new ArrayList();
    private Cobra cobra;
    
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
        
    public Cobra getCobra() {
        return this.cobra;
    }
    
    public void setCobra(Cobra cobra) {
        this.cobra = cobra;
    }
    
    public AeropuertoConcreto() { }
    
    public AeropuertoConcreto(String nombre, String ciudad, ArrayList<Frecuencia> frecuencias, ArrayList<Usuario> usuariosAeropuerto, Cobra cobra) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.frecuencias = frecuencias;
        this.usuariosAeropuerto = usuariosAeropuerto;
        this.cobra = cobra;
    }
    
    public void agregarFrecuencia(Frecuencia frecuencia) {
        if (!frecuencias.contains(frecuencia)) {
            this.frecuencias.add(frecuencia);
            setChanged();
            notifyObservers(frecuencia);
        }
    }
}
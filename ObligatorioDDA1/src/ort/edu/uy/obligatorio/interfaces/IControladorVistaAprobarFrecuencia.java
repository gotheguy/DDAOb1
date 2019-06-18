/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.interfaces;

import ort.edu.uy.obligatorio.modelo.*;
import java.util.ArrayList;

/**
 *
 * @author gonzalo
 */
public interface IControladorVistaAprobarFrecuencia {
    public void agregarFrecuencia(Frecuencia frecuencia);
    
    public String getLetraDiasSemana(Frecuencia frecuencia);
    
    public void rechazarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen);
    
    public void aprobarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen);
    
    public void rechazarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public void aprobarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesOrigen(Aeropuerto aeropuerto);
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesDestino(Aeropuerto aeropuerto);
}

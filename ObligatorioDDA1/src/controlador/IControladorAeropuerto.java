/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author gonzalo
 */
public interface IControladorAeropuerto {
    public void agregarAeropuerto(Aeropuerto aeropuerto);
    
    public ArrayList<Aeropuerto> getListaAeropuertos();
    
    public Aeropuerto getAeropuertoPorCiudad(String ciudad);
    
    public void agregarFrecuenciaAeropuerto(Frecuencia frecuencia);
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesOrigen(Aeropuerto aeropuerto);
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesDestino(Aeropuerto aeropuerto);
    
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasOrigen(Aeropuerto aeropuerto);
    
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasDestino(Aeropuerto aeropuerto);
    
    public void rechazarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen);
    
    public void aprobarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen);
    
    public void rechazarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public void aprobarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public void ingresarPartidaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public void ingresarLlegadaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino);
    
    public String getDiaActual();
    
    public ArrayList<Frecuencia> getListaPartidas(Aeropuerto aeropuertoOrigen);
    
    public ArrayList<Frecuencia> getListaLlegadas(Aeropuerto aeropuertoDestino);
}

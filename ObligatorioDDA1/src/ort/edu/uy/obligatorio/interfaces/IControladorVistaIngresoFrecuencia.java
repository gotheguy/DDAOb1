/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.interfaces;

import java.time.LocalTime;
import ort.edu.uy.obligatorio.modelo.*;
import java.util.ArrayList;

/**
 *
 * @author gonzalo
 */
public interface IControladorVistaIngresoFrecuencia {
    public void agregarAeropuerto(Aeropuerto aeropuerto);
    
    public void agregarDiaSemana(DiaSemana diaSemana);
    
    public void agregarVuelo(Vuelo vuelo);
    
    public void agregarFrecuencia(Frecuencia frecuencia);
    
    public ArrayList<Aeropuerto> getListaAeropuertos();
    
    public ArrayList<String> getListaDiasSemana();
    
    public Aeropuerto getAeropuertoPorCiudad(String ciudad);
    
    public ArrayList<Object> validarFrecuencia(String aeropuertoOrigen, String aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario);
    
    public Frecuencia crearFrecuencia(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario);
        
    public LocalTime convertirHora(String horaPartida);
}

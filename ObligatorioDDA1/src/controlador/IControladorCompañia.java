/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.time.LocalTime;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author gonzalo
 */
public interface IControladorCompañia {
    public Frecuencia crearFrecuencia(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario);
    
    public LocalTime convertirHora(String horaPartida);
    
    public void agregarVuelo(Vuelo vuelo);
    
    public void agregarFrecuenciaCompañia(Frecuencia frecuencia);
    
    public boolean chequearFrecuenciaDuplicada(String aeropuertoOrigen, String aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario);
    
    public String getLetraDiasSemana(Frecuencia frecuencia);
    
    public String getNumeroVuelo(Compañia compañia);
    
    public ArrayList<Frecuencia> getListaFrecuencias(String nombreCompañia);
    
    public ArrayList<Vuelo> getVuelosCompañia(Compañia compañia);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.controlador;

import ort.edu.uy.obligatorio.modelo.*;
import java.util.ArrayList;

/**
 *
 * @author gonzalo
 */
public interface IControladorVistaIngresarPartidaVuelo {
    
    public void ingresarPartidaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuerto);
    
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasOrigen(Aeropuerto aeropuerto);
    
    public String getDiaActual();
}

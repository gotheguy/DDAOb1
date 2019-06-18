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
public interface IControladorVistaVisualizarListaFrecuencias {
    public void agregarFrecuencia(Frecuencia frecuencia);
    
    public ArrayList<Frecuencia> getListaFrecuencias(String nombreCompañia);
    
    public String getLetraDiasSemana(Frecuencia frecuencia);
}

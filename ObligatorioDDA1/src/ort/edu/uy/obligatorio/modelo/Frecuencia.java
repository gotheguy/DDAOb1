/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author gonzalo
 */
public class Frecuencia {
    private static int numero = 1;
    private int numeroId;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private ArrayList<DiaSemana> diasSemana = new ArrayList();
    private LocalTime horaPartida;
    private int duracionEstimada;
    private Compañia compañia;
    private ArrayList<Vuelo> vuelos = new ArrayList();
    private EstadoFrecuencia estadoAeropuertoOrigen;
    private EstadoFrecuencia estadoAeropuertoDestino;
    
    public int getNumero() {
        return numeroId;
    }
    
    public void setNumero(int numeroId) {
        this.numeroId = numeroId;
    }
    
    public LocalTime getHoraPartida() {
        return horaPartida;
    }
    
    public void setHoraPartida(LocalTime horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    public int getDuracionEstimada() {
        return duracionEstimada;
    }
    
    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }
    
    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }
    
    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }
    
    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }
    
    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }    
    
    public ArrayList<DiaSemana> getDiasSemana() {
        return diasSemana;
    }
    
    public void setDiasSemana(ArrayList<DiaSemana> diasSemana) {
        this.diasSemana = diasSemana;
    }
    
    public Compañia getCompañia() {
        return compañia;
    }
    
    public void setCompañia(Compañia compañia) {
        this.compañia = compañia;
    }
    
    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
    
    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    public EstadoFrecuencia getEstadoAeropuertoOrigen() {
        return estadoAeropuertoOrigen;
    }
    
    public void setEstadoAeropuertoOrigen(EstadoFrecuencia estadoAeropuertoOrigen) {
        this.estadoAeropuertoOrigen = estadoAeropuertoOrigen;
    }
    
    public EstadoFrecuencia getEstadoAeropuertoDestino() {
        return estadoAeropuertoDestino;
    }
    
    public void setEstadoAeropuertoDestino(EstadoFrecuencia estadoAeropuertoDestino) {
        this.estadoAeropuertoDestino = estadoAeropuertoDestino;
    }
    
    public Frecuencia() { }
    
    public Frecuencia(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, ArrayList<DiaSemana> diasSemana, LocalTime horaPartida, int duracionEstimada, 
            Compañia compañia, ArrayList<Vuelo> vuelos, EstadoFrecuencia estadoAeropuertoOrigen, EstadoFrecuencia estadoAeropuertoDestino) {
        this.numeroId = numero++;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.horaPartida = horaPartida;
        this.duracionEstimada = duracionEstimada;
        this.diasSemana = diasSemana;
        this.compañia = compañia;
        this.vuelos = vuelos;
        this.estadoAeropuertoOrigen = estadoAeropuertoOrigen;
        this.estadoAeropuertoDestino = estadoAeropuertoDestino;
    }
    
    @Override
    public String toString() {
        return "\nFrecuencia{" + "numero=" + numeroId + ", aeropuerto origen=" + aeropuertoOrigen.getNombre() + ", aeropuerto destino=" + aeropuertoDestino.getNombre() 
                + ", hora partida=" + horaPartida + ", duración estimada=" + duracionEstimada + ", dias semana=" + diasSemana
                + ", compañia=" + compañia.getNombre() + ", vuelos=" + vuelos + ", estado aeropuerto origen=" + estadoAeropuertoOrigen 
                + ", estado aeropuerto destino=" + estadoAeropuertoDestino + '}';
    }
}

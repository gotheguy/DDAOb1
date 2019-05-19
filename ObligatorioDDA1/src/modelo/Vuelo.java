/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalTime;

/**
 *
 * @author gonzalo
 */
public class Vuelo {
    private static int numero = 1;
    private String numeroId;
    private DiaSemana fechaPartida;
    private LocalTime horaPartida;
    private LocalTime horaLlegada;
    private Compañia compañia;
    private Frecuencia frecuencia;
    private EstadoVuelo estado;
    
    public String getNumero() {
        return numeroId;
    }
    
    public void setNumero(int numeroId) {
        this.numeroId = compañia.getAlias() + numeroId;
    }
    
    public DiaSemana getFechaPartida() {
        return fechaPartida;
    }
    
    public void setFechaPartida(DiaSemana fechaPartida) {
        this.fechaPartida = fechaPartida;
    }
    
    public LocalTime getHoraPartida() {
        return horaPartida;
    }
    
    public void setHoraPartida(LocalTime horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }
    
    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    public Compañia getCompañia() {
        return compañia;
    }
    
    public void setCompañia(Compañia compañia) {
        this.compañia = compañia;
    }
    
    public Frecuencia getFrecuencia() {
        return frecuencia;
    }
    
    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    public EstadoVuelo getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }
    
    public Vuelo() { }
    
    public Vuelo(DiaSemana fechaPartida, LocalTime horaPartida, LocalTime horaLlegada, Compañia compañia, Frecuencia frecuencia, EstadoVuelo estado) {
        this.numeroId = compañia.getAlias() + numero++;
        this.fechaPartida = fechaPartida;
        this.horaPartida = horaPartida;
        this.horaLlegada = horaLlegada;
        this.compañia = compañia;
        this.frecuencia = frecuencia;
        this.estado = estado;
    }
}

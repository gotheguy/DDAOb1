/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import modelo.*;

/**
 *
 * @author gonzalo
 */
public class ControladorAeropuerto {
    private final IControladorAeropuerto IControladorAeropuerto;
    private final ArrayList<Aeropuerto> listaAeropuertos = new ArrayList();
    private final ArrayList<Frecuencia> listaFrecuencias = new ArrayList();
    
    public ControladorAeropuerto(IControladorAeropuerto IControladorAeropuerto) {
        this.IControladorAeropuerto = IControladorAeropuerto;
    }
    
    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        if (!listaAeropuertos.contains(aeropuerto)) {
            this.listaAeropuertos.add(aeropuerto);
        }
    }
    
    public ArrayList<Aeropuerto> getListaAeropuertos() {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList();
        for (Aeropuerto aeropuerto : this.listaAeropuertos) {
            if(aeropuerto != null) {
                aeropuertos.add(aeropuerto);
            }
        }
        return aeropuertos;
    }
    
    public Aeropuerto getAeropuertoPorCiudad(String ciudad) {
        Aeropuerto aeropuerto = null;
        for (Aeropuerto a : this.listaAeropuertos) {
            if(a.getCiudad().equals(ciudad)) {
                aeropuerto = a;
            }
        }
        return aeropuerto;
    }
    
    public void agregarFrecuencia(Frecuencia frecuencia) {
        if (!listaFrecuencias.contains(frecuencia)) {
            this.listaFrecuencias.add(frecuencia);
        }
    }
 
    public boolean diaSemanaEsActual(Frecuencia frecuencia) {
        String diaActual = this.getDiaActual();
        boolean bandera = false;
        
        for (DiaSemana d : frecuencia.getDiasSemana()) {
            if(diaActual.equals(d.toString())) {
                bandera = !bandera;
            }  
        }
        return bandera;
    }
    
    public String getDiaActual() {
        Date fecha = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        String dia = simpleDateformat.format(fecha);
        
        String d1 = dia.substring(0,1).toUpperCase();
        String d2 = dia.substring(1, dia.length());
        return d1 + d2;
    }
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesOrigen(Aeropuerto aeropuerto) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(f.getAeropuertoOrigen().equals(aeropuerto) && f.getEstadoAeropuertoOrigen() == EstadoFrecuencia.Pendiente) {
                frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesDestino(Aeropuerto aeropuerto) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(f.getAeropuertoDestino().equals(aeropuerto) && f.getEstadoAeropuertoOrigen() == EstadoFrecuencia.Aprobada && 
                f.getEstadoAeropuertoDestino() == EstadoFrecuencia.Pendiente) {
                frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasOrigen(Aeropuerto aeropuerto) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(f.getAeropuertoOrigen().equals(aeropuerto) && f.getEstadoAeropuertoOrigen() == EstadoFrecuencia.Aprobada && 
                f.getEstadoAeropuertoDestino() == EstadoFrecuencia.Aprobada && this.diaSemanaEsActual(f)) {
                    frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasDestino(Aeropuerto aeropuerto) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(f.getAeropuertoDestino().equals(aeropuerto) && f.getEstadoAeropuertoOrigen() == EstadoFrecuencia.Aprobada && 
                f.getEstadoAeropuertoDestino() == EstadoFrecuencia.Aprobada) {
                    frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Frecuencia> getListaPartidas(Aeropuerto aeropuertoOrigen) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuertoOrigen.getFrecuencias()) {
            if(f.getAeropuertoOrigen().equals(aeropuertoOrigen)) {
                frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Frecuencia> getListaLlegadas(Aeropuerto aeropuertoDestino) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia f : aeropuertoDestino.getFrecuencias()) {
            if(f.getAeropuertoDestino().equals(aeropuertoDestino)) {
                frecuencias.add(f);
            }
        }
        return frecuencias;
    }
    
    public void rechazarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen) {
        for (Frecuencia f : aeropuertoOrigen.getFrecuencias()) {
            if(frecuenciaSeleccionada[2].equals(f.getAeropuertoDestino().getNombre()) && frecuenciaSeleccionada[0].equals(f.getCompañia().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[1].equals(v.getNumero())) {
                        f.setEstadoAeropuertoOrigen(EstadoFrecuencia.Rechazada);
                    }
                }
            }
        }
    }
    
    public void aprobarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen) {
        for (Frecuencia f : aeropuertoOrigen.getFrecuencias()) {
            if(frecuenciaSeleccionada[2].equals(f.getAeropuertoDestino().getNombre()) && frecuenciaSeleccionada[0].equals(f.getCompañia().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[1].equals(v.getNumero())) {
                        f.setEstadoAeropuertoOrigen(EstadoFrecuencia.Aprobada);
                    }
                }
            }
        }
    }
    
    public void rechazarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino) {
        for (Frecuencia f : aeropuertoDestino.getFrecuencias()) {
            if(frecuenciaSeleccionada[2].equals(f.getAeropuertoOrigen().getNombre()) && frecuenciaSeleccionada[0].equals(f.getCompañia().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[1].equals(v.getNumero())) {
                        f.setEstadoAeropuertoDestino(EstadoFrecuencia.Rechazada);
                    }
                }
            }
        }
    }
    
    public void aprobarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino) {
        for (Frecuencia f : aeropuertoDestino.getFrecuencias()) {
            if(frecuenciaSeleccionada[2].equals(f.getAeropuertoOrigen().getNombre()) && frecuenciaSeleccionada[0].equals(f.getCompañia().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[1].equals(v.getNumero())) {
                        f.setEstadoAeropuertoDestino(EstadoFrecuencia.Aprobada);
                    }
                }
            }
        }
    }
    
    public void ingresarPartidaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuerto) {
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(frecuenciaSeleccionada[2].equals(f.getAeropuertoDestino().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[1].equals(v.getNumero())) {
                        LocalTime timeStamp = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
                        v.setHoraPartida(timeStamp);
                        EstadoVuelo estado = this.horarioVuelo(timeStamp, f.getHoraPartida());
                        v.setEstado(estado);
                    }
                }
            }
        }
    }
    
    public void ingresarLlegadaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuerto) {
        for (Frecuencia f : aeropuerto.getFrecuencias()) {
            if(frecuenciaSeleccionada[1].equals(f.getAeropuertoOrigen().getNombre())) {
                for (Vuelo v : f.getVuelos()) {
                    if(frecuenciaSeleccionada[0].equals(v.getNumero())) {
                        LocalTime timeStamp = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
                        v.setHoraLlegada(timeStamp);
                        v.setEstado(EstadoVuelo.Aterrizado);
                    }
                }
            }
        }
    }
    
    public EstadoVuelo horarioVuelo(LocalTime timeStamp, LocalTime horaPartidaFrecuencia) {
        EstadoVuelo estado = null;
        long diff = Duration.between(horaPartidaFrecuencia, timeStamp).toMinutes();
        
        if(horaPartidaFrecuencia.equals(timeStamp) || (diff <= 5 && diff >= -5)) {
            estado = EstadoVuelo.EnHora;
        } 
        else if(diff < 5) {
            estado = EstadoVuelo.Adelantado;
        }
        else if(diff > -5) {
            estado = EstadoVuelo.Retrasado;
        }
        return estado;
    }
}

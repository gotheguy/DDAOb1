/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.*;

/**
 *
 * @author gonzalo
 */
public class ControladorCompañia implements Observer {
    private final IControladorCompañia IControladorCompañia;
    private final ArrayList<Vuelo> listaVuelos = new ArrayList();
    private final ArrayList<Frecuencia> listaFrecuencias = new ArrayList();
    
    public ControladorCompañia(IControladorCompañia IControladorCompañia) { 
        this.IControladorCompañia = IControladorCompañia;
    }

    public Frecuencia crearFrecuencia(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario) {
        ArrayList<DiaSemana> diasSemana = new ArrayList();
        ArrayList<Vuelo> vuelos = new ArrayList();
        Compañia c = (Compañia)usuario.getTrabajo();
        LocalTime hora = convertirHora(horaPartida);
        
        for (String dia : listaDiasSemana) {
            if(dia == null ? DiaSemana.valueOf(dia).name() == null : dia.equals(DiaSemana.valueOf(dia).name())) {
                Vuelo vuelo = new Vuelo(DiaSemana.valueOf(dia), null, null, (Compañia)usuario.getTrabajo(), null, EstadoVuelo.Pendiente);
                IControladorCompañia.agregarVuelo(vuelo);
                vuelos.add(vuelo);
                diasSemana.add(DiaSemana.valueOf(dia));
            }
        }
        Frecuencia frecuencia = new Frecuencia(aeropuertoOrigen, aeropuertoDestino, diasSemana, hora, duracionEstimada, (Compañia)usuario.getTrabajo(), 
                vuelos, EstadoFrecuencia.Pendiente, EstadoFrecuencia.Pendiente);
        
        c.addObserver(this);
        frecuencia.addObserver(aeropuertoOrigen);
        frecuencia.addObserver(aeropuertoDestino);
        
        aeropuertoOrigen.agregarFrecuencia(frecuencia);
        aeropuertoDestino.agregarFrecuencia(frecuencia);
        c.agregarFrecuencia(frecuencia);
        
        for(Vuelo v : vuelos) {
            v.setFrecuencia(frecuencia);
        }
        return frecuencia;
    }  
    
    public LocalTime convertirHora(String horaPartida) {
        LocalTime localTime = LocalTime.parse(horaPartida,
        DateTimeFormatter.ofPattern("HH:mm"));
        return localTime;
    }
    
    public void agregarVuelo(Vuelo vuelo) {
        if (!listaVuelos.contains(vuelo)) {
            this.listaVuelos.add(vuelo);
        }
    }
    
    public void agregarFrecuencia(Frecuencia frecuencia) {
        if (!listaFrecuencias.contains(frecuencia)) {
            this.listaFrecuencias.add(frecuencia);
        }
    }
    
    public boolean chequearFrecuenciaDuplicada(String aeropuertoOrigen, String aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario) {
        boolean bandera = false;
        LocalTime hora = convertirHora(horaPartida);
        ArrayList<DiaSemana> diasSemana = new ArrayList();
        
        for (String dia : listaDiasSemana) {
            diasSemana.add(DiaSemana.valueOf(dia));
        }
        
        for (Frecuencia f : this.listaFrecuencias) {
            if(aeropuertoOrigen.equals(f.getAeropuertoOrigen().getCiudad()) && aeropuertoDestino.equals(f.getAeropuertoDestino().getCiudad()) && duracionEstimada == f.getDuracionEstimada() 
                    && usuario.getTrabajo().equals(f.getCompañia()) && hora.equals(f.getHoraPartida()) && f.getDiasSemana().containsAll(diasSemana) && f.getEstadoAeropuertoOrigen() != EstadoFrecuencia.Rechazada) {
                        bandera = !bandera;
            }
        }
        return bandera;
    }
    
    public String getLetraDiasSemana(Frecuencia frecuencia) {
        String letrasDias = "";
        for (Frecuencia f : this.listaFrecuencias) {
            if(f.equals(frecuencia)) {
                for (DiaSemana dia : f.getDiasSemana()) {
                    if(dia.equals(DiaSemana.Miércoles)) {
                        letrasDias = letrasDias + "X";
                    } else {
                        letrasDias = letrasDias + dia.toString().substring(0, 1);
                    }
                }
            }
        }   
        return letrasDias;
    }  
    
    public String getNumeroVuelo(Compañia compañia) {
        String numero = "";
        for (Vuelo vuelo : this.listaVuelos) {
            if(compañia.equals(vuelo.getCompañia())) {
                numero = vuelo.getNumero();
            }
        }
        return numero;
    }
    
    public ArrayList<Frecuencia> getListaFrecuencias(String nombreCompañia) {
        ArrayList<Frecuencia> frecuencias = new ArrayList();
        for (Frecuencia frecuencia : this.listaFrecuencias) {
            if(frecuencia != null) {
                if(frecuencia.getCompañia().getNombre().equals(nombreCompañia)) {
                    frecuencias.add(frecuencia);
                }
            }
        }
        return frecuencias;
    }
    
    public ArrayList<Vuelo> getVuelosCompañia(Compañia compañia) {
        ArrayList<Vuelo> vuelos = new ArrayList();
        for (Vuelo vuelo : this.listaVuelos) {
            if(vuelo != null) {
                if(vuelo.getCompañia().equals(compañia)) {
                    vuelos.add(vuelo);
                }
            }
        }
        return vuelos;
    }

    @Override
    public void update(Observable o, Object frecuencia) {
        this.agregarFrecuencia((Frecuencia)frecuencia);
    }
}

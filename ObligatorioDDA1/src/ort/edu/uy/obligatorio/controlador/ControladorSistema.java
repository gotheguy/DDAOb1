/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.controlador;

import ort.edu.uy.obligatorio.interfaces.IControladorVistaMonitoreo;
import ort.edu.uy.obligatorio.interfaces.IControladorVistaVisualizarListaFrecuencias;
import ort.edu.uy.obligatorio.interfaces.IControladorVistaAprobarFrecuencia;
import ort.edu.uy.obligatorio.interfaces.IControladorUsuario;
import ort.edu.uy.obligatorio.interfaces.IControladorVistaIngresarLlegadaVuelo;
import ort.edu.uy.obligatorio.interfaces.IControladorVistaIngresoFrecuencia;
import ort.edu.uy.obligatorio.interfaces.IControladorVistaIngresarPartidaVuelo;
import java.text.SimpleDateFormat;
import java.time.Duration;
import ort.edu.uy.obligatorio.modelo.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gonzalo
 */
public class ControladorSistema implements IControladorUsuario, IControladorVistaIngresoFrecuencia, IControladorVistaAprobarFrecuencia, IControladorVistaVisualizarListaFrecuencias,
        IControladorVistaIngresarPartidaVuelo, IControladorVistaIngresarLlegadaVuelo, IControladorVistaMonitoreo {
    private final ControladorUsuario controladorUsuario;
    private final ControladorVistaIngresoFrecuencia controladorVistaIngresoFrecuencia;
    private final ControladorVistaAprobarFrecuencia controladorVistaAprobarFrecuencia;
    private final ControladorVistaVisualizarListaFrecuencias controladorVistaVisualizarListaFrecuencias;
    private final ControladorVistaIngresarPartidaVuelo controladorVistaIngresarPartidaVuelo;
    private final ControladorVistaIngresarLlegadaVuelo controladorVistaIngresarLlegadaVuelo;
    private final ControladorVistaMonitoreo controladorVistaMonitoreo;
    private static ControladorSistema instancia;

    public static ControladorSistema getInstancia() {
        if (instancia == null) {
            instancia = new ControladorSistema();
        }
        return instancia;
    }
    
    private ControladorSistema() {
        this.controladorUsuario = new ControladorUsuario(this);
        this.controladorVistaIngresoFrecuencia = new ControladorVistaIngresoFrecuencia(this);
        this.controladorVistaAprobarFrecuencia = new ControladorVistaAprobarFrecuencia(this);
        this.controladorVistaVisualizarListaFrecuencias = new ControladorVistaVisualizarListaFrecuencias(this);
        this.controladorVistaIngresarPartidaVuelo = new ControladorVistaIngresarPartidaVuelo(this);
        this.controladorVistaIngresarLlegadaVuelo = new ControladorVistaIngresarLlegadaVuelo(this);
        this.controladorVistaMonitoreo = new ControladorVistaMonitoreo(this);
    }
    
    public void cargarDatos() {
        ArrayList<Usuario> usuarios1 = new ArrayList();
        ArrayList<Usuario> usuarios2 = new ArrayList();
        ArrayList<Usuario> usuarios3 = new ArrayList();
        ArrayList<Usuario> usuarios4 = new ArrayList();
        ArrayList<Usuario> usuarios5 = new ArrayList();
        ArrayList<Usuario> usuarios6 = new ArrayList();
        ArrayList<Usuario> usuarios7 = new ArrayList();
        ArrayList<Usuario> usuarios8 = new ArrayList();
        
        ArrayList<DiaSemana> dias1 = new ArrayList();
        ArrayList<DiaSemana> dias2 = new ArrayList();
        ArrayList<DiaSemana> dias3 = new ArrayList();
        ArrayList<DiaSemana> dias4 = new ArrayList();
        ArrayList<DiaSemana> dias5 = new ArrayList();
        ArrayList<DiaSemana> dias6 = new ArrayList();        
        
        ArrayList<Frecuencia> frecuencias1 = new ArrayList();
        ArrayList<Frecuencia> frecuencias2 = new ArrayList();
        ArrayList<Frecuencia> frecuencias3 = new ArrayList();
        
        ArrayList<Vuelo> vuelos1 = new ArrayList();
        ArrayList<Vuelo> vuelos2 = new ArrayList();
        ArrayList<Vuelo> vuelos3 = new ArrayList();
        ArrayList<Vuelo> vuelos4 = new ArrayList();
        ArrayList<Vuelo> vuelos5 = new ArrayList();
        ArrayList<Vuelo> vuelos6 = new ArrayList();
        ArrayList<Vuelo> vuelos7 = new ArrayList();
        ArrayList<Vuelo> vuelos8 = new ArrayList();
        
        ArrayList<Vuelo> compañiaVuelos1 = new ArrayList();
        ArrayList<Vuelo> compañiaVuelos2 = new ArrayList();
        ArrayList<Vuelo> compañiaVuelos3 = new ArrayList();
        
        ArrayList<Frecuencia> colaFrecuencias1 = new ArrayList();
        ArrayList<Frecuencia> colaFrecuencias2 = new ArrayList();
        ArrayList<Frecuencia> colaFrecuencias3 = new ArrayList();
        ArrayList<Frecuencia> colaFrecuencias4 = new ArrayList();
        ArrayList<Frecuencia> colaFrecuencias5 = new ArrayList();
        
        Compañia c1 = new Compañia("Gol", "GOL", null, null, null);
        Compañia c2 = new Compañia("Latam", "LAT", null, null, null);
        Compañia c3 = new Compañia("Avianca", "AVI", null, null, null);

        Aeropuerto a1 = new Aeropuerto("Aeropuerto El Dorado", "Bogotá, Colombia", colaFrecuencias1, null);
        Aeropuerto a2 = new Aeropuerto("Aeroparque Jorge Newbery", "Rio de Janeiro, Brasil", colaFrecuencias2, null);
        Aeropuerto a3 = new Aeropuerto("Aeropuerto Ezeiza", "Ezeiza, Argentina", colaFrecuencias3, null);
        Aeropuerto a4 = new Aeropuerto("Aeropuerto Mataveri", "Valparaiso, Chile", colaFrecuencias4, null);
        Aeropuerto a5 = new Aeropuerto("Aeropuerto Alejandro Velasco Astete", "Cusco, Perú", colaFrecuencias5, null);
        
        Vuelo v1 = new Vuelo(DiaSemana.Jueves, null, null, c2, null, EstadoVuelo.Pendiente);
        Vuelo v2 = new Vuelo(DiaSemana.Lunes, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v3 = new Vuelo(DiaSemana.Martes, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v4 = new Vuelo(DiaSemana.Viernes, null, null, c3, null, EstadoVuelo.Pendiente);
        Vuelo v5 = new Vuelo(DiaSemana.Domingo, null, null, c3, null, EstadoVuelo.Pendiente);
        Vuelo v6 = new Vuelo(DiaSemana.Miércoles, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v7 = new Vuelo(DiaSemana.Martes, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v8 = new Vuelo(DiaSemana.Viernes, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v9 = new Vuelo(DiaSemana.Miércoles, null, null, c1, null, EstadoVuelo.Pendiente);
        Vuelo v10 = new Vuelo(DiaSemana.Lunes, null, null, c2, null, EstadoVuelo.Pendiente);
        Vuelo v11 = new Vuelo(DiaSemana.Sábado, null, null, c3, null, EstadoVuelo.Pendiente);
        
        dias1.add(DiaSemana.Martes);
        dias1.add(DiaSemana.Viernes);
        dias1.add(DiaSemana.Sábado);
        dias2.add(DiaSemana.Martes);
        dias2.add(DiaSemana.Miércoles);
        dias3.add(DiaSemana.Lunes);
        dias3.add(DiaSemana.Miércoles);
        dias3.add(DiaSemana.Viernes);
        dias4.add(DiaSemana.Miércoles);
        dias4.add(DiaSemana.Viernes);
        dias4.add(DiaSemana.Domingo);
        dias5.add(DiaSemana.Lunes);
        dias5.add(DiaSemana.Martes);
        dias5.add(DiaSemana.Miércoles);
        dias5.add(DiaSemana.Jueves);
        dias5.add(DiaSemana.Viernes);
        dias6.add(DiaSemana.Jueves);
        dias6.add(DiaSemana.Viernes);       
        dias6.add(DiaSemana.Sábado);  
        dias6.add(DiaSemana.Domingo);
        
        Usuario u1 = new UsuarioCompañia("agomez", "Alberto Gomez", "asd83h83j", Rol.Compañia, c1);
        Usuario u2 = new UsuarioCompañia("jcastillo", "Juan Castillo", "d43g4333e", Rol.Compañia, c1);
        Usuario u3 = new UsuarioCompañia("fbouza", "Francisco Bouza", "h4h5h56da", Rol.Compañia, c1);
        Usuario u4 = new UsuarioCompañia("rmiranda", "Rodrigo Miranda", "46j556j56", Rol.Compañia, c1);
        Usuario u5 = new UsuarioCompañia("gberi", "Gonzalo Beri", "65j34h3g4", Rol.Compañia, c2);
        Usuario u6 = new UsuarioCompañia("mcazorla", "Martin Cazorla", "ads32f345", Rol.Compañia, c2);
        Usuario u7 = new UsuarioCompañia("jortega", "Javier Ortega", "35y3ggg3g", Rol.Compañia, c2);
        Usuario u8 = new UsuarioCompañia("claunas", "Claudio Launas", "g56ydfh55", Rol.Compañia, c2);
        Usuario u9 = new UsuarioCompañia("acortez", "Alfredo Cortez", "gdfhdh5h5", Rol.Compañia, c3);
        Usuario u10 = new UsuarioCompañia("obeisso", "Oscar Beisso", "u3ou34ouh", Rol.Compañia, c3);

        Usuario u11 = new UsuarioAeropuerto("mramirez", "Martin Ramirez", "u29298nf8", Rol.Aeropuerto, a1);
        Usuario u12 = new UsuarioAeropuerto("pvelez", "Pedro Velez", "j293fn93n", Rol.Aeropuerto, a2);
        Usuario u13 = new UsuarioAeropuerto("ogutierrez", "Omar Gutierrez", "329f2m392", Rol.Aeropuerto, a2);
        Usuario u14 = new UsuarioAeropuerto("sromero", "Sebastian Romero", "sdf9sd938", Rol.Aeropuerto, a2);
        Usuario u15 = new UsuarioAeropuerto("ebarcos", "Esteban Barcos", "asdj939n2", Rol.Aeropuerto, a3);
        Usuario u16 = new UsuarioAeropuerto("pperez", "Patricio Perez", "2m3f92m9f", Rol.Aeropuerto, a3);
        Usuario u17 = new UsuarioAeropuerto("mgoya", "Marcelo Goya", "m29f3mfnf", Rol.Aeropuerto, a4);
        Usuario u18 = new UsuarioAeropuerto("vmagallan", "Victor Magallan", "mg59h54nn", Rol.Aeropuerto, a4);
        Usuario u19 = new UsuarioAeropuerto("mbrito", "Marco Brito", "a90asd093", Rol.Aeropuerto, a5);
        Usuario u20 = new UsuarioAeropuerto("csegovia", "Carlos Segovia", "3ip6jpif7", Rol.Aeropuerto, a5);
        
        usuarios1.add(u1);
        usuarios1.add(u2);
        usuarios1.add(u3);
        usuarios1.add(u4);
        usuarios2.add(u5);
        usuarios2.add(u6);
        usuarios2.add(u7);
        usuarios2.add(u8);
        usuarios3.add(u9);
        usuarios3.add(u10);
        
        usuarios4.add(u11);
        usuarios5.add(u12);
        usuarios5.add(u13);
        usuarios5.add(u14);
        usuarios6.add(u15);
        usuarios6.add(u16);
        usuarios7.add(u17);
        usuarios7.add(u18);
        usuarios8.add(u19);
        usuarios8.add(u20);
     
        c1.setUsuariosCompañia(usuarios1);
        c2.setUsuariosCompañia(usuarios2);
        c3.setUsuariosCompañia(usuarios3);
        
        a1.setUsuariosAeropuerto(usuarios4);
        a2.setUsuariosAeropuerto(usuarios5);
        a3.setUsuariosAeropuerto(usuarios6);
        a4.setUsuariosAeropuerto(usuarios7);
        a5.setUsuariosAeropuerto(usuarios8);

        vuelos1.add(v2);
        vuelos1.add(v3);
        vuelos2.add(v6);
        vuelos2.add(v7);
        vuelos3.add(v8);
        
        vuelos4.add(v9);
        vuelos4.add(v1);
        vuelos6.add(v10);
        vuelos5.add(v11);
        vuelos7.add(v4);
        vuelos8.add(v5);
        
        compañiaVuelos1.add(v2);
        compañiaVuelos1.add(v3);
        compañiaVuelos1.add(v6);
        compañiaVuelos1.add(v7);
        compañiaVuelos1.add(v8);
        compañiaVuelos2.add(v11);
        compañiaVuelos3.add(v9);
        compañiaVuelos3.add(v1);
        compañiaVuelos3.add(v10);
        compañiaVuelos3.add(v4);
        compañiaVuelos3.add(v5);
        
        c1.setVuelos(compañiaVuelos1);
        c2.setVuelos(compañiaVuelos2);
        c3.setVuelos(compañiaVuelos3);
        
        Frecuencia f1 = new Frecuencia(a1, a4, dias1, this.convertirHora("12:30"), 120, c1, vuelos1, EstadoFrecuencia.Pendiente, EstadoFrecuencia.Pendiente);
        Frecuencia f2 = new Frecuencia(a3, a2, dias2, this.convertirHora("15:00"), 240, c1, vuelos2, EstadoFrecuencia.Aprobada, EstadoFrecuencia.Rechazada);
        Frecuencia f3 = new Frecuencia(a5, a1, dias3, this.convertirHora("17:30"), 50, c1, vuelos3, EstadoFrecuencia.Pendiente, EstadoFrecuencia.Pendiente);
        Frecuencia f4 = new Frecuencia(a4, a3, dias4, this.convertirHora("13:30"), 200, c2, vuelos5, EstadoFrecuencia.Pendiente, EstadoFrecuencia.Pendiente);
        Frecuencia f5 = new Frecuencia(a5, a4, dias6, this.convertirHora("14:00"), 180, c3, vuelos4, EstadoFrecuencia.Rechazada, EstadoFrecuencia.Rechazada);
        Frecuencia f6 = new Frecuencia(a1, a2, dias5, this.convertirHora("20:00"), 340, c3, vuelos6, EstadoFrecuencia.Aprobada, EstadoFrecuencia.Aprobada);
        Frecuencia f7 = new Frecuencia(a5, a2, dias1, this.convertirHora("14:00"), 180, c3, vuelos7, EstadoFrecuencia.Rechazada, EstadoFrecuencia.Rechazada);
        Frecuencia f8 = new Frecuencia(a2, a3, dias5, this.convertirHora("20:00"), 340, c3, vuelos8, EstadoFrecuencia.Pendiente, EstadoFrecuencia.Pendiente);
        
        frecuencias1.add(f1);
        frecuencias1.add(f2);
        frecuencias1.add(f3);
        frecuencias2.add(f4);
        frecuencias3.add(f5);
        frecuencias3.add(f6);
        frecuencias3.add(f7);
        frecuencias3.add(f8);
        
        c1.setFrecuencias(frecuencias1);
        c2.setFrecuencias(frecuencias2);
        c3.setFrecuencias(frecuencias3);
        
        v1.setFrecuencia(f5);
        v2.setFrecuencia(f1);
        v3.setFrecuencia(f1);
        v4.setFrecuencia(f7);
        v5.setFrecuencia(f8);
        v6.setFrecuencia(f2);
        v7.setFrecuencia(f2);
        v8.setFrecuencia(f3);
        v9.setFrecuencia(f5);
        v10.setFrecuencia(f6);
        v11.setFrecuencia(f4);
        
        colaFrecuencias1.add(f1);
        colaFrecuencias5.add(f3);
        colaFrecuencias4.add(f4);
        colaFrecuencias2.add(f8);
        
        this.agregarUsuario(u1);
        this.agregarUsuario(u2);
        this.agregarUsuario(u3);
        this.agregarUsuario(u4);
        this.agregarUsuario(u5);
        this.agregarUsuario(u6);
        this.agregarUsuario(u7);
        this.agregarUsuario(u8);
        this.agregarUsuario(u9);
        this.agregarUsuario(u10);
        this.agregarUsuario(u11);
        this.agregarUsuario(u12);
        this.agregarUsuario(u13);
        this.agregarUsuario(u14);
        this.agregarUsuario(u15);
        this.agregarUsuario(u16);      
        this.agregarUsuario(u17);
        this.agregarUsuario(u18);    
        this.agregarUsuario(u19);
        this.agregarUsuario(u20);
        
        this.agregarAeropuerto(a1);
        this.agregarAeropuerto(a2);
        this.agregarAeropuerto(a3);
        this.agregarAeropuerto(a4);
        this.agregarAeropuerto(a5);
        
        this.agregarDiaSemana(DiaSemana.Lunes);
        this.agregarDiaSemana(DiaSemana.Martes);
        this.agregarDiaSemana(DiaSemana.Miércoles);
        this.agregarDiaSemana(DiaSemana.Jueves);
        this.agregarDiaSemana(DiaSemana.Viernes);
        this.agregarDiaSemana(DiaSemana.Sábado);
        this.agregarDiaSemana(DiaSemana.Domingo);
        
        this.agregarFrecuencia(f1);
        this.agregarFrecuencia(f2);
        this.agregarFrecuencia(f3);
        this.agregarFrecuencia(f4);
        this.agregarFrecuencia(f5);
        this.agregarFrecuencia(f6);
        this.agregarFrecuencia(f7);
        this.agregarFrecuencia(f8);
        
        this.agregarFrecuencia(f1);
        this.agregarFrecuencia(f2);
        this.agregarFrecuencia(f3);
        this.agregarFrecuencia(f4);
        this.agregarFrecuencia(f5);
        this.agregarFrecuencia(f6);
        this.agregarFrecuencia(f7);
        this.agregarFrecuencia(f8);
        
        this.agregarVuelo(v1);
        this.agregarVuelo(v2);
        this.agregarVuelo(v3);
        this.agregarVuelo(v4);
        this.agregarVuelo(v5);
        this.agregarVuelo(v6);
        this.agregarVuelo(v7);
        this.agregarVuelo(v8);
        this.agregarVuelo(v9);
        this.agregarVuelo(v10);
        this.agregarVuelo(v11);
    }
    
    @Override
    public Usuario login(String nombre, String password) {
        return this.controladorUsuario.login(nombre, password);
    }
    
    @Override
    public Usuario getLogueado() {
        return this.controladorUsuario.getLogueado();
    }

    @Override
    public void setLogueado(Usuario usuario) {
        this.controladorUsuario.setLogueado(usuario);
    }
    
    @Override
    public void agregarUsuario(Usuario usuario) {
        this.controladorUsuario.agregarUsuario(usuario);
    }
    
    @Override
    public ArrayList<Aeropuerto> getListaAeropuertos() {
        return this.controladorVistaIngresoFrecuencia.getListaAeropuertos();
    }
    
    @Override
    public ArrayList<String> getListaDiasSemana() {
        return this.controladorVistaIngresoFrecuencia.getListaDiasSemana();
    }
    
    @Override
    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        this.controladorVistaIngresoFrecuencia.agregarAeropuerto(aeropuerto);
        this.controladorVistaVisualizarListaFrecuencias.agregarAeropuerto(aeropuerto);
    }
    
    @Override
    public void agregarDiaSemana(DiaSemana diaSemana) {
        this.controladorVistaIngresoFrecuencia.agregarDiaSemana(diaSemana);
    }
    
    @Override
    public void agregarFrecuencia(Frecuencia frecuencia) {
        this.controladorVistaIngresoFrecuencia.agregarFrecuencia(frecuencia);
        this.controladorVistaVisualizarListaFrecuencias.agregarFrecuencia(frecuencia);
    }
    
    @Override
    public void agregarVuelo(Vuelo vuelo) {
        this.controladorVistaIngresoFrecuencia.agregarVuelo(vuelo);
    }
    
    @Override
    public Aeropuerto getAeropuertoPorCiudad(String ciudad) {
        return this.controladorVistaIngresoFrecuencia.getAeropuertoPorCiudad(ciudad);
    }
    
    
    @Override
    public LocalTime convertirHora(String horaPartida) {
        LocalTime localTime = LocalTime.parse(horaPartida,
        DateTimeFormatter.ofPattern("HH:mm"));
        return localTime;
    }
    
    @Override
    public ArrayList<Object> validarFrecuencia(String aeropuertoOrigen, String aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario) {
        return this.controladorVistaIngresoFrecuencia.validarFrecuencia(aeropuertoOrigen, aeropuertoDestino, listaDiasSemana, horaPartida, duracionEstimada, usuario);
    }
    
    public void ingresarFrecuencia(String aeropuertoOrigen, String aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario) {
        Aeropuerto origen = this.getAeropuertoPorCiudad(aeropuertoOrigen);
        Aeropuerto destino = this.getAeropuertoPorCiudad(aeropuertoDestino);
        this.crearFrecuencia(origen, destino, listaDiasSemana, horaPartida, duracionEstimada, usuario);
    }
    
    @Override
    public String getLetraDiasSemana(Frecuencia frecuencia) {
        return this.controladorVistaVisualizarListaFrecuencias.getLetraDiasSemana(frecuencia);
    }

    @Override
    public Frecuencia crearFrecuencia(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String[] listaDiasSemana, String horaPartida, int duracionEstimada, Usuario usuario) {
        return this.controladorVistaIngresoFrecuencia.crearFrecuencia(aeropuertoOrigen, aeropuertoDestino, listaDiasSemana, horaPartida, duracionEstimada, usuario);
    }   
        
    @Override
    public ArrayList<Frecuencia> getListaFrecuencias(String nombreCompañia) {
        return this.controladorVistaVisualizarListaFrecuencias.getListaFrecuencias(nombreCompañia);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesOrigen(Aeropuerto aeropuerto) {
        return this.controladorVistaAprobarFrecuencia.getListaFrecuenciasPendientesOrigen(aeropuerto);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaFrecuenciasPendientesDestino(Aeropuerto aeropuerto) {
        return this.controladorVistaAprobarFrecuencia.getListaFrecuenciasPendientesDestino(aeropuerto);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasOrigen(Aeropuerto aeropuerto) {
        return this.controladorVistaIngresarPartidaVuelo.getListaFrecuenciasAprobadasOrigen(aeropuerto);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaFrecuenciasAprobadasDestino(Aeropuerto aeropuerto) {
        return this.controladorVistaIngresarLlegadaVuelo.getListaFrecuenciasAprobadasDestino(aeropuerto);
    }
    
    @Override
    public void rechazarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen) {
        this.controladorVistaAprobarFrecuencia.rechazarFrecuenciaOrigen(frecuenciaSeleccionada, aeropuertoOrigen);
    }
    
    @Override
    public void aprobarFrecuenciaOrigen(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoOrigen) {
        this.controladorVistaAprobarFrecuencia.aprobarFrecuenciaOrigen(frecuenciaSeleccionada, aeropuertoOrigen);
    }
    
    @Override
    public void rechazarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino) {
        this.controladorVistaAprobarFrecuencia.rechazarFrecuenciaDestino(frecuenciaSeleccionada, aeropuertoDestino);
    }
    
    @Override
    public void aprobarFrecuenciaDestino(String[] frecuenciaSeleccionada, Aeropuerto aeropuertoDestino) {
        this.controladorVistaAprobarFrecuencia.aprobarFrecuenciaDestino(frecuenciaSeleccionada, aeropuertoDestino);
    }
    
    @Override
    public void ingresarPartidaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuerto) {
        this.controladorVistaIngresarPartidaVuelo.ingresarPartidaVuelo(frecuenciaSeleccionada, aeropuerto);
    }
    
    @Override
    public void ingresarLlegadaVuelo(String[] frecuenciaSeleccionada, Aeropuerto aeropuerto) {
        this.controladorVistaIngresarLlegadaVuelo.ingresarLlegadaVuelo(frecuenciaSeleccionada, aeropuerto);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaPartidas(Aeropuerto aeropuertoOrigen) {
        return this.controladorVistaMonitoreo.getListaPartidas(aeropuertoOrigen);
    }
    
    @Override
    public ArrayList<Frecuencia> getListaLlegadas(Aeropuerto aeropuertoDestino) {
        return this.controladorVistaMonitoreo.getListaLlegadas(aeropuertoDestino);
    }
        
    @Override
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
    
    @Override
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
    
    @Override
    public String getDiaActual() {
        Date fecha = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        String dia = simpleDateformat.format(fecha);
        
        String d1 = dia.substring(0,1).toUpperCase();
        String d2 = dia.substring(1, dia.length());
        return d1 + d2;
    }
}

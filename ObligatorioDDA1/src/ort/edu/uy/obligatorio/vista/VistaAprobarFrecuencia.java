/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ort.edu.uy.obligatorio.vista;

import ort.edu.uy.obligatorio.modelo.*;
import ort.edu.uy.obligatorio.controlador.ControladorSistema;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gonzalo
 */
public class VistaAprobarFrecuencia extends javax.swing.JFrame {
    private final ControladorSistema controladorSistema;
    private Usuario usuarioLogeado = null;
    private VistaMonitoreo vistaMonitoreo = null;
    private VistaLogin vistaLogin = null;
    /**
     * Creates new form VistaAprobarFrecuencia
     * @param usuario
     * @param vistaMonitoreo
     * @param vistaLogin
     */
    public VistaAprobarFrecuencia(Usuario usuario, VistaMonitoreo vistaMonitoreo, VistaLogin vistaLogin) {
        this.controladorSistema = ControladorSistema.getInstancia();
        initComponents();
        this.usuarioLogeado = usuario;
        this.vistaMonitoreo = vistaMonitoreo;
        this.vistaLogin = vistaLogin;
        lblUsuarioLogeado.setText(usuario.toString());
        cargarFrecuenciasPendientesOrigen();
        cargarFrecuenciasPendientesDestino();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuarioLogeado = new javax.swing.JLabel();
        lstFrecuenciasAeropuertoOrigen = new java.awt.List();
        lblVerFrecuenciasOrigen = new javax.swing.JLabel();
        btnAprobarOrigen = new javax.swing.JButton();
        btnRechazarOrigen = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lstFrecuenciasAeropuertoDestino = new java.awt.List();
        lblVerFrecuenciasDestino = new javax.swing.JLabel();
        btnAprobarDestino = new javax.swing.JButton();
        btnRechazarDestino = new javax.swing.JButton();
        btnPartidaVuelo = new javax.swing.JButton();
        btnLlegadaVuelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblUsuarioLogeado.setText("Nombre");

        lblVerFrecuenciasOrigen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVerFrecuenciasOrigen.setText("Frecuencias pendientes de origen");

        btnAprobarOrigen.setText("Aprobar");
        btnAprobarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarOrigenActionPerformed(evt);
            }
        });

        btnRechazarOrigen.setText("Rechazar");
        btnRechazarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarOrigenActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblVerFrecuenciasDestino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVerFrecuenciasDestino.setText("Frecuencias pendientes de destino");

        btnAprobarDestino.setText("Aprobar");
        btnAprobarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprobarDestinoActionPerformed(evt);
            }
        });

        btnRechazarDestino.setText("Rechazar");
        btnRechazarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarDestinoActionPerformed(evt);
            }
        });

        btnPartidaVuelo.setText("Partida de vuelo");
        btnPartidaVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidaVueloActionPerformed(evt);
            }
        });

        btnLlegadaVuelo.setText("Llegada de vuelo");
        btnLlegadaVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlegadaVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuarioLogeado)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPartidaVuelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLlegadaVuelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstFrecuenciasAeropuertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVerFrecuenciasOrigen)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAprobarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRechazarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAprobarDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRechazarDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblVerFrecuenciasDestino)
                            .addComponent(lstFrecuenciasAeropuertoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioLogeado)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVerFrecuenciasOrigen)
                    .addComponent(lblVerFrecuenciasDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lstFrecuenciasAeropuertoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(lstFrecuenciasAeropuertoDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAprobarOrigen)
                        .addComponent(btnRechazarOrigen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAprobarDestino)
                        .addComponent(btnRechazarDestino)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnPartidaVuelo)
                    .addComponent(btnLlegadaVuelo))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAprobarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarOrigenActionPerformed
        if(lstFrecuenciasAeropuertoOrigen.getItemCount() > 0) {
            int confirmarAccion = JOptionPane.showConfirmDialog(this, "Seguro deseas aprobar la frecuencia?");

            switch(confirmarAccion) {
                case 0: {
                    String frecuenciaSeleccionada = lstFrecuenciasAeropuertoOrigen.getSelectedItem();
                    String replace = frecuenciaSeleccionada.replace("min.", " ");
                    String[] f = replace.split(" - ");

                    controladorSistema.aprobarFrecuenciaOrigen(f, (Aeropuerto)this.usuarioLogeado.getTrabajo());
                    cargarFrecuenciasPendientesOrigen();
                }
                default: {
                    JOptionPane.getRootFrame().dispose();
                }
            }  
        }
    }//GEN-LAST:event_btnAprobarOrigenActionPerformed

    private void btnRechazarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarOrigenActionPerformed
        if(lstFrecuenciasAeropuertoOrigen.getItemCount() > 0) {
            int confirmarAccion = JOptionPane.showConfirmDialog(this, "Seguro deseas rechazar la frecuencia?");

            switch(confirmarAccion) {
                case 0: {
                    String frecuenciaSeleccionada = lstFrecuenciasAeropuertoOrigen.getSelectedItem();
                    String replace = frecuenciaSeleccionada.replace("min.", " ");
                    String[] f = replace.split(" - ");

                    controladorSistema.rechazarFrecuenciaOrigen(f, (Aeropuerto)this.usuarioLogeado.getTrabajo());
                    cargarFrecuenciasPendientesOrigen();
                }
                default: {
                    JOptionPane.getRootFrame().dispose();
                }
            }
        }
    }//GEN-LAST:event_btnRechazarOrigenActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        this.vistaMonitoreo.dispose();
        new VistaMenuAeropuerto(this.usuarioLogeado, this.vistaMonitoreo, this.vistaLogin).setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAprobarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprobarDestinoActionPerformed
        if(lstFrecuenciasAeropuertoDestino.getItemCount() > 0) {
            int confirmarAccion = JOptionPane.showConfirmDialog(this, "Seguro deseas aprobar la frecuencia?");

            switch(confirmarAccion) {
                case 0: {
                    String frecuenciaSeleccionada = lstFrecuenciasAeropuertoDestino.getSelectedItem();
                    String replace = frecuenciaSeleccionada.replace("min.", " ");
                    String[] f = replace.split(" - ");

                    controladorSistema.aprobarFrecuenciaDestino(f, (Aeropuerto)this.usuarioLogeado.getTrabajo());
                    cargarFrecuenciasPendientesDestino();
                }
                default: {
                    JOptionPane.getRootFrame().dispose();
                }
            }  
        }
    }//GEN-LAST:event_btnAprobarDestinoActionPerformed

    private void btnRechazarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarDestinoActionPerformed
        if(lstFrecuenciasAeropuertoDestino.getItemCount() > 0) {
            int confirmarAccion = JOptionPane.showConfirmDialog(this, "Seguro deseas rechazar la frecuencia?");

            switch(confirmarAccion) {
                case 0: {
                    String frecuenciaSeleccionada = lstFrecuenciasAeropuertoDestino.getSelectedItem();
                    String replace = frecuenciaSeleccionada.replace("min.", " ");
                    String[] f = replace.split(" - ");

                    controladorSistema.rechazarFrecuenciaDestino(f, (Aeropuerto)this.usuarioLogeado.getTrabajo());
                    cargarFrecuenciasPendientesDestino();
                }
                default: {
                    JOptionPane.getRootFrame().dispose();
                }
            }   
        }
    }//GEN-LAST:event_btnRechazarDestinoActionPerformed

    private void btnPartidaVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidaVueloActionPerformed
        dispose();
        new VistaIngresarPartidaVuelo(this.usuarioLogeado, this.vistaMonitoreo, this.vistaLogin).setVisible(true);
    }//GEN-LAST:event_btnPartidaVueloActionPerformed

    private void btnLlegadaVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlegadaVueloActionPerformed
        dispose();
        new VistaIngresarLlegadaVuelo(this.usuarioLogeado, this.vistaMonitoreo, this.vistaLogin).setVisible(true);
    }//GEN-LAST:event_btnLlegadaVueloActionPerformed

    public void cargarFrecuenciasPendientesOrigen() {
        lstFrecuenciasAeropuertoOrigen.removeAll();
        ArrayList<Frecuencia> frecuencias = controladorSistema.getListaFrecuenciasPendientesOrigen((Aeropuerto)this.usuarioLogeado.getTrabajo());
        
        for(Frecuencia f : frecuencias) {
            String dias = controladorSistema.getLetraDiasSemana(f);
            lstFrecuenciasAeropuertoOrigen.add(f.getCompañia().getNombre() + " - " + f.getNumero() + " - " + f.getAeropuertoDestino().getNombre() + " - " + dias + 
                    " - " + f.getHoraPartida() + " - " + f.getDuracionEstimada() + " min.");   
        }
        lstFrecuenciasAeropuertoOrigen.select(0);
    }
    
    public void cargarFrecuenciasPendientesDestino() {
        lstFrecuenciasAeropuertoDestino.removeAll();
        ArrayList<Frecuencia> frecuencias = controladorSistema.getListaFrecuenciasPendientesDestino((Aeropuerto)this.usuarioLogeado.getTrabajo());
        
        for(Frecuencia f : frecuencias) {
            String dias = controladorSistema.getLetraDiasSemana(f);
            lstFrecuenciasAeropuertoDestino.add(f.getCompañia().getNombre() + " - " + f.getNumero() + " - " + f.getAeropuertoOrigen().getNombre() + " - " + dias + 
                    " - " + f.getHoraPartida() + " - " + f.getDuracionEstimada() + " min.");   
        }
        lstFrecuenciasAeropuertoDestino.select(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprobarDestino;
    private javax.swing.JButton btnAprobarOrigen;
    private javax.swing.JButton btnLlegadaVuelo;
    private javax.swing.JButton btnPartidaVuelo;
    private javax.swing.JButton btnRechazarDestino;
    private javax.swing.JButton btnRechazarOrigen;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JLabel lblVerFrecuenciasDestino;
    private javax.swing.JLabel lblVerFrecuenciasOrigen;
    private java.awt.List lstFrecuenciasAeropuertoDestino;
    private java.awt.List lstFrecuenciasAeropuertoOrigen;
    // End of variables declaration//GEN-END:variables
}

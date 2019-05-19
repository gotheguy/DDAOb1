/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author gonzalo
 */
public class ControladorFrecuencia {
    private final IControladorFrecuencia IControladorFrecuencia;
    private final ArrayList<DiaSemana> listaDiasSemana = new ArrayList();
    
    public ControladorFrecuencia(IControladorFrecuencia IControladorFrecuencia) { 
        this.IControladorFrecuencia = IControladorFrecuencia;
    }
    
    public void agregarDiaSemana(DiaSemana diaSemana) {
        if (!listaDiasSemana.contains(diaSemana)) {
            this.listaDiasSemana.add(diaSemana);
        }
    }    
    
    public ArrayList<String> getListaDiasSemana() {
        ArrayList<String> diasSemana = new ArrayList();
        for (DiaSemana diaSemana : this.listaDiasSemana) {
            if(diaSemana != null) {
                diasSemana.add(diaSemana.name());
            }
        }
        return diasSemana;
    }
  
}

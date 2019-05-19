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
public interface IControladorFrecuencia {
    public void agregarDiaSemana(DiaSemana diaSemana);
    
    public ArrayList<String> getListaDiasSemana();
}

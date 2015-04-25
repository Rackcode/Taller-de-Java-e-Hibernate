/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.AlumnosController;
import javax.swing.JOptionPane;

/**
 *
 * @author Alonso Campos
 */
public class VistaAlumnos {
    public static void main(String[] args) {
        if(AlumnosController.AlumnosAdd("Alonso", "Campos", 23)==true){
            JOptionPane.showMessageDialog(null, "Se agrego registro");
        }
        
        if(AlumnosController.AlumnosUpdate(3,"Rackcode", "Asosociados", 23)==true){
            JOptionPane.showMessageDialog(null, "Se agrego actualizado");
        }
        
        if(AlumnosController.AlumnosDelete(3)==true){
            JOptionPane.showMessageDialog(null, "Se eliminado");
        }
    }
}

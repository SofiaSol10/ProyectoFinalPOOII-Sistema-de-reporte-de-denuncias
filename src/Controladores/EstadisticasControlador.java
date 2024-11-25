/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Vistas.EstadisticasVista;



/**
 *
 * @author Sofía
 */
public class EstadisticasControlador {
    private  EstadisticasVista V_Estadisticas;

    public EstadisticasControlador(EstadisticasVista V_Estadisticas) {
        this.V_Estadisticas = V_Estadisticas;
    }
    
    public EstadisticasVista mostrarVista(){
        return V_Estadisticas;
    }
    
}

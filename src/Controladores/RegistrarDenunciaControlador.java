/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.DenunciasModelo;
import Vistas.RegistrarDenunciaVista;

/**
 *
 * @author Sofía
 */
public class RegistrarDenunciaControlador {
    private RegistrarDenunciaVista Vregistrardenuncia;
    private DenunciasModelo dModelo;

    public RegistrarDenunciaControlador(RegistrarDenunciaVista Vregistrardenuncia, DenunciasModelo dm) {
        this.Vregistrardenuncia = Vregistrardenuncia;
        this.dModelo = dm;
    }
    
    public RegistrarDenunciaVista mostrarVista()
    {
        return Vregistrardenuncia;
    }
}

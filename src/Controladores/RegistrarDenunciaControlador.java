/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Denuncia;
import Vistas.RegistrarDenunciaVista;

/**
 *
 * @author Sofía
 */
public class RegistrarDenunciaControlador {
    private RegistrarDenunciaVista Vregistrardenuncia;
    private Denuncia dModelo;

    public RegistrarDenunciaControlador(RegistrarDenunciaVista Vregistrardenuncia, Denuncia dm) {
        this.Vregistrardenuncia = Vregistrardenuncia;
        this.dModelo = dm;
    }
    
    public RegistrarDenunciaVista mostrarVista()
    {
        return Vregistrardenuncia;
    }
}

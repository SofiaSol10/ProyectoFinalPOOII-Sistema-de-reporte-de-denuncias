/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.RegistrarDenunciaModelo;
import Vistas.RegistrarDenunciaVista;

/**
 *
 * @author Sofía
 */
public class RegistrarDenunciaControlador {
    private RegistrarDenunciaVista Vregistrardenuncia;
    private RegistrarDenunciaModelo Mregistrardenuncia;

    public RegistrarDenunciaControlador(RegistrarDenunciaVista Vregistrardenuncia, RegistrarDenunciaModelo Mregistrardenuncia) {
        this.Vregistrardenuncia = Vregistrardenuncia;
        this.Mregistrardenuncia = Mregistrardenuncia;
    }
    
    public RegistrarDenunciaVista mostrarVista()
    {
        return Vregistrardenuncia;
    }
}

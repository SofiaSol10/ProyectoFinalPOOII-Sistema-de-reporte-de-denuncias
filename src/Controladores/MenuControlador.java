/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.NoticiasModelo;
import Vistas.EstadisticasVista;
import Vistas.MenuVista;
import Vistas.NoticiasVista;
import Vistas.RegistrarDenunciaVista;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Sofía
 */
public class MenuControlador {
    private MenuVista Vmenu;
  
    public MenuControlador(MenuVista Vmenu) {
        this.Vmenu = Vmenu;
        
    }

    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Vmenu.getBTN_NOTICIAS_MENU())){
            try{
             
                NoticiasModelo Nmodelo = new NoticiasModelo();
                NoticiasVista Nvista = new NoticiasVista();
                NoticiasControlador Ncontrolador=new NoticiasControlador(Nmodelo,Nvista);
                Ncontrolador.mostrarVista().setVisible(true);
                
            }catch(Exception e){
                
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_REGISTRARDENUNCIA_MENU())){
            try{
             
                //RegistrarDenunciaModelo M_Rdenuncia = new RegistrarDenunciaModelo();
                RegistrarDenunciaVista V_Rdenuncia = new RegistrarDenunciaVista();
                //RegistrarDenunciaControlador C_Rdenuncia = new RegistrarDenunciaControlador(V_Rdenuncia,M_Rdenuncia);
                //C_Rdenuncia.mostrarVista().setVisible(true);
                
            }catch(Exception e){
                
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_VERDENUNCIA_MENU())){
            try{
             
               
            }catch(Exception e){
                
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_ESTADISTICAS_MENU())){
            try{
               EstadisticasVista V_Estadisticas = new EstadisticasVista();
               EstadisticasControlador C_Estadisticas = new EstadisticasControlador(V_Estadisticas);
               C_Estadisticas.mostrarVista().setVisible(true);
             
               
            }catch(Exception e){
                
            }
        }
        
    }
}

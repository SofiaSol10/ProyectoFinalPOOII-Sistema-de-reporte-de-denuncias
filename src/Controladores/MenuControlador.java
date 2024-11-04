/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.NoticiasModelo;
import Vistas.MenuVista;
import Vistas.NoticiasVista;
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
        
    }
}

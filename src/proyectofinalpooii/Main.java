/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalpooii;

import Controladores.MenuControlador;
import Vistas.MenuVista;

/**
 *
 * @author Sofía
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuVista V_menu = new MenuVista();
        MenuControlador C_menu = new MenuControlador(V_menu);
        
         C_menu.mostrarVista().setVisible(true);
    }
    
}

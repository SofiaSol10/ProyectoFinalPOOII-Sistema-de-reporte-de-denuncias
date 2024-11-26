/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.NoticiasModelo;
import Repositories.DenunciaRepository;
import Repositories.DistritoRepository;
import Service.DenunciaService;
import Service.DistritoService;
import Vistas.EstadisticasVista;
import Vistas.MenuVista;
import Vistas.NoticiasVista;
import Vistas.RegistrarDenunciaVista;
import Vistas.VerDenunciasVista;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

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
                e.printStackTrace();//detalles error
                JOptionPane.showMessageDialog(null, 
                "Error en mostrar sección Noticias", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_REGISTRARDENUNCIA_MENU())){
            try{
             
                DenunciaRepository denunciaRepository = new DenunciaRepository();
                DenunciaService denunciaService = new DenunciaService(denunciaRepository);
                DistritoRepository distritosRepository = new DistritoRepository();
                DistritoService distritosService = new DistritoService(distritosRepository);
                RegistrarDenunciaVista V_Rdenuncia = new RegistrarDenunciaVista();
                RegistrarDenunciaControlador C_Rdenuncia = new RegistrarDenunciaControlador(V_Rdenuncia,denunciaService,distritosService);
                C_Rdenuncia.mostrarVista().setVisible(true);
                
            }catch(Exception e){
                e.printStackTrace();//detalles error
                JOptionPane.showMessageDialog(null, 
                "Error en mostrar sección de Registro de Denuncias", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_VERDENUNCIA_MENU())){
            try{
               DenunciaRepository denunciaRepository = new DenunciaRepository();
               DenunciaService denunciaService = new DenunciaService(denunciaRepository);
               DistritoRepository distritosRepository = new DistritoRepository();
               DistritoService distritosService = new DistritoService(distritosRepository);
               VerDenunciasVista V_verDenuncia = new VerDenunciasVista();
               
               VerDenunciasControlador C_verDenuncias = new VerDenunciasControlador(V_verDenuncia,denunciaService,distritosService);
               C_verDenuncias.mostrarVista().setVisible(true);
               
            }catch(Exception e){
                e.printStackTrace();//detalles error
                JOptionPane.showMessageDialog(null, 
                "Error en mostrar la sección Ver Denuncias", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        if(ae.getSource().equals(Vmenu.getBTN_ESTADISTICAS_MENU())){
            try{
               EstadisticasVista V_Estadisticas = new EstadisticasVista();
               EstadisticasControlador C_Estadisticas = new EstadisticasControlador(V_Estadisticas);
               C_Estadisticas.mostrarVista().setVisible(true);
             
               
            }catch(Exception e){
                e.printStackTrace();//detalles error
                JOptionPane.showMessageDialog(null, 
                "Error en mostrar la sección Estadísticas", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        
    }
    public MenuVista mostrarVista(){
        return Vmenu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.NoticiasModelo;
import Vistas.NoticiasVista;
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofía
 */
public class NoticiasControlador {
    private NoticiasModelo Nmodelo;
    private NoticiasVista Nvista;

    public NoticiasControlador(NoticiasModelo Nmodelo, NoticiasVista Nvista) {
        this.Nmodelo = Nmodelo;
        this.Nvista = Nvista;
        mostrarTNoticias();
    }
    public void mostrarTNoticias(){
        Nmodelo.leerNoticia();
        List<String> listatitulos=Nmodelo.getTitulos();
        Nvista.getListaTitulosNoticias().setListData(listatitulos.toArray(new String[0]));//no me aceptaba list asi que tuve que agregarle .toArray(new String[0]) :c
    }
    
    public void visualizarImagenes(JLabel lbl, String ruta){
        lbl.setIcon(null);
        ImageIcon image = new ImageIcon(ruta);
        ImageIcon icon = new ImageIcon(
                image.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icon);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Nvista.getVerDetalles())){
            try{
                String tituloSeleccionado = Nvista.getListaTitulosNoticias().getSelectedValue();
                int index = Nvista.getListaTitulosNoticias().getSelectedIndex();
                List<String> titulos= Nmodelo.getTitulos();
                String ImgSeleccionado = Nmodelo.getImg().get(index);
                
                visualizarImagenes(Nvista.getLB_IMAGENES(),ImgSeleccionado);

            }catch(Exception e){
               JOptionPane.showMessageDialog(null, 
                "Error en mostrar detalles", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        
    }
    public NoticiasVista mostrarVista()
    {
        return Nvista;
    }
    
}

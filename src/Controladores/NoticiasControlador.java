/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.NoticiasModelo;
import Vistas.NoticiasVista;
import java.util.List;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Nvista.getVerDetalles())){
            try{
                String tituloSeleccionado = Nvista.getListaTitulosNoticias().getSelectedValue();
                int index = Nvista.getListaTitulosNoticias().getSelectedIndex();
                List<String> titulos= Nmodelo.getTitulos();
                String detallesSeleccionados = Nmodelo.getDescripciones().get(index);
                Nvista.getCuadroDescripcionNoticia().setText(tituloSeleccionado+"\n"+detallesSeleccionados );
                
                
                
            }catch(Exception e){
                
            }
        }
        
    }
    
}

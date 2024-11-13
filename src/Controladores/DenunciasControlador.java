/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Denuncia;
import java.util.ArrayList;
import java.util.List;
import Modelos.Denuncia;

/**
 *
 * @author USUARIO
 */
public class DenunciasControlador {
    
    public List<Denuncia> cargarDenunciasPorDistrito(int distritoId){
        
        List<String> fileList = new ArrayList<>();
        List<Denuncia> ld = new ArrayList<>();
        Denuncia dModel = new Denuncia();
        Denuncia d = new Denuncia();
        //fileList = dModel.; //MODEL
        
        for(int i=0; i < fileList.size(); i++){
                String txtLine = fileList.get(i);
                String[] parts = new String[0];
                parts = txtLine.split(",");
                
                String part1 = parts[0];
                String part2 = parts[1];
                String part3 = parts[2];
                String part4 = parts[3];
                String part5 = parts[4];
                String part6 = parts[5];
                String part7 = parts[6];
                String part8 = parts[7];
                String part9 = parts[8];
                
                if(part3.equals(distritoId)){
                    d.setFecha(part1);
                    d.setHora(part2);
                    d.setDistrito(Integer.parseInt(part3));
                    d.setLugarDesc(part4);
                    d.setEsAnonimo(part5.equals("TRUE")? true : false);
                    d.setNombre(part6);
                    d.setTipoDenu(part7);
                    d.setDenuDesc(part8);
                    d.setFoto(part9);
                    ld.add(d);
                }
            }
        
        return ld;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.DenunciasModelo;
import java.util.ArrayList;
import java.util.List;
import proyectofinalpooii.Denuncia;

/**
 *
 * @author USUARIO
 */
public class DenunciasController {
    
    public Denuncia cargarDenunciasPorDistrito(int distritoId){
        
        List<String> fileList = new ArrayList<>();
        DenunciasModelo dModel = new DenunciasModelo();
        Denuncia d = new Denuncia();
        fileList = dModel.listDenuncias(); //MODEL
        
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
                
                if(part1.equals(distritoId)){
                    //uc.setNombre(part1);
                    //uc.setCaloriasDesayuno(Integer.parseInt(part2));
                    //uc.setCaloriasAlmuerzo(Integer.parseInt(part3));
                    //uc.setCaloriasCena(Integer.parseInt(part4));
                    //uc.setTotalCalorias(Integer.parseInt(part5));
                    //uc.setEstadoConsumo(part6);
                    //uc.setRecomendacion(part7);
                }
            }
        
        return d;
    }
    
}

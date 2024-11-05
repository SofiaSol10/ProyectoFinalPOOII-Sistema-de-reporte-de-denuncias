/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DenunciasModelo {
    
    private static final String DIRECTORIO = "./src/proyectofinalpooii/";
    private static final String ARCHIVODENUNCIAS = "Denuncias.txt";
    
    public List<String> listDenuncias(){
        List<String> fileList = new ArrayList<>();
        
        try{
            //LEEMOS DENUNCIAS
            FileReader fr = new FileReader(DIRECTORIO+ARCHIVODENUNCIAS);
            BufferedReader br = new BufferedReader(fr);
            
            String d;
            while((d=br.readLine())!= null){
                    fileList.add(d);
            }
            br.close();
            
                                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return fileList;
    }
    
}

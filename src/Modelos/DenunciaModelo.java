/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Repositories.DenunciaRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DenunciaModelo implements DenunciaRepository<Denuncia>{
    
    private static final String DIRECTORIO = "./src/proyectofinalpooii/";
    private static final String ARCHIVODENUNCIAS = "Denuncias.txt";
    private String notice;

    @Override
    public void save(Denuncia d){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORIO, ARCHIVODENUNCIAS), true));
            writer.write(d.toString(), 0, d.toString().length());
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Denuncia findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Denuncia> findAll(){
        List<String> fileList = new ArrayList<>();
        List<Denuncia> listd = new ArrayList<>();
        
        try{
            //LEEMOS DENUNCIAS
            FileReader fr = new FileReader(DIRECTORIO + ARCHIVODENUNCIAS);
            BufferedReader br = new BufferedReader(fr);
            
            String d;
            while((d=br.readLine())!= null){
                    fileList.add(d);
            }
            br.close();
            
            Denuncia denuncia = new Denuncia();
        
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
                
                denuncia.setFecha(part1);
                denuncia.setHora(part2);
                denuncia.setDistrito(Integer.parseInt(part3));
                denuncia.setLugarDesc(part4);
                denuncia.setEsAnonimo(part5.equals("TRUE")? true : false);
                denuncia.setNombre(part6);
                denuncia.setTipoDenu(part7);
                denuncia.setDenuDesc(part8);
                denuncia.setFoto(part9);
                listd.add(denuncia);
            }
            
                                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return listd;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

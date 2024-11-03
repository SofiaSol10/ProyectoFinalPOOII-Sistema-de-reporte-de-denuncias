/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sofía
 */
public class NoticiasModelo {
    private List<String> titulos;
    private List<String> descripciones;
    
    public NoticiasModelo() {
        titulos = new ArrayList<>(); // Inicializar la lista
        descripciones = new ArrayList<>(); // Inicializar la lista
    }

    public List<String> getTitulos() {
        return titulos;
    }

    public void setTitulos(ArrayList<String> titulos) {
        this.titulos = titulos;
    }

    public List<String> getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(List<String> descripciones) {
        this.descripciones = descripciones;
    }
    

   

    
    public void leerNoticia(){
        
        try{
            FileReader fr=new FileReader("./src/proyectofinalpooii/Noticias.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!= null) {
                String[] partes = d.split("-", 2); 
                if (partes.length == 2) {
                    titulos.add(partes[0].trim());
                    descripciones.add(partes[1].trim());
                }
            }
            
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}

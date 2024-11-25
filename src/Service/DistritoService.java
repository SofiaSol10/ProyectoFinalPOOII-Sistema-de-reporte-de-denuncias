/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Modelos.Distrito;
import Repositories.DistritoRepository;
import java.util.List;

/**
 *
 * @author Sofía
 */
public class DistritoService {
    
    private final DistritoRepository distritoRepository;
    
    public DistritoService(DistritoRepository distritoRepository){
        this.distritoRepository = distritoRepository;
    }
    
    public List<Distrito> obtenerTodosLosDistritos() {
        return distritoRepository.findAll();
    }
    
    public int obtenerIdDistrito(String dName){
        
        return distritoRepository.findIdDistrito(dName);
    }
    
    public String obtenerNombreDistritoporID(int id){
        return distritoRepository.findNombreDistritoById(id);
    }
}
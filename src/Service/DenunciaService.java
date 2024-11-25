/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Modelos.Denuncia;
import Repositories.DenunciaRepository;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DenunciaService {
    
    private final DenunciaRepository denunciaRepository;
    
    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }
    
    public void guardarDenuncia(Denuncia d) {
        denunciaRepository.save(d);
    }

    public List<Denuncia> obtenerTodasLasDenuncias() {
        return denunciaRepository.findAll();
    }

    public Denuncia obtenerDenunciaPorId(int id) {
        return (Denuncia)denunciaRepository.findById(id);
    }

    public void eliminarDenuncia(int id) {
        denunciaRepository.deleteById(id);
    }
    
    
    
}

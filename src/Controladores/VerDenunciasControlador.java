/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Denuncia;
import Modelos.Distrito;
import Modelos.TipoDenuncias;
import Repositories.DenunciaRepository;
import Service.DenunciaService;
import Service.DistritoService;
import Utils.ImagesManager;
import Vistas.VerDenunciasVista;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofía
 */
public class VerDenunciasControlador {
    private VerDenunciasVista Vverdenuncia;
    private DenunciaService denunciaService;
    private DistritoService distritoService;

    public VerDenunciasControlador(VerDenunciasVista Vverdenuncia, DenunciaService denunciaService, DistritoService distritoService) {
        this.Vverdenuncia = Vverdenuncia;
        this.denunciaService = denunciaService;
        this.distritoService = distritoService;
    }

    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Vverdenuncia.getBTN_MOSTRARDETALLES())){
            int filaSeleccionada = Vverdenuncia.getTABLADENUNCIAS().getSelectedRow();
            if (filaSeleccionada != -1) {
                 int idDenuncia = (int) Vverdenuncia.getTABLADENUNCIAS().getValueAt(filaSeleccionada, 0); // El ID está en la primera columna 0

                // Obtener la denuncia completa usando el servicio
                 Denuncia denuncia = denunciaService.obtenerDenunciaPorId(idDenuncia);
                 Vverdenuncia.getLBL_NOMBRE().setText(denuncia.getNombre());
                 Vverdenuncia.getLBL_FECHA().setText(denuncia.getFecha().toString());
                 Vverdenuncia.getLBL_HORA().setText(denuncia.getHora().toString());
                 Vverdenuncia.getLBL_DISTRITO().setText(denuncia.getDistrito());
                 Vverdenuncia.getLBL_TIPODENUN().setText(denuncia.getTipoDenu());
                 Vverdenuncia.getTA_MOSTRARDESC_DENUN().setText(denuncia.getDenuDesc());
                 Vverdenuncia.getTA_MOSTRARDESC_LUGAR1().setText(denuncia.getLugarDesc());
                 ImagesManager im = new ImagesManager();
                 im.getImagefromBytes(denuncia.getFoto(), Vverdenuncia.getLB_MOSTRARFOTO());
                
            } else {
                JOptionPane.showMessageDialog(null, 
                "Por Favor Seleccione una opción de la tabla.", 
                "INDICACIÓN", 
                JOptionPane.ERROR_MESSAGE);
        }
    }  
        if(ae.getSource().equals(Vverdenuncia.getBTN_FILTRAR())){
            
            DenunciaRepository denRepository = new DenunciaRepository();
        DenunciaService denService = new DenunciaService(denRepository); 
        List<Denuncia> listaDenuncias = denService.obtenerTodasLasDenuncias();
         
        String distritoSeleccionado = Vverdenuncia.getCB_FILTARADISTRITO().getSelectedItem().toString();
        String tipoDenunciaSeleccionada = Vverdenuncia.getCB_FILTRARINCIDENCIA().getSelectedItem().toString() ;
        
            if (distritoSeleccionado.isEmpty() && !tipoDenunciaSeleccionada.isEmpty()) {
                List<Denuncia> denunciassegunTipo = listaDenuncias.stream()
                    .filter(denuncia -> tipoDenunciaSeleccionada.equalsIgnoreCase(denuncia.getTipoDenu()))
                    .collect(Collectors.toList());
                llenarTabla(denunciassegunTipo);
            }

            if (!distritoSeleccionado.isEmpty() && tipoDenunciaSeleccionada.isEmpty()) {
                List<Denuncia> denunciassegunDistrito = listaDenuncias.stream()
                    .filter(denuncia -> distritoSeleccionado.equalsIgnoreCase(denuncia.getDistrito()))
                    .collect(Collectors.toList());
                llenarTabla(denunciassegunDistrito);
            }

            if (!distritoSeleccionado.isEmpty() && !tipoDenunciaSeleccionada.isEmpty()) {
                List<Denuncia> denunciassegunDistritoYTipo = listaDenuncias.stream()
                    .filter(denuncia -> distritoSeleccionado.equalsIgnoreCase(denuncia.getDistrito())
                                     && tipoDenunciaSeleccionada.equalsIgnoreCase(denuncia.getTipoDenu()))
                    .collect(Collectors.toList());
                llenarTabla(denunciassegunDistritoYTipo);
            }
            if (distritoSeleccionado.isEmpty() && tipoDenunciaSeleccionada.isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                "Por Favor Seleccione las opciones de filtrado.", 
                "INDICACIÓN", 
                JOptionPane.ERROR_MESSAGE);
            }

        }
        if(ae.getSource().equals(Vverdenuncia.getBTN_QUITARFILTRO())){
            llenarTabla(denunciaService.obtenerTodasLasDenuncias());
        }
    }
    
    
    public void llenarTabla(List<Denuncia> denuncias) {
        DefaultTableModel modelo = new DefaultTableModel(
        new String[] {"ID", "Fecha", "Hora", "Distrito", "Tipo Denuncia", "Usuario"}, 0);

        for (Denuncia denuncia : denuncias) {
            modelo.addRow(new Object[]{
            denuncia.getId(),
            denuncia.getFecha(),
            denuncia.getHora(),
            denuncia.getDistrito(),
            denuncia.getTipoDenu(),
            denuncia.getNombre()
        });
    }

    Vverdenuncia.getTABLADENUNCIAS().setModel(modelo);
}
    public void llenarComboBoxDistritos(javax.swing.JComboBox<String> comboBox) {
        List<Distrito> distritos = distritoService.obtenerTodosLosDistritos();

        // Limpia el comboBox antes de llenarlo 
        comboBox.removeAllItems();

        // Agregar los elementos al comboBox
        comboBox.addItem("");
        for (Distrito distrito : distritos) {
            comboBox.addItem(distrito.getNombreDistrito());
        }
    }
    public void llenarComboBoxTipoDenuncias(javax.swing.JComboBox<String> comboBox){
        List<String> listaTipoDenuncias = Arrays.stream(TipoDenuncias.values())
                                            .map(Enum::name) // Extrae el nombre de cada enum
                                            .collect(Collectors.toList()); //Estamos convirtiendo los valores de Enum, TipoDenuncias a una losta para llenar wel combobox
        comboBox.removeAllItems();
        comboBox.addItem("");
        for (String TipoDenuncias : listaTipoDenuncias) {
            comboBox.addItem(TipoDenuncias);
        }
    }
    
    public VerDenunciasVista mostrarVista()
    {
        return Vverdenuncia;
    }
}
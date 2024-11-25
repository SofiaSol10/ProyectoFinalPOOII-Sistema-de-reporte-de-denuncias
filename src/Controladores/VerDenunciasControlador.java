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
                 Vverdenuncia.getLBL_DISTRITO().setText(distritoService.obtenerNombreDistritoporID(denuncia.getDistrito()));
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
            
       
        List<Denuncia> listaDenuncias = denunciaService.obtenerTodasLasDenuncias();
         
        String distritoSeleccionado = Vverdenuncia.getCB_FILTARADISTRITO().getSelectedItem().toString();
        int id_distritoSeleccionado=distritoSeleccionado.isEmpty() 
                                  ? -1 // Usamos -1 para indicar que no se seleccionó un distrito
                                  : distritoService.obtenerIdDistrito(distritoSeleccionado);
        String tipoDenunciaSeleccionada = Vverdenuncia.getCB_FILTRARINCIDENCIA().getSelectedItem().toString() ;
        
            if (id_distritoSeleccionado == -1 && !tipoDenunciaSeleccionada.isEmpty()) {
                    // Filtrar por tipo de denuncia únicamente
                    List<Denuncia> denunciasSegunTipo = listaDenuncias.stream()
                        .filter(denuncia -> tipoDenunciaSeleccionada.equalsIgnoreCase(denuncia.getTipoDenu()))
                        .collect(Collectors.toList());
                    llenarTabla(denunciasSegunTipo);
                }

            if (id_distritoSeleccionado != -1 && tipoDenunciaSeleccionada.isEmpty()) {
                    // Filtrar por distrito únicamente
                    List<Denuncia> denunciasSegunDistrito = listaDenuncias.stream()
                        .filter(denuncia -> denuncia.getDistrito() == id_distritoSeleccionado) // Comparar IDs directamente
                        .collect(Collectors.toList());
                    llenarTabla(denunciasSegunDistrito);
                }

            if (id_distritoSeleccionado != -1 && !tipoDenunciaSeleccionada.isEmpty()) {
                    // Filtrar por distrito y tipo de denuncia
                    List<Denuncia> denunciasSegunDistritoYTipo = listaDenuncias.stream()
                        .filter(denuncia -> denuncia.getDistrito() == id_distritoSeleccionado // Comparar IDs directamente
                                                 && tipoDenunciaSeleccionada.equalsIgnoreCase(denuncia.getTipoDenu()))
                        .collect(Collectors.toList());
                    llenarTabla(denunciasSegunDistritoYTipo);
                }

            if (id_distritoSeleccionado == -1 && tipoDenunciaSeleccionada.isEmpty()) {
                    // Mostrar mensaje de error si no se seleccionaron filtros
                    JOptionPane.showMessageDialog(null, 
                        "Por favor seleccione las opciones de filtrado.", 
                        "INDICACIÓN", 
                        JOptionPane.ERROR_MESSAGE);
                }

        }
        if(ae.getSource().equals(Vverdenuncia.getBTN_QUITARFILTRO())){
            llenarTabla(denunciaService.obtenerTodasLasDenuncias());
            Vverdenuncia.getCB_FILTARADISTRITO().setSelectedIndex(0);
            Vverdenuncia.getCB_FILTRARINCIDENCIA().setSelectedIndex(0);
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
            distritoService.obtenerNombreDistritoporID(denuncia.getDistrito()),
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
                                            .collect(Collectors.toList()); //Estamos convirtiendo los valores de Enum, TipoDenuncias a una lista para llenar wel combobox
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
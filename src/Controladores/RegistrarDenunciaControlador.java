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
import Vistas.RegistrarDenunciaVista;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofía
 */
public class RegistrarDenunciaControlador {
    private RegistrarDenunciaVista Vregistrardenuncia;
    private DenunciaService denunciaService;
    private DistritoService distritoService;
    byte[] imgEnBytes = null;

    public RegistrarDenunciaControlador(RegistrarDenunciaVista Vregistrardenuncia, DenunciaService denunciaService, DistritoService distritoService) {
        this.Vregistrardenuncia = Vregistrardenuncia;
        this.denunciaService = denunciaService;
        this.distritoService = distritoService;
    }
    

    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(Vregistrardenuncia.getBTN_CARGAR_FOTO())){
          
         JFileChooser file_upload = new JFileChooser();

        // Mostrar el diálogo de selección de archivo
        int res = file_upload.showOpenDialog(Vregistrardenuncia);

        // Si el usuario selecciona un archivo
        if (res == JFileChooser.APPROVE_OPTION) {
            File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());

            // Obtener el nombre del archivo
            String fileName = file_path.toString();

            // Crear una instancia de ImagesManager
            ImagesManager im = new ImagesManager();

            // Convertir la imagen a bytes para usarla posteriormente
            imgEnBytes = im.uploadImage(file_path);

            // Si la conversión a bytes fue exitosa
            if (imgEnBytes != null) {
                System.out.println("Imagen cargada y convertida a bytes desde: " + fileName);
            // Aquí puedes continuar con el procesamiento de la imagen en bytes
            } else {
                System.out.println("Error al convertir la imagen a bytes.");
            }
          } else {
            System.out.println("No se seleccionó ningún archivo.");
          }
        }
        
        
        if(ae.getSource().equals(Vregistrardenuncia.getBTN_REGISTRAR())){
            
         try{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaTexto =  Vregistrardenuncia.getFTF_FECHA().getText();
        LocalDate fecha;
        if (fechaTexto.matches("\\d{2}-\\d{2}-\\d{4}")) {
        fecha = LocalDate.parse(fechaTexto, formatter);
        }else{
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fecha.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, 
            "La fecha no puede ser mayor a la fecha actual.", 
            "Error de Validación", 
            JOptionPane.ERROR_MESSAGE);
            return;
            }
        String selectedHour = (String) Vregistrardenuncia.getCB_HORA_1().getSelectedItem();
        String selectedMinute = (String) Vregistrardenuncia.getCB_HORA_2().getSelectedItem();
        String HoraString = selectedHour+":"+selectedMinute;
        LocalTime hora;
        try {
            hora = LocalTime.parse(HoraString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Debe ser HH:mm.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String distritoseleccionado = Vregistrardenuncia.getCBOX_DISTRITOS().getSelectedItem().toString();
        int id_distrito=distritoService.obtenerIdDistrito(distritoseleccionado);
        String lugarDesc = Vregistrardenuncia.getTXT_DESC_LUGAR().getText();
        if (lugarDesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
            "La descripción del lugar de los hechos no puede estar vacía.", 
            "Error de Validación", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean esAnonimo=true;//esta marcado como SI predeterminadamente
        if (Vregistrardenuncia.getRB_SI().isSelected()) {
            esAnonimo = true; // Usuario seleccionó anonimato
          } else if (Vregistrardenuncia.getRB_NO().isSelected()) {
            esAnonimo = false; // Usuario no seleccionó anonimato
          }
        String nombre;
        if (esAnonimo==false) {
            nombre = Vregistrardenuncia.getTXT_NOMBREUSUARIO().getText(); 
        } else {
            nombre = "Anonimo";
        }
        String tipoDenu =Vregistrardenuncia.getCBOX_TIPODENUNCIAS().getSelectedItem().toString();
        String denuDesc = Vregistrardenuncia.getTXT_DESC_DENUN().getText();
        if (denuDesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
            "La descripción  de la denuncia no puede estar vacía.", 
            "Error de Validación", 
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        byte[] foto = imgEnBytes;
        Denuncia denuncia = new Denuncia.DenunciaBuilder()
                .setFecha(fecha)
                .setHora(hora)
                .setDistrito(id_distrito)
                .setLugarDesc(lugarDesc)
                .setEsAnonimo(esAnonimo)
                .setNombre(nombre)
                .setTipoDenu(tipoDenu)
                .setDenuDesc(denuDesc)
                .setFoto(foto)
                .build();
        denunciaService.guardarDenuncia(denuncia);
        JOptionPane.showMessageDialog(null, 
        "La Denuncia se registro con éxito, podrá visualizarlo en la sección Ver Denuncias.", 
        "Éxito", 
        JOptionPane.INFORMATION_MESSAGE);
        Vregistrardenuncia.limpiarCampos();
        
        }catch(Exception e){
            e.printStackTrace();//detalles error
           JOptionPane.showMessageDialog(null, 
        "Ocurrió un error, no se puede registrar la denuncia.", 
        "Error", 
        JOptionPane.ERROR_MESSAGE);
        return;
        }

       }
    }
 
    
    
    public void llenarComboBoxDistritos(javax.swing.JComboBox<String> comboBox) {
        List<Distrito> distritos = distritoService.obtenerTodosLosDistritos();

        // Limpia el comboBox antes de llenarlo 
        comboBox.removeAllItems();

        // Agregar los elementos al comboBox
        for (Distrito distrito : distritos) {
            comboBox.addItem(distrito.getNombreDistrito());
        }
    }
    public void llenarComboBoxTipoDenuncias(javax.swing.JComboBox<String> comboBox){
        List<String> listaTipoDenuncias = Arrays.stream(TipoDenuncias.values())
                                            .map(Enum::name) // Extrae el nombre de cada enum
                                            .collect(Collectors.toList()); //Estamos convirtiendo los valores de Enu, TipoDenuncias a una losta para llenar wel combobox
        comboBox.removeAllItems();
        for (String TipoDenuncias : listaTipoDenuncias) {
            comboBox.addItem(TipoDenuncias);
        }
    }
    
     public void llenarComboBoxHora1(javax.swing.JComboBox<String> comboBox) {
         for (int i = 0; i < 24; i++) {
            comboBox.addItem(String.format("%02d", i));  // Formato de 2 dígitos
            }
     }
     
     public void llenarComboBoxHora2(javax.swing.JComboBox<String> comboBox) {
         for (int i = 0; i < 60; i++) {
            comboBox.addItem(String.format("%02d", i));  // Formato de 2 dígitos
            }

     }
     
    
     
    public RegistrarDenunciaVista mostrarVista()
    {
        return Vregistrardenuncia;
    }
}

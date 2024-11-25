/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class ImagesManager {
    
   public static byte[] uploadImage(File sourceFile) {
        try {
            // Convertir el archivo a byte[] sin moverlo a otro directorio
            byte[] imageBytes = getBytesFromFile(sourceFile);
            return imageBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] getBytesFromFile(File file) throws IOException {
        // Leer el archivo y convertirlo a byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
        }
        return baos.toByteArray();
    }
    
    public void getImagefromBytes(byte[] fotoBytes, JLabel label) {
        try {
            // Convertir el byte[] a un InputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(fotoBytes);
            
            // Leer la imagen usando ImageIO
            Image imagen = ImageIO.read(bais);
            
            // Redimensionar la imagen (opcional, para que se ajuste al JLabel)
            Image imagenRedimensionada = imagen.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            
            // Crear un ImageIcon a partir de la imagen
            ImageIcon icon = new ImageIcon(imagenRedimensionada);
            
            // Asignar el icono al JLabel
            label.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar la imagen en el JLabel.");
        }
    }
}

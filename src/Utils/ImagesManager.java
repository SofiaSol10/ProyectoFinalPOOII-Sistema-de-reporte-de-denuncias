/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 *
 * @author USUARIO
 */
public class ImagesManager {
    
    public static byte[] uploadImage(File sourceFile) {
        String newPath = "uploads/images/";
        
        // Generar un nombre único para la imagen
        String extension = sourceFile.getName().substring(sourceFile.getName().lastIndexOf('.') + 1);
        String uniqueName = "image_" + UUID.randomUUID().toString() + "." + extension;
        File destinationFile = new File(newPath + uniqueName);
        
        try {
            // Copiar el archivo a la nueva ubicación
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
            
            // Convertir el archivo a byte[]
            byte[] imageBytes = getBytesFromFile(destinationFile);
            
            
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
    
}

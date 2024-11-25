/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Modelos.Denuncia;
import Utils.DataBaseConnectionManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sofía
 */
public class DenunciaRepository{
    DataBaseConnectionManager DBCM = new DataBaseConnectionManager();
   

    // Crear una denuncia
    public Denuncia save(Denuncia denuncia) {
        String sql = "INSERT INTO denuncias " +
            "(fecha, hora, distrito, lugarDesc, esAnonimo, nombre, tipoDenu, denuDesc, foto) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBCM.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setDate(1, Date.valueOf(denuncia.getFecha()));
            stmt.setTime(2, Time.valueOf(denuncia.getHora()));
            stmt.setString(3, denuncia.getDistrito());
            stmt.setString(4, denuncia.getLugarDesc());
            stmt.setBoolean(5, denuncia.isEsAnonimo());
            stmt.setString(6, denuncia.getNombre());
            stmt.setString(7, denuncia.getTipoDenu());
            stmt.setString(8, denuncia.getDenuDesc());
           //Inserting Blob type
            byte[] foto = denuncia.getFoto();
                if (foto != null && foto.length > 0) {
                // Si la foto no es null ni vacía, se inserta como un BLOB
                InputStream in = new ByteArrayInputStream(foto);
                stmt.setBlob(9, in);
            } else {
                // Si la foto es null o vacía, se inserta NULL en el campo foto
                stmt.setNull(9, java.sql.Types.BLOB);
            }
            stmt.executeUpdate();
            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    denuncia.setId(generatedKeys.getInt(1));
                }
            }
            
            
            return denuncia;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar denuncia", e);
        }
    }

    // Buscar todas las denuncias
    public List<Denuncia> findAll() {
        List<Denuncia> denuncias = new ArrayList<>();
        String sql = "SELECT * FROM denuncias";
        
        try (Connection conn = DBCM.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                denuncias.add(new Denuncia.DenunciaBuilder()
                    .setId(rs.getInt("id"))
                    .setFecha(rs.getDate("fecha").toLocalDate())
                    .setHora(rs.getTime("Hora").toLocalTime())
                    .setDistrito(rs.getString("distrito"))
                    .setLugarDesc(rs.getString("lugarDesc"))
                    .setEsAnonimo(rs.getBoolean("esAnonimo"))
                    .setNombre(rs.getString("nombre"))
                    .setTipoDenu(rs.getString("tipoDenu"))
                    .setDenuDesc(rs.getString("denuDesc"))
                    .setFoto(rs.getBytes("foto"))
                     .build());
                    
                
               
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar denuncias", e);
        }
        
        return denuncias;
    }

    // Buscar por ID
    public Denuncia findById(int id) {
        String sql = "SELECT * FROM denuncias WHERE id = ?";
        
        try (Connection conn = DBCM.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   return new Denuncia.DenunciaBuilder()
                      .setId(rs.getInt("id"))
                    .setFecha(rs.getDate("fecha").toLocalDate())
                    .setHora(rs.getTime("Hora").toLocalTime())
                    .setDistrito(rs.getString("distrito"))
                    .setLugarDesc(rs.getString("lugarDesc"))
                    .setEsAnonimo(rs.getBoolean("esAnonimo"))
                    .setNombre(rs.getString("nombre"))
                    .setTipoDenu(rs.getString("tipoDenu"))
                    .setDenuDesc(rs.getString("denuDesc"))
                    .setFoto(rs.getBytes("foto"))
                     .build();     
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar denuncia", e);
        }
        
        return null;
    }

    // Eliminar por ID
    public void deleteById(int id) {
        String sql = "DELETE FROM denuncias WHERE id = ?";
        
        try (Connection conn = DBCM.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar denuncia", e);
        }
    }
    
    
}

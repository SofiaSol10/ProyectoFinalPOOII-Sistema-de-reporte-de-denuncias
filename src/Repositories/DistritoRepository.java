/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

/**
 *
 * @author Sofía
 */
import Modelos.Denuncia;
import Modelos.Distrito;
import Utils.DataBaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DistritoRepository {
    DataBaseConnectionManager DBCM = new DataBaseConnectionManager();
    public List<Distrito> findAll() {
        List<Distrito> distrito = new ArrayList<>();
        try (Connection conn = DBCM.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM DISTRITOS");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                distrito.add(new Distrito.DistritoBuilder()
                        .setId(resultSet.getInt("id"))
                        .setNombreDistrito(resultSet.getString("nombreDistrito"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving DISTRITOS", e);
        }
        return distrito;
    }
    public int findIdDistrito(String dName){
        List<Distrito> ld = findAll();
        int idDistrito = ld.stream()
            .filter(d -> d.getNombreDistrito().equalsIgnoreCase(dName))
            .map(Distrito::getId)
            .findFirst()
                .orElse(1);
        return idDistrito;
    }
    
    public String findNombreDistritoById(int id) {
        String nombreDistrito = null;
        try (Connection conn = DBCM.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT nombreDistrito FROM DISTRITOS WHERE id = ?");
            pstmt.setInt(1, id); // Asignar el parámetro ID ...el 1 es un indice del marcador de posición se refiere a la posición del signo de interrogación (?)del query
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                nombreDistrito = resultSet.getString("nombreDistrito");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving Distrito name by ID", e);
        }
        return nombreDistrito;
    }
}


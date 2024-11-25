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
}


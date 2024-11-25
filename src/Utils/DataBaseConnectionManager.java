/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sofía
 */
public class DataBaseConnectionManager {
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sistemadenuncias?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", 
                "root", 
                "143143"
            );
        } catch (Exception e) {
            throw new RuntimeException("Error de conexión a base de datos", e);
        }
    }
}

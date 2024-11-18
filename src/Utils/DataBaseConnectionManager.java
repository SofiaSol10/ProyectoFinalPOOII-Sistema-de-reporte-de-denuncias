/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class DataBaseConnectionManager {
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "daynine";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3307/commissarbd";
    private static Connection con = null;
    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            con = (Connection) DriverManager.getConnection(url, user, pass);
        }
        return con;
    }
    
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Repositories.DenunciaRepository;
import Utils.DataBaseConnectionManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DenunciaModelo implements DenunciaRepository<Denuncia>{

    @Override
    public void save(Denuncia d){
        try(Connection conn = DataBaseConnectionManager.getConnection()){
            // TODO add your handling code here:
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DENUNCIAS (id,fecha,hora,distrito,lugarDesc,esAnonimo,nombre,tipoDenuncia,descDenuncia,foto) VALUES(?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 0);
            pstmt.setString(2, d.getFecha());
            pstmt.setString(3, d.getHora());
            pstmt.setInt(4, d.getDistrito());
            pstmt.setString(5, d.getLugarDesc());
            pstmt.setBoolean(6, d.getEsAnonimo());
            pstmt.setString(7, d.getNombre());
            pstmt.setString(8, d.getTipoDenu());
            pstmt.setString(9, d.getDenuDesc());
            //Inserting Blob type
            InputStream in = new ByteArrayInputStream(d.getFoto());
            System.out.println("ESTA ES LA RUTA QUE SE GUARDA EN EL MEDIUM BLOB " + in.getClass().getName());
            pstmt.setBlob(10, in);
            //Executing the statement
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Denuncia findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Denuncia> findAll(){
        List<Denuncia> listd = new ArrayList<>();
        
        try(Connection conn = DataBaseConnectionManager.getConnection()){
            String query = "SELECT * FROM DENUNCIAS";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Denuncia d = new Denuncia();
                d.setId(rs.getInt("id"));
                d.setFecha(rs.getString("fecha"));
                d.setHora(rs.getString("hora"));
                d.setDistrito(rs.getInt("distrito"));
                d.setLugarDesc(rs.getString("lugatDesc"));
                d.setEsAnonimo(rs.getBoolean("esAnonimo"));
                d.setNombre(rs.getString("nombre"));
                d.setTipoDenu(rs.getString("tipoDenuncia"));
                d.setDenuDesc(rs.getString("descDenuncia"));
                d.setFoto(rs.getBytes("foto"));
                listd.add(d);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listd;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

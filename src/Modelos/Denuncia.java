/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author USUARIO
 */
public class Denuncia {
    
    private int id;
    private String fecha;
    private String hora;
    private int distrito;
    private String lugarDesc;
    private boolean esAnonimo;
    private String nombre;
    private String tipoDenu;
    private String denuDesc;
    private byte[] foto;

    public Denuncia() {
    }

    public Denuncia(int id, String fecha, String hora, int distrito, String lugarDesc, boolean esAnonimo, String nombre, String tipoDenu, String denuDesc, byte[] foto) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.distrito = distrito;
        this.lugarDesc = lugarDesc;
        this.esAnonimo = esAnonimo;
        this.nombre = nombre;
        this.tipoDenu = tipoDenu;
        this.denuDesc = denuDesc;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getLugarDesc() {
        return lugarDesc;
    }

    public void setLugarDesc(String lugarDesc) {
        this.lugarDesc = lugarDesc;
    }

    public boolean getEsAnonimo() {
        return esAnonimo;
    }
    
    public void setEsAnonimo(boolean esAnonimo) {
        this.esAnonimo = esAnonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDenu() {
        return tipoDenu;
    }

    public void setTipoDenu(String tipoDenu) {
        this.tipoDenu = tipoDenu;
    }

    public String getDenuDesc() {
        return denuDesc;
    }

    public void setDenuDesc(String denuDesc) {
        this.denuDesc = denuDesc;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Sofía
 */
public class Distrito {
    private int id;
    private String nombreDistrito;

    public Distrito(int id, String nombreDistrito) {
        this.id = id;
        this.nombreDistrito = nombreDistrito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
    
    
    
}

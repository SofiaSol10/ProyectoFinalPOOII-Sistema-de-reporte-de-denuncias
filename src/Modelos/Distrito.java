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

    public Distrito() {
    }

    public Distrito(int id, String nombreDistrito) {
        this.id = id;
        this.nombreDistrito = nombreDistrito;
    }
    
    private Distrito(DistritoBuilder builder){
        this.id = builder.id;
        this.nombreDistrito = builder.nombreDistrito;
    }
    
    public static class DistritoBuilder {
        private int id;
        private String nombreDistrito;
        
        public DistritoBuilder setId(int id){
            this.id = id;
            return this;
        }
        
        public DistritoBuilder setNombreDistrito(String nombreDistrito){
            this.nombreDistrito = nombreDistrito;
            return this;
        }
        
        public Distrito build(){
            if (nombreDistrito == null) {
                throw new IllegalArgumentException("Campo nombre es requerido");
            }
            return new Distrito(this);
        }
        
    }

    public int getId() {
        return id;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }
    
}

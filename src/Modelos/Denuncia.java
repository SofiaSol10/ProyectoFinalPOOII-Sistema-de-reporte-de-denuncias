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
import java.time.LocalDate;
import java.time.LocalTime;

public class Denuncia {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private int distrito;
    private String lugarDesc;
    private boolean esAnonimo;
    private String nombre;
    private String tipoDenu;
    private String denuDesc;
    private byte[] foto;

    // Constructor privado para el patrón Builder
    private Denuncia(DenunciaBuilder builder) {
        this.id = builder.id;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.distrito = builder.distrito;
        this.lugarDesc = builder.lugarDesc;
        this.esAnonimo = builder.esAnonimo;
        this.nombre = builder.nombre;
        this.tipoDenu = builder.tipoDenu;
        this.denuDesc = builder.denuDesc;
        this.foto = builder.foto;
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getDistrito() {
        return distrito;
    }

    public String getLugarDesc() {
        return lugarDesc;
    }

    public boolean isEsAnonimo() {
        return esAnonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDenu() {
        return tipoDenu;
    }

    public String getDenuDesc() {
        return denuDesc;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public void setLugarDesc(String lugarDesc) {
        this.lugarDesc = lugarDesc;
    }

    public void setEsAnonimo(boolean esAnonimo) {
        this.esAnonimo = esAnonimo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDenu(String tipoDenu) {
        this.tipoDenu = tipoDenu;
    }

    public void setDenuDesc(String denuDesc) {
        this.denuDesc = denuDesc;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    

    
    
    
    @Override
    public String toString() {
        return "Denuncia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", distrito='" + distrito + '\'' +
                ", lugarDesc='" + lugarDesc + '\'' +
                ", esAnonimo=" + esAnonimo +
                ", nombre='" + nombre + '\'' +
                ", tipoDenu='" + tipoDenu + '\'' +
                ", denuDesc='" + denuDesc + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }


    public static class DenunciaBuilder {
        private int id;
        private LocalDate fecha;
        private LocalTime hora;
        private int distrito;
        private String lugarDesc;
        private boolean esAnonimo;
        private String nombre;
        private String tipoDenu;
        private String denuDesc;
        private byte[] foto;

        public DenunciaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public DenunciaBuilder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public DenunciaBuilder setHora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        public DenunciaBuilder setDistrito(int distrito) {
            this.distrito = distrito;
            return this;
        }

        public DenunciaBuilder setLugarDesc(String lugarDesc) {
            this.lugarDesc = lugarDesc;
            return this;
        }

        public DenunciaBuilder setEsAnonimo(boolean esAnonimo) {
            this.esAnonimo = esAnonimo;
            return this;
        }

        public DenunciaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public DenunciaBuilder setTipoDenu(String tipoDenu) {
            this.tipoDenu = tipoDenu;
            return this;
        }

        public DenunciaBuilder setDenuDesc(String denuDesc) {
            this.denuDesc = denuDesc;
            return this;
        }

        public DenunciaBuilder setFoto(byte[] foto) {
            this.foto = foto;
            return this;
        }

        public Denuncia build() {
            return new Denuncia(this);
        }
    }
}

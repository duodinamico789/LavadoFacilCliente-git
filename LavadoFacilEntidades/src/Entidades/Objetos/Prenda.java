package Entidades.Objetos;

import java.io.Serializable;
import java.util.List;

public class Prenda implements Serializable {
    private int idpda;
    private String tipo;
    private boolean aplicaTint;
    private List<Excepcion> excepcionesList;

    public Prenda() {
    }

    public Prenda(String tipo, boolean aplicaTint) {
        this.tipo = tipo;
        this.aplicaTint = aplicaTint;
    }

    public Prenda(int idPda, String tipo, boolean aplicaTint) {
        this.idpda = idPda;
        this.tipo = tipo;
        this.aplicaTint = aplicaTint;
    }

    public void setIdpda(int idpda) {
        this.idpda = idpda;
    }
    
    public int getIdpda() {
        return idpda;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getTintoreria() {
        return aplicaTint;
    }

    public void setTintoreria(boolean tintoreria) {
        this.aplicaTint = tintoreria;
    }

    public List<Excepcion> getExcepcionesList() {
        return excepcionesList;
    }

    public void setExcepcionesList(List<Excepcion> excepcionesList) {
        this.excepcionesList = excepcionesList;
    }

    
    @Override
    public String toString() {
        return "Entidades.Objetos2.Prendas[ tipo=" + tipo + " ]";
    }
    
}

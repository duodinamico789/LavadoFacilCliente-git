package Entidades.Objetos;

import java.io.Serializable;
import java.util.List;

public class Excepcion implements Serializable {
    private int id;
    private String nombre;
    private List<Prenda> prendasList;

    public Excepcion() {
    }

    public Excepcion(String nombre) {
        this.nombre = nombre;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Prenda> getPrendasList() {
        return prendasList;
    }

    public void setPrendasList(List<Prenda> prendasList) {
        this.prendasList = prendasList;
    }
}

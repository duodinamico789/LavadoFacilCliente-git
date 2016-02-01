package Entidades.Objetos;
import java.math.BigDecimal;
import java.io.Serializable;

public class Opcion implements Serializable {
    private int idOpcion;
    private String nombre;
    private BigDecimal precio;
    //private List<Solicitudes> solicitudesList;

    public Opcion() {
    }

    public Opcion(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public int getidOpcion() {
        return idOpcion;
    }
    
    public void setidOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }*/


    @Override
    public String toString() {
        return "Entidades.Objetos2.Opciones[ nombre=" + nombre + " ]";
    }
    
}

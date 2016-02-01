package Entidades.Objetos;

import java.io.Serializable;
import java.math.BigDecimal;

public class SolicitudDetalle implements Serializable {
    private Prenda prenda;
    private BigDecimal precio;
    private int cantidad;
    private String descripcion;
    private int linea;
    private int id;
    private Solicitud idSol;

    public SolicitudDetalle() {
    }

    public SolicitudDetalle(String descripcion) {
        this.descripcion = descripcion;
    }

    public SolicitudDetalle(String descripcion, BigDecimal precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Solicitud getIdSol() {
        return idSol;
    }

    public void setIdSol(Solicitud idSol) {
        this.idSol = idSol;
    }
    
    
    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getLinea() {
        return linea;
    }
    
    public void setPrecio(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Entidades.Objetos2.Ticketdetalles[ descripcion=" + descripcion + " ]";
    }
    
}

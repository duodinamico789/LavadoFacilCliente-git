package Entidades.Objetos;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;

public class Tintoreria implements Serializable {
    private int idTint; 
    private String nombre;
    private String telefono;
    private List<Sucursal> sucursalCercana;
    private Ubicacion ubicacion;
    
    public Tintoreria()
    {    
    }
    public Tintoreria(String nombre, String telefono, List<Sucursal> sucursalCercana, Ubicacion ubicacion, BigDecimal AcolchadoP, BigDecimal PantalonP, BigDecimal AcolchadoW, BigDecimal Gabanes, BigDecimal Traje, BigDecimal Frazada,
            BigDecimal PantalonV, BigDecimal Saco, BigDecimal Gabardinas, BigDecimal Tapado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sucursalCercana = sucursalCercana;
        this.ubicacion = ubicacion;
    }

    public void setIdTint(int idTint) {
        this.idTint = idTint;
    }

    public int getIdTint() {
        return idTint;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Sucursal> getSucursalCercana() {
        return sucursalCercana;
    }

    public void setSucursalCercana(List<Sucursal> _sucursalCercana) {
        this.sucursalCercana = _sucursalCercana;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion _ubicacion) {
        this.ubicacion = _ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tintoreria)) {
            return false;
        }
        Tintoreria other = (Tintoreria) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Objetos2.Tintorerias[ nombre=" + nombre + " ]";
    }

    
}

package Entidades.Objetos;

import java.io.Serializable;
import java.util.List;

public class Sucursal implements Serializable {
    private int idSuc;
    private String nombreSuc;
    private String telefono;
    private List<Movimiento> contabilidadesList;
    private Ubicacion ubicacion;

    public Sucursal() {
    }

    public Sucursal(String nombreSuc,String telefono) {
        this.nombreSuc = nombreSuc;
        this.telefono = telefono;
    }

    public Sucursal(int idSuc, String nombreSuc, String telefono) {
        this.idSuc = idSuc;
        this.nombreSuc = nombreSuc;
        this.telefono = telefono;
    }

    public void setIdSuc(int idSuc) {
        this.idSuc = idSuc;
    }

    public int getIdSuc() {
        return idSuc;
    }
    
    public String getNombreSuc() {
        return nombreSuc;
    }

    public void setNombreSuc(String nombreSuc) {
        this.nombreSuc = nombreSuc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Movimiento> getContabilidadesList() {
        return contabilidadesList;
    }

    public void setContabilidadesList(List<Movimiento> contabilidadesList) {
        this.contabilidadesList = contabilidadesList;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreSuc != null ? nombreSuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.nombreSuc == null && other.nombreSuc != null) || (this.nombreSuc != null && !this.nombreSuc.equals(other.nombreSuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Objetos2.Sucursales[ nombreSuc=" + nombreSuc + " ]";
    }
    
}

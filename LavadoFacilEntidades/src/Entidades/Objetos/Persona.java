package Entidades.Objetos;
import java.util.Date;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    
    private String cedula;
    private String passw;
    private String nombre;
    private String telefono;
    private String celular;
    private Date fechaOlvidoPass;
    private Ubicacion ubicacion;

    public Persona() {
    }

    public Persona(String cedula) {
        this.cedula = cedula;
    }

    public Persona(String cedula, String passw, String nombre, String telefono, String celular) {
        this.cedula = cedula;
        this.passw = passw;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public Date getfechaOlvidoPass() {
        return fechaOlvidoPass;
    }

    public void setfechaOlvidoPass(Date fechaOlvidoPass) {
        this.fechaOlvidoPass = fechaOlvidoPass;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    @Override
    public String toString() {
        return "Entidades.Objetos2.Personas[ cedula=" + cedula + " ]";
    }
    
}

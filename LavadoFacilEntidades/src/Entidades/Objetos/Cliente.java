package Entidades.Objetos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona implements Serializable {
    private Date fechareg;
    private Date fechaUltimaEntrada;
    private List<Solicitud> solicitudesList;

    public Cliente() {
    }

    public Cliente(String cedula) {
        super(cedula);
    }

    public Cliente(String cedula, String passw, String nombre, String telefono, String celular,
            Date fechareg, Date fechaUltimaEntrada) {
        super(cedula,passw,nombre,telefono,celular);
        this.fechareg = fechareg;
        this.fechaUltimaEntrada = fechaUltimaEntrada;
    }

    public Date getfechareg() {
        return fechareg;
    }

    public void setfechareg(Date fechareg) {
        this.fechareg = fechareg;
    }
    
    public Date getfechaUltimaEntrada() {
        return fechaUltimaEntrada;
    }

    public void setfechaUltimaEntrada(Date fechaUltimaEntrada) {
        this.fechaUltimaEntrada = fechaUltimaEntrada;
    }

    public List<Solicitud> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitud> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

}

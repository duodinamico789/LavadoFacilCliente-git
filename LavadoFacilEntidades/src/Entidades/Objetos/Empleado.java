package Entidades.Objetos;

import Entidades.Enumeraciones.TipoEmpleado;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Empleado extends Persona implements Serializable {
    private BigDecimal sueldo;
    private Date fechaIngreso;
    private Entidades.Enumeraciones.TipoEmpleado tipoEmpleado;
    private Entidades.Objetos.Sucursal suc;

    public Empleado() {
    }

    public Empleado(String cedula) {
        super(cedula);
    }

    public Empleado(String cedula, String passw, String nombre, String telefono, String celular, 
            BigDecimal sueldo, Date fechaIngreso, Entidades.Enumeraciones.TipoEmpleado tipoEmpleado,
            Entidades.Objetos.Sucursal suc) {
        super(cedula,passw,nombre,telefono,celular);
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
        this.tipoEmpleado = tipoEmpleado;
        this.suc = suc;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Entidades.Enumeraciones.TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(Entidades.Enumeraciones.TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
    public Entidades.Objetos.Sucursal getSucursal() {
        return suc;
    }

    public void setSucursal(Entidades.Objetos.Sucursal suc) {
        this.suc = suc;
    } 
}

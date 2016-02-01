package Entidades.Objetos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import Entidades.Enumeraciones.EstadosSolicitud;

public class Solicitud implements Serializable {
    private Integer id;
    private Date fechaIngreso;
    private String observaciones;
    private Date fechaEntrega;
    private List<Opcion> opcionesList;
    private Cliente cliente;
    private Empleado empleado;
    private EstadosSolicitud estado;
    private boolean conDelivery;
    private BrechaHoraria brechaHoraria;
    private List<Prenda> prendas;
    private List<SolicitudDetalle> detalles;
    private Sucursal suc;

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, Date fechaIngreso, String observaciones, Date fechaEntrega) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.fechaEntrega = fechaEntrega;
    }

    public boolean getDelivery() {
        return conDelivery;
    }

    public void setDelivery(boolean delivery) {
        this.conDelivery = delivery;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<Opcion> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<Opcion> opcionesList) {
        this.opcionesList = opcionesList;
    }

    public EstadosSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadosSolicitud estado) {
        this.estado = estado;
    }

    public Cliente getCedulaCli() {
        return cliente;
    }

    public void setCedulaCli(Cliente cedulaCli) {
        this.cliente = cedulaCli;
    }
    
    public Empleado getCedulaEmp() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public BrechaHoraria getBrechaHoraria() {
        return brechaHoraria;
    }

    public void setBrechaHoraria(BrechaHoraria brechaHoraria) {
        this.brechaHoraria = brechaHoraria;
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public List<SolicitudDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<SolicitudDetalle> detalles) {
        this.detalles = detalles;
    }

    public Sucursal getNomSucursal() {
        return suc;
    }

    public void setSuc(Sucursal suc) {
        this.suc = suc;
    }
    
    @Override
    public String toString() {
        return "Entidades.Objetos2.Solicitudes[ id=" + id + " ]";
    }
    
}

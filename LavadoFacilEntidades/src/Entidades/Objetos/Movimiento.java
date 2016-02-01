package Entidades.Objetos;
import Entidades.Enumeraciones.TipoMov;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Movimiento implements Serializable {
    private int idMov;
    private Date fechaMov;
    private String nombreMov;
    private TipoMov tipoMov;
    private String descripcion;
    private BigDecimal monto;
    
    private Sucursal sucursal;
    
    public Movimiento() {
    }

    public Movimiento(int idMov, Date fechaMov, String nombreMov, TipoMov tipoMov, String descripcion, BigDecimal monto) {
        this.idMov = idMov;
        this.fechaMov = fechaMov;
        this.nombreMov = nombreMov;
        this.tipoMov = tipoMov;
        this.descripcion = descripcion;
        this.monto = monto;
    }   

    public int getIdMov() {
        return idMov;
    }

    public void setIdMov(int idMov) {
        this.idMov = idMov;
    }    
    
    public TipoMov getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(TipoMov tipoMov) {
        this.tipoMov = tipoMov;
    }    
    
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombreMov() {
        return nombreMov;
    }

    public void setNombreMov(String nombreMov) {
        this.nombreMov = nombreMov;
    }
    
    public Date getFechaMov() {
        return fechaMov;
    }
    
    public String getFechaMovStr() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaMov);
    }
    
    public String getFechaMovStrLarge() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fechaMov);
    }

    public void setfechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

//    public BigDecimal CalcularMargen() {
//        BigDecimal totalIngresos = GetTotalIngresos();
//        BigDecimal totalGastos = GetTotalGastos();
//        
//        return totalIngresos.subtract(totalGastos);
//    }

//    public BigDecimal GetTotalIngresos() {
//        BigDecimal totalIngresos = new BigDecimal(0);
//        
//        for(Ingreso i : getIngresosList()) {
//            totalIngresos = totalIngresos.add(i.getMonto());
//        }
//        
//        return totalIngresos;
//    }
//    
//    public BigDecimal GetTotalGastos() {
//        BigDecimal totalGastos = new BigDecimal(0);
//        
//        for(Gasto g : getGastosList()) {
//            totalGastos = totalGastos.add(g.getMonto());
//        }
        
//        return totalGastos;
//    }
}

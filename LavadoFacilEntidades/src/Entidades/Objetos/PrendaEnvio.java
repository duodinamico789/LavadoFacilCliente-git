package Entidades.Objetos;
import Entidades.Objetos.Tintoreria;
import Entidades.Objetos.Prenda;
import java.math.BigDecimal;
public class PrendaEnvio {
    private int id;
    private BigDecimal precio;
    private Tintoreria idtint;
    private Prenda idpren;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public BigDecimal getPrecio() {
        return precio;
    }

    public Tintoreria getIdtint() {
        return idtint;
    }

    public Prenda getIdpren() {
        return idpren;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setIdtint(Tintoreria idtint) {
        this.idtint = idtint;
    }

    public void setIdpren(Prenda idpren) {
        this.idpren = idpren;
    }

    public PrendaEnvio() {
    }

    public PrendaEnvio(int id, BigDecimal precio, Tintoreria idtint, Prenda idpren) {
        this.id = id;
        this.precio = precio;
        this.idtint = idtint;
        this.idpren = idpren;
    }
    
    
}

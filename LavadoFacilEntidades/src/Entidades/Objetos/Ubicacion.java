package Entidades.Objetos;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private int id;
    private String direccion;
    private String barrio;
    private String ciudad;
    

   public Ubicacion(int id, String direccion, String barrio, String ciudad) {
        this.id = id;
        this.direccion = direccion;
        this.barrio=barrio;
        this.ciudad=ciudad;
    }
   
   public Ubicacion() {
    }
   
    public int getId()
    {
     return id;
    }
    
    public void setId(int id)
    {
      this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    @Override
    public String toString() {
        return "Entidades.Objetos.Ubicaciones[ direccion=" + direccion + " ]";
    }
}

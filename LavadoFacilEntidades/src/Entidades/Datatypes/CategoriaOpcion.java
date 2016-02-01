package Entidades.Datatypes;

public class CategoriaOpcion {
    private int IdOpcion;
    private int IdSubOpcion;

    public CategoriaOpcion(int IdOpcion, int IdSubOpcion) {
        this.IdOpcion = IdOpcion;
        this.IdSubOpcion = IdSubOpcion;
    } 
    
    public int getIdOpcion() {
        return IdOpcion;
    }

    public void setIdOpcion(int IdOpcion) {
        this.IdOpcion = IdOpcion;
    }

    public int getIdSubOpcion() {
        return IdSubOpcion;
    }

    public void setIdSubOpcion(int IdSubOpcion) {
        this.IdSubOpcion = IdSubOpcion;
    }
}

package Entidades.Datatypes;

import Entidades.Objetos.Prenda;

public class PrendaExtended {
    private int index;
    private Prenda prenda;
    //private OperacionPrendaExtended operacion;
    private int cantPrendas;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }    

//    public OperacionPrendaExtended getOperacion() {
//        return operacion;
//    }
//
//    public void setOperacion(OperacionPrendaExtended operacion) {
//        this.operacion = operacion;
//    }    
    
    public int getCantPrendas() {
        return cantPrendas;
    }

    public void setCantPrendas(int cantPrendas) {
        this.cantPrendas = cantPrendas;
    }  

}

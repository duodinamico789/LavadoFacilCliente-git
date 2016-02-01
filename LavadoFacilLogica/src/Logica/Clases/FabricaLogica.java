package Logica.Clases;

import Logica.Interface.*;

public class FabricaLogica {

    private static FabricaLogica instancia = null;

    protected FabricaLogica() {
    }

    public static FabricaLogica getInstancia() {
        if (instancia == null) {
            instancia = new FabricaLogica();
        }
        return instancia;
    }

    public ILogicaSucursales getILogicaSucursales() {
        return LogicaSucursales.getInstancia();
    }

    public ILogicaPrendas getILogicaPrenda() {
        return LogicaPrendas.getInstancia();
    }

    public ILogicaPersonas getILogicaPersonas() {
        return LogicaPersonas.getInstancia();
    }

    public ILogicaUbicacion getILogicaUbicacion() {
        return LogicaUbicacion.getInstancia();
    }

    public ILogicaTintorerias getILogicaTintoreria() {
        return LogicaTintorerias.getInstancia();
    }

    public ILogicaMovimientos getILogicaMovimientos() {
        return LogicaMovimientos.getInstancia();
    }

    public ILogicaExcepciones getILogicaExcepciones() {
        return LogicaExcepciones.getInstancia();
    }

    public ILogicaOpciones getILogicaOpciones() {
        return LogicaOpciones.getInstancia();
    }

    public ILogicaBrechasHorarias getILogicaBrechasHorarias() {
        return LogicaBrechasHorarias.getInstancia();
    }

    public ILogicaSolicitud getILogicaSolicitud() {
        return LogicaSolicitud.getInstancia();
    }
}

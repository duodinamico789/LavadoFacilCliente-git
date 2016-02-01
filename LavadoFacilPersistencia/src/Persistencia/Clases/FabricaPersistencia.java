package Persistencia.Clases;

import Persistencia.Interfaces.*;

public class FabricaPersistencia {

    private static FabricaPersistencia instancia = null;

    protected FabricaPersistencia() {
    }

    public static FabricaPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new FabricaPersistencia();
        }
        return instancia;
    }

    public IPersistenciaTintoreria getIPersistenciaTintorerias() {
        return PersistenciaTintorerias.getInstancia();
    }

    public IPersistenciaBrechasHorarias getIPersistenciaBrechaHorarias() {
        return PersistenciaBrechasHorarias.getInstancia();
    }

    public IPersistenciaSucursales getIPersistenciaSucursal() {
        return PersistenciaSucursales.getInstancia();
    }

    public IPersistenciaPrendas getIPersistenciaPrenda() {
        return PersistenciaPrendas.getInstancia();
    }

    public IPersistenciaCliente getIPersistenciaCliente() {
        return PersistenciaCliente.getInstancia();
    }

    public IPersistenciaEmpleado getIPersistenciaEmpleado() {
        return PersistenciaEmpleado.getInstancia();
    }

    public IPersistenciaUbicacion getIpersistenciaUbicacion() {
        return PersistenciaUbicacion.getInstancia();
    }

    public IPersistenciaMovimientos getIpersistenciaMovimientos() {
        return PersistenciaMovimientos.getInstancia();
    }

    public IPersistenciaOpciones getIpersistenciaOpciones() {
        return PersistenciaOpciones.getInstancia();
    }

    public IPersistenciaSolicitud getIpersistenciaSolicitud() {
        return PersistenciaSolicitud.getInstancia();
    }
    
    public IPersistenciaExcepciones getIpersistenciaExcepciones() {
        return PersistenciaExcepciones.getInstancia();
    }
}

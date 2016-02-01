package Logica.Clases;

import Entidades.Objetos.Excepcion;
import Logica.Interface.ILogicaExcepciones;
import java.sql.SQLException;
import java.util.LinkedList;

public class LogicaExcepciones implements ILogicaExcepciones {

    private static LogicaExcepciones _instancia = null;

    private LogicaExcepciones() {
    }

    public static LogicaExcepciones getInstancia() {
        if (_instancia == null) {
            _instancia = new LogicaExcepciones();
        }
        return _instancia;
    }

    @Override
    public int AltaExcepcion(Excepcion excepcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaExcepciones exc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaExcepciones();
        return exc.AltaExcepcion(excepcion);
    }

    @Override
    public int ModificarExcepcion(String oldNombre, Excepcion excepcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaExcepciones exc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaExcepciones();
        return exc.ModificarExcepcion(oldNombre, excepcion);
    }

    @Override
    public int BajaExcepcion(Excepcion excepcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaExcepciones exc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaExcepciones();
        return exc.BajaExcepcion(excepcion);
    }

    @Override
    public Excepcion BuscarExcepcion(String nomExcepcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaExcepciones exc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaExcepciones();
        return exc.BuscarExcepcion(nomExcepcion);
    }

    @Override
    public LinkedList<Excepcion> ListarExcepciones() throws SQLException {
        Persistencia.Interfaces.IPersistenciaExcepciones exc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaExcepciones();
        return exc.ListarExcepciones();
    }

}

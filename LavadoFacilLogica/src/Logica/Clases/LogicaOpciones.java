package Logica.Clases;

import Entidades.Objetos.Opcion;
import Logica.Interface.ILogicaOpciones;
import java.sql.SQLException;
import java.util.LinkedList;

public class LogicaOpciones implements ILogicaOpciones {
    
    private static LogicaOpciones _instancia = null;
    
    private LogicaOpciones() { }
    
     public static LogicaOpciones getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaOpciones();
        return _instancia;
    }
    
    @Override
    public int AltaOpcion(Opcion opcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.AltaOpcion(opcion);
    }

    @Override
    public int ModificarOpcion(String oldNombre, Opcion opcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.ModificarOpcion(oldNombre, opcion);
    }

    @Override
    public int BajaOpcion(Opcion opcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.BajaOpcion(opcion);
    }

    @Override
    public Opcion BuscarOpcion(int idOpcion) throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.BuscarOpcion(idOpcion);
    }

    @Override
    public LinkedList<Opcion> ListarOpciones() throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.ListarOpciones();
    }
    
    @Override
    public LinkedList<Opcion> ListarOpcionesXSol(int idSol) throws SQLException {
        Persistencia.Interfaces.IPersistenciaOpciones op = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaOpciones();
        return op.ListarOpcionesXSol(idSol);
    }
    
}

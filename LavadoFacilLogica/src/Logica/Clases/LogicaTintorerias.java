package Logica.Clases;

import Entidades.Objetos.Tintoreria;
import java.util.LinkedList;

public class LogicaTintorerias implements Logica.Interface.ILogicaTintorerias {
    private static LogicaTintorerias _instancia = null;
    
    private LogicaTintorerias() { }
    
    public static LogicaTintorerias getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaTintorerias();
        return _instancia;
    }
    
    @Override
    public int AltaTintoreria(Tintoreria tin) throws Exception 
    {
        Persistencia.Interfaces.IPersistenciaTintoreria tinto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaTintorerias();
        return tinto.AltaTintoreria(tin);
    } 

    @Override
    public Tintoreria BuscarTintoreria(String nombre) throws Exception
    {
        Persistencia.Interfaces.IPersistenciaTintoreria tinto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaTintorerias();
        Tintoreria tintoreria = tinto.BuscarTintoreria(nombre);
        return tintoreria;
    }
     
    @Override
    public int ModificarTintoreria(Tintoreria tin) throws Exception 
    {
        Persistencia.Interfaces.IPersistenciaTintoreria tinto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaTintorerias();
        return tinto.ModificarTintoreria(tin);
    }
    
    @Override
    public int BajaTintoreria(int idtint) throws Exception 
    { 
        Persistencia.Interfaces.IPersistenciaTintoreria tinto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaTintorerias();
        return tinto.BajaTintoreria(idtint);
    }
    
    @Override
    public LinkedList<Tintoreria> ListarTintorerias(int idSuc2) throws Exception
    {
        Persistencia.Interfaces.IPersistenciaTintoreria tinto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaTintorerias();
        return tinto.ListarTintorerias(idSuc2);
    }
}

package Logica.Clases;
import Entidades.Objetos.Solicitud;
import Entidades.Objetos.Ubicacion;
import java.util.LinkedList;
public class LogicaSolicitud implements Logica.Interface.ILogicaSolicitud{
    private static LogicaSolicitud _instancia = null;
    
    private LogicaSolicitud() { }
    
     public static LogicaSolicitud getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaSolicitud();
        return _instancia;
    }
     
     @Override
     public void AltaSolicitud(Solicitud s)throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       sol.AltaSolicitud(s);
     } 
     
     @Override
     public void ModificarSolicitud(Solicitud s) throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       sol.ModificarSolicitud(s);
     }
     
     @Override
     public void BajaSolicitud(int id) throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       sol.BajaSolicitud(id);
     }
     
     @Override
     public LinkedList<Solicitud> ListarUbicaciones()throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       return sol.ListarSolicitud();
     }
     
     @Override
     public Solicitud BuscarSolicitudXId(int idSol)throws Exception 
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       return sol.BuscarSolicitudXId(idSol);
     }
     
     @Override
     public Solicitud BuscarSolicitudXCli(String ciCli)throws Exception 
     {
       Persistencia.Interfaces.IPersistenciaSolicitud sol = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaSolicitud();
       return sol.BuscarSolicitudXCli(ciCli);
     }
     
     
}

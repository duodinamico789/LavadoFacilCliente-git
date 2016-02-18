package Logica.Clases;

import Entidades.Objetos.Ubicacion;
import java.util.LinkedList;

public class LogicaUbicacion implements Logica.Interface.ILogicaUbicacion{
    private static LogicaUbicacion _instancia = null;
    
    private LogicaUbicacion() { }
    
     public static LogicaUbicacion getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaUbicacion();
        return _instancia;
    }
    
     @Override
     public void AltaUbicacion(Ubicacion ubi)throws Exception
     {
           Persistencia.Interfaces.IPersistenciaUbicacion ub = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
           ub.AltaUbicacion(ubi);
     } 
     
     @Override
     public Ubicacion BuscarUbicacion(String dir) throws Exception
     {
        Persistencia.Interfaces.IPersistenciaUbicacion ub = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
        Ubicacion ubi = ub.BuscarUbicacion(dir);
        return ubi;
     }
     
     @Override
     public void ModificarUbicacion(Ubicacion ub) throws Exception
     {
       Persistencia.Interfaces.IPersistenciaUbicacion ubi = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
       ubi.ModificarUbicacion(ub);
     }
     @Override
     public void BajaUbicacion(int id) throws Exception
     { 
       Persistencia.Interfaces.IPersistenciaUbicacion ubi = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
       ubi.BajaUbicacion(id);
     }
     @Override
     public void BajaRelacion_ubicsucursales(int idubic, int idsuc) throws Exception
     { 
       Persistencia.Interfaces.IPersistenciaUbicacion ubi = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
       ubi.BajaRelacion_ubicsucursales(idubic, idsuc);
     }
     
     @Override
     public void Bajarelacion_ubictintorerias(int idubic, int idtint) throws Exception
     { 
       Persistencia.Interfaces.IPersistenciaUbicacion ubi = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
       ubi.Bajarelacion_ubictintorerias(idubic, idtint);
     }
     
     @Override
     public LinkedList<Ubicacion> ListarUbicaciones()throws Exception
     {
       Persistencia.Interfaces.IPersistenciaUbicacion ubi = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaUbicacion();
       return ubi.ListarUbicaciones();
     }
   
}

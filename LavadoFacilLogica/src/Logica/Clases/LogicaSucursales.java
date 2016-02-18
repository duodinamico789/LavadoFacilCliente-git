package Logica.Clases;

import Entidades.Objetos.Sucursal;
import java.util.LinkedList;

public class LogicaSucursales implements Logica.Interface.ILogicaSucursales{
    private static LogicaSucursales _instancia = null;
    
    private LogicaSucursales() { }
    
     public static LogicaSucursales getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaSucursales();
        return _instancia;
    }
    
     @Override
     public void AltaSucursales(Sucursal suc)throws Exception
     {
           Persistencia.Interfaces.IPersistenciaSucursales sucu = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
           sucu.AltaSucursal(suc);
     } 
     
     @Override
     public Sucursal BuscarSucursal(String nombresuc) throws Exception
     {
        Persistencia.Interfaces.IPersistenciaSucursales sucu = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
        Sucursal suc = sucu.BuscarSucursal(nombresuc);
        return suc;
     }
     
     @Override
     public void ModificarSucursal(Sucursal suc) throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSucursales sucu = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
       sucu.ModificarSucursal(suc);
     }
     
     @Override
     public int BajaSucursal(int idSuc) throws Exception
     { 
       Persistencia.Interfaces.IPersistenciaSucursales sucu = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
       return sucu.BajaSucursal(idSuc);
     }
     
     @Override
     public LinkedList<Sucursal> ListarSucursales()throws Exception
     {
       Persistencia.Interfaces.IPersistenciaSucursales suc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
       return suc.ListarSucursales();
     }
      
      @Override
      public void BajaRelacion_TintoreriasSucursales(int idTint, int idSuc) throws Exception 
      {
       Persistencia.Interfaces.IPersistenciaSucursales suc = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaSucursal();
       suc.BajaRelacion_TintoreriasSucursales(idTint, idSuc);         
      } 
}

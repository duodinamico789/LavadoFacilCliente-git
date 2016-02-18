package Logica.Interface;

import Entidades.Objetos.Sucursal;
import java.util.LinkedList;

public interface ILogicaSucursales {
    
    void AltaSucursales(Sucursal suc)throws Exception;
    Sucursal BuscarSucursal(String nombresuc) throws Exception;
    void ModificarSucursal(Sucursal suc) throws Exception;
    int BajaSucursal(int idSuc) throws Exception;
    LinkedList<Sucursal> ListarSucursales()throws Exception;
    void BajaRelacion_TintoreriasSucursales(int idTint, int idSuc) throws Exception;
  
}

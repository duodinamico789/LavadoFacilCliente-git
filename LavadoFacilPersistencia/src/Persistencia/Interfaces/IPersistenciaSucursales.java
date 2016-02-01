package Persistencia.Interfaces;

import Entidades.Objetos.Sucursal;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaSucursales {
    void AltaSucursal(Sucursal suc)throws SQLException;
    void ModificarSucursal(Sucursal suc)throws SQLException;
    void BajaSucursal(int idSuc) throws SQLException;
    Sucursal BuscarSucursal(String nombreSuc)throws SQLException;
    LinkedList<Sucursal> ListarSucursales() throws SQLException;
    LinkedList<Sucursal> ListarSucursalesPorTint(int idTint) throws SQLException;
    void BajaRelacion_TintoreriasSucursales(int idtint, int idsuc) throws SQLException;
}

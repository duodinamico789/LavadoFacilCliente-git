package Persistencia.Interfaces;

import Entidades.Objetos.Ubicacion;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaUbicacion {
    
    void AltaUbicacion(Ubicacion ub)throws SQLException;
    void ModificarUbicacion(Ubicacion ub)throws SQLException;
    void BajaUbicacion(int id) throws SQLException;
    Ubicacion BuscarUbicacion(String direccion)throws SQLException;
    LinkedList<Ubicacion> ListarUbicaciones() throws SQLException;
    void BajaRelacion_UbicPerson(int id, String cedula) throws SQLException;
    void BajaRelacion_ubicsucursales(int idubic, int idsuc)throws SQLException;
    void Bajarelacion_ubictintorerias(int idubic, int idtint) throws SQLException;
}

package Logica.Interface;

import Entidades.Objetos.Ubicacion;
import java.util.LinkedList;

public interface ILogicaUbicacion {
    
    void AltaUbicacion(Ubicacion ubi)throws Exception;
    Ubicacion BuscarUbicacion(String dir) throws Exception;
    void ModificarUbicacion(Ubicacion ub) throws Exception;
    void BajaUbicacion(int id) throws Exception;
    LinkedList<Ubicacion> ListarUbicaciones()throws Exception;
    void BajaRelacion_UbicPerson(int id, String cedula)throws Exception;
    void BajaRelacion_ubicsucursales(int idubic, int idsuc) throws Exception;
    void Bajarelacion_ubictintorerias(int idubic, int idtint) throws Exception;
}

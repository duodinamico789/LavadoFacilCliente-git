package Logica.Interface;

import Entidades.Objetos.Solicitud;
import java.util.LinkedList;

public interface ILogicaSolicitud {
    void ModificarSolicitud(Solicitud s) throws Exception;
    void AltaSolicitud(Solicitud s)throws Exception;
    void BajaSolicitud(int id) throws Exception;
    LinkedList<Solicitud> ListarUbicaciones()throws Exception;
    Solicitud BuscarSolicitudXId(int idSol)throws Exception;
    Solicitud BuscarSolicitudXCli(String ciCli)throws Exception;
}

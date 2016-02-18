package Logica.Interface;

import Entidades.Enumeraciones;
import Entidades.Objetos.Solicitud;
import java.util.LinkedList;

public interface ILogicaSolicitud {
    void ModificarSolicitud(Solicitud s) throws Exception;
    void AltaSolicitud(Solicitud s)throws Exception;
    void BajaSolicitud(int id) throws Exception;
    LinkedList<Solicitud> ListarSolicitudes()throws Exception;
    Solicitud BuscarSolicitudXId(int idSol)throws Exception;
    LinkedList<Solicitud> BuscarSolicitudXCli(String ciCli)throws Exception;
    void CambiarEstadoSol(int idSol, Enumeraciones.EstadosSolicitud estado)throws Exception; 

}

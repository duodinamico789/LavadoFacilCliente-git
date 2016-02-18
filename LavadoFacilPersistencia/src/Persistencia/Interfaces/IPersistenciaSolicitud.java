package Persistencia.Interfaces;

import Entidades.Enumeraciones.EstadosSolicitud;
import Entidades.Objetos.Solicitud;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaSolicitud{
    void AltaSolicitud(Solicitud sol) throws SQLException;
    void ModificarSolicitud(Solicitud sol)throws SQLException;
    void BajaSolicitud(int id) throws SQLException;
    LinkedList<Solicitud> ListarSolicitud() throws SQLException;
    Solicitud BuscarSolicitudXId(int idSol) throws SQLException;
    LinkedList<Solicitud> BuscarSolicitudXCli(String ciCli) throws SQLException;
    void CambiarEstadoSol(int idSol, EstadosSolicitud estado)throws SQLException;
}

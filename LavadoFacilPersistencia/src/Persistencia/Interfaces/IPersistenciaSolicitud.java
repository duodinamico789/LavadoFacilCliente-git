package Persistencia.Interfaces;

import Entidades.Objetos.Solicitud;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaSolicitud{
    void AltaSolicitud(Solicitud sol) throws SQLException;
    void ModificarSolicitud(Solicitud sol)throws SQLException;
    void BajaSolicitud(int id) throws SQLException;
    LinkedList<Solicitud> ListarSolicitud() throws SQLException;
    Solicitud BuscarSolicitudXId(int idSol) throws SQLException;
    Solicitud BuscarSolicitudXCli(String ciCli) throws SQLException;
}

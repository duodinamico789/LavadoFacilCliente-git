package Persistencia.Interfaces;

import Entidades.Objetos.BrechaHoraria;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public interface IPersistenciaBrechasHorarias {
    int AltaBrechaHoraria(BrechaHoraria brecha) throws SQLException;
    int ModificarBrechaHoraria(Date oldHoraInicio, Date oldHoraFin, BrechaHoraria brecha) throws SQLException;
    int BajaBrechaHoraria(Date horaInicio, Date horaFin) throws SQLException;
    BrechaHoraria BuscarBrechaHoraria(Date horaInicio, Date horaFin) throws SQLException;
    LinkedList<BrechaHoraria> ListarBrechasHorarias() throws SQLException;
    
}

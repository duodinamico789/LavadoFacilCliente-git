package Logica.Interface;

import Entidades.Objetos.BrechaHoraria;
import java.util.Date;
import java.util.LinkedList;

public interface ILogicaBrechasHorarias {
    int AltaBrechaHoraria(BrechaHoraria bre)throws Exception;
    BrechaHoraria BuscarBrechaHoraria(Date horaInicio, Date horaFin) throws Exception;
    int ModificarBrechaHoraria(Date oldHoraInicio, Date oldHoraFin, BrechaHoraria brecha) throws Exception;
    int BajaBrechaHoraria(Date horaInicio, Date horaFin) throws Exception;
    LinkedList<BrechaHoraria> ListarBrechasHorarias()throws Exception;
}

package Logica.Clases;

import Entidades.Objetos.BrechaHoraria;
import java.util.Date;
import java.util.LinkedList;

public class LogicaBrechasHorarias implements Logica.Interface.ILogicaBrechasHorarias{
     private static LogicaBrechasHorarias _instancia = null;
    
    private LogicaBrechasHorarias() { }
    
     public static LogicaBrechasHorarias getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaBrechasHorarias();
        return _instancia;
    }
    
     @Override
     public int AltaBrechaHoraria(BrechaHoraria bre)throws Exception
     {
           Persistencia.Interfaces.IPersistenciaBrechasHorarias brecha = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaBrechaHorarias();
           return brecha.AltaBrechaHoraria(bre);
     } 
     
     @Override
     public BrechaHoraria BuscarBrechaHoraria(Date horaInicio, Date horaFin) throws Exception
     {
        Persistencia.Interfaces.IPersistenciaBrechasHorarias brecha = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaBrechaHorarias();
        BrechaHoraria bre = brecha.BuscarBrechaHoraria(horaInicio, horaFin);
        return bre;
     }
     
     @Override
     public int ModificarBrechaHoraria(Date oldHoraInicio, Date oldHoraFin, BrechaHoraria _brecha) throws Exception
     {
       Persistencia.Interfaces.IPersistenciaBrechasHorarias brecha = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaBrechaHorarias();
       return brecha.ModificarBrechaHoraria(oldHoraInicio, oldHoraFin, _brecha);
     }
     
     @Override
     public int BajaBrechaHoraria(Date horaInicio, Date horaFin) throws Exception
     { 
       Persistencia.Interfaces.IPersistenciaBrechasHorarias brecha = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaBrechaHorarias();
       return brecha.BajaBrechaHoraria(horaInicio, horaFin);
     }
     
     @Override
     public LinkedList<BrechaHoraria> ListarBrechasHorarias() throws Exception
     {
       Persistencia.Interfaces.IPersistenciaBrechasHorarias brecha = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaBrechaHorarias();
       return brecha.ListarBrechasHorarias();
     }
}

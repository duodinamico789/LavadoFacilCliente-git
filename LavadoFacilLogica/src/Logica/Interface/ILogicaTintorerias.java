package Logica.Interface;

import Entidades.Objetos.Tintoreria;
import java.util.LinkedList;

public interface ILogicaTintorerias {
    
    int AltaTintoreria(Tintoreria tin)throws Exception;
    Tintoreria BuscarTintoreria(String nombre) throws Exception;
    int ModificarTintoreria(Tintoreria tin) throws Exception;
    int BajaTintoreria(int idtint) throws Exception;
    LinkedList<Tintoreria> ListarTintorerias() throws Exception;
    
}

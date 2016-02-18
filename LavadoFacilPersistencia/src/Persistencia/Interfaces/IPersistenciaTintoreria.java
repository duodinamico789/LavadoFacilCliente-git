package Persistencia.Interfaces;

import Entidades.Objetos.Tintoreria;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaTintoreria {
    
    int AltaTintoreria(Tintoreria tin)throws SQLException;
    int ModificarTintoreria(Tintoreria tintoreria) throws SQLException;
    int BajaTintoreria(int idtint) throws SQLException;
    Tintoreria BuscarTintoreria(String nombre)throws SQLException;
    LinkedList<Tintoreria> ListarTintorerias(int idSuc2) throws SQLException; 
    
}

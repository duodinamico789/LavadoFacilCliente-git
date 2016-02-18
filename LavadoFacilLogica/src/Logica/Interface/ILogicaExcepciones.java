package Logica.Interface;

import Entidades.Objetos.Excepcion;
import java.sql.SQLException;
import java.util.LinkedList;

public interface ILogicaExcepciones {
    int AltaExcepcion(Excepcion excepcion)throws SQLException;
    int ModificarExcepcion(String oldNombre, Excepcion excepcion) throws SQLException;
    int BajaExcepcion(Excepcion excepcion) throws SQLException;
    Excepcion BuscarExcepcion(String nomExcepcion)throws SQLException;
    LinkedList<Excepcion> ListarExcepciones(int IdPda) throws SQLException;
    LinkedList<Excepcion> ListarExcepciones() throws SQLException;
}


package Persistencia.Interfaces;
import Entidades.Objetos.Opcion;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaOpciones {

   
    int AltaOpcion(Opcion opcion)throws SQLException;
    int ModificarOpcion(String oldNombre, Opcion opcion) throws SQLException;
    int BajaOpcion(Opcion opcion) throws SQLException;
    Opcion BuscarOpcion(int idOpcion) throws SQLException;
    LinkedList<Opcion> ListarOpciones() throws SQLException; 
    LinkedList<Opcion> ListarOpcionesXSol(int idSol) throws SQLException;
    
}

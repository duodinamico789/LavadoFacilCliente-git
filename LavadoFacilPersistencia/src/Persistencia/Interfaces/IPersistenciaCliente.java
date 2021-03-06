
package Persistencia.Interfaces;
import Entidades.Objetos.Cliente;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaCliente {

   
    void AltaCliente(Cliente cli)throws SQLException;
    void ModificarCliente(Cliente cli)throws SQLException;
    void BajaCliente(String cedula) throws SQLException;
    Cliente BuscarCliente(String Cedula)throws SQLException;
    LinkedList<Cliente> ListarClientesXFechareg() throws SQLException;
    Cliente LoginCliente (String usu, String pass)throws SQLException;
    LinkedList<Cliente> ListarClientesXfechaUltimaEntrada() throws SQLException;
    void IngresoSistemaCli(String cedula)throws SQLException;
    
}

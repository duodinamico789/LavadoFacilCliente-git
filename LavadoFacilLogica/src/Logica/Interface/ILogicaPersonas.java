package Logica.Interface;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Empleado;
import java.sql.Date;
import java.util.LinkedList;
public interface ILogicaPersonas {
    
    void AltaPersona(Persona per)throws Exception;
    Persona BuscarPersona(String ced) throws Exception;
    void ModificarPersona(Persona per) throws Exception;
    int BajaPersona(String ced) throws Exception;
    LinkedList<Cliente> ListarClientesXFechareg()throws Exception;
    LinkedList<Cliente> ListarClientesXfechaUltimaEntrada()throws Exception;
    LinkedList<Empleado> ListadoEmpleados()throws Exception;
    LinkedList<Empleado> ListadoEmpleadosConSucursal()throws Exception;
    Empleado LoginEmpleado (String usu, String pass)throws Exception;
    Cliente LoginCliente (String usu, String pass) throws Exception;
    void CambioPassEmpleado (String usu, String pass)throws Exception;
    void ActualizarCambioPassPedido (String cedula, String fecha)throws Exception;
    void RestablecerPass (String cedula)throws Exception;
    LinkedList<Empleado> ListarCambioPassPedido()throws Exception;
    void IngresoSistemaCli(String cedula)throws Exception;
}

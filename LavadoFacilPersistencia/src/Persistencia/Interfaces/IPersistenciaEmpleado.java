package Persistencia.Interfaces;

import Entidades.Objetos.Empleado;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaEmpleado {
    
    void AltaEmpleado(Empleado emp)throws SQLException;
    void ModificarEmpleados(Empleado emp)throws SQLException;
    void BajaEmpleado(String cedula) throws SQLException;
    Empleado BuscarEmpleado(String Cedula)throws SQLException;
    LinkedList<Empleado> ListarEmpleados() throws SQLException;
    LinkedList<Empleado> ListarEmpleadosConSucursal() throws SQLException;
    Empleado LoginEmpleado (String usu, String pass) throws SQLException;
    void CambioPassEmpleado (String ced, String pass) throws SQLException;
    void AltaCambioPassPedido (String ced, String fecha) throws SQLException;
    void RestablecerPass (String ced) throws SQLException;
    LinkedList<Empleado> ListarCambioPassPedido() throws SQLException;
}

package Logica.Clases;
import java.util.LinkedList;
import Logica.Interface.ILogicaPersonas;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import java.sql.Date;

public class LogicaPersonas implements ILogicaPersonas{
    
    private static LogicaPersonas _instancia = null;
    
    private LogicaPersonas() { }
    
     public static LogicaPersonas getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaPersonas();
        return _instancia;
    }
    
     @Override
     public void AltaPersona(Persona per)throws Exception
     {
          if (per instanceof Cliente)
          {
           Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
           cli.AltaCliente((Cliente)per);
          }
          else
          {
           Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
           emp.AltaEmpleado((Empleado)per);
          }
     } 
     
     @Override
     public Persona BuscarPersona(String ced) throws Exception
     {
        Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
        Persona per = cli.BuscarCliente(ced);
        if (per == null) {
            Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
            per = emp.BuscarEmpleado(ced);
        }
        return per;
     }
     
     @Override
     public void ModificarPersona(Persona per) throws Exception
     {
            if (per instanceof Cliente)
            {
               Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
               cli.ModificarCliente((Cliente)per);
            }
            else
            {
               Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
               emp.ModificarEmpleados((Empleado)per);
            }
     }
     @Override
     public void BajaPersona(String cedula) throws Exception
     {
            Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
            cli.BajaCliente(cedula);
            
            Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
            emp.BajaEmpleado(cedula);
     }
     @Override
     public LinkedList<Cliente> ListarClientesXFechareg()throws Exception
     {
           Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
           return cli.ListarClientesXFechareg();
     }
     @Override
     public LinkedList<Cliente> ListarClientesXfechaUltimaEntrada()throws Exception
     {
           Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
           return cli.ListarClientesXfechaUltimaEntrada();
     }

     @Override
     public LinkedList<Empleado> ListadoEmpleados()throws Exception
     {
           Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
           return emp.ListarEmpleados();
     }
     @Override
     public LinkedList<Empleado> ListadoEmpleadosConSucursal()throws Exception
     {
           Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
           return emp.ListarEmpleadosConSucursal();
     }
     @Override
     public Empleado LoginEmpleado (String usu, String pass)throws Exception
     {
        Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
         return emp.LoginEmpleado(usu, pass);
     }
     @Override
     public Cliente LoginCliente (String usu, String pass)throws Exception
     {
        Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
        return cli.LoginCliente(usu, pass);
     }
     @Override
     public void CambioPassEmpleado (String usu, String pass)throws Exception
     {
        Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
        emp.CambioPassEmpleado(usu, pass);
     }
     @Override
     public void ActualizarCambioPassPedido (String cedula,String fecha)throws Exception
     {
        Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
        emp.AltaCambioPassPedido(cedula, fecha);
     }
     
     @Override
     public void RestablecerPass (String cedula)throws Exception
     {
        Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
        emp.RestablecerPass(cedula);
     }
     
     @Override
     public LinkedList<Empleado> ListarCambioPassPedido()throws Exception
     {
           Persistencia.Interfaces.IPersistenciaEmpleado emp = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaEmpleado();
           return emp.ListarCambioPassPedido();
     }
     
     @Override
     public void IngresoSistemaCli(String cedula)throws Exception
     {
       Persistencia.Interfaces.IPersistenciaCliente cli = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaCliente();
       cli.IngresoSistemaCli(cedula);
     }
}

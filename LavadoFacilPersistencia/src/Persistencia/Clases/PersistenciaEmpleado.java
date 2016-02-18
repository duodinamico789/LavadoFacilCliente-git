package Persistencia.Clases;

import Entidades.Enumeraciones.TipoEmpleado;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Sucursal;
import Entidades.Objetos.Ubicacion;
import Persistencia.Interfaces.IPersistenciaEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaEmpleado implements IPersistenciaEmpleado {

    private static PersistenciaEmpleado _instancia = null;

    private PersistenciaEmpleado() {
    }

    public static PersistenciaEmpleado getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaEmpleado();
        }
        return _instancia;
    }
    @Override
    public LinkedList<Empleado> ListarCambioPassPedido() throws SQLException {
        Connection cnn = null;
        Empleado emp = null;
        LinkedList<Empleado> lista = new LinkedList<Empleado>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarCambioPassPedido() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                emp = new Empleado();
                emp.setCedula(rs.getString("Cedula"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setFechaOlvidoPass(rs.getDate("FechaOlvidoPass"));
                lista.add(emp);
            }
            cnn.commit();
        } 
        catch (Exception ex) 
        {
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
            rs.close();
        }
        return lista;
    }

    @Override
    public void AltaCambioPassPedido (String ced, String fecha) throws SQLException
    {
     Connection cnn = null;
     try
     {
       int resultado=-1;   
       cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
       cnn.setAutoCommit(false);
       CallableStatement cs = cnn.prepareCall("{call ActualizarCambioPassPedido(?,?,?)}");
       cs.setString("cedula2", ced);
       cs.setString("fecha2", fecha);
       cs.registerOutParameter("result", java.sql.Types.INTEGER);
       cs.execute();
       resultado = cs.getInt("result");
      
       if(resultado == -1)
       {
        throw new Exception("Error al intentar ejecutar la operacion");
       }
     }
     catch (Exception ex) 
     {
       cnn.rollback();
     } 
     finally 
     {
       cnn.close();
     }
    }
    
    @Override
    public void RestablecerPass (String ced) throws SQLException
    {
     Connection cnn = null;
     try
     {
       int resultado=-1;   
       cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
       cnn.setAutoCommit(false);
       CallableStatement cs = cnn.prepareCall("{call RestablecerPass(?,?)}");
       cs.setString("cedula2", ced);
       cs.registerOutParameter("result", java.sql.Types.INTEGER);
       cs.execute();
       resultado = cs.getInt("result");
       if(resultado == -1)
       {
        throw new Exception("Error al intentar ejecutar la operacion");
       }
     }
     catch (Exception ex) 
     {
       cnn.rollback();
     } 
     finally 
     {
       cnn.close();
     }
    }
    
    
    @Override
    public void CambioPassEmpleado (String ced, String pass) throws SQLException
    {
     Connection cnn = null;
     try
     {
       int resultado=-1;   
       cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
       cnn.setAutoCommit(false);
       CallableStatement cs = cnn.prepareCall("{call cambioPass(?, ?, ?)}");
       cs.setString("cedula2", ced);
       cs.setString("passw2", pass);
       cs.registerOutParameter("result", java.sql.Types.INTEGER);
       cs.execute();
       resultado = cs.getInt("result");
     }
     catch (Exception ex) 
     {
       cnn.rollback();
     } 
     finally 
     {
       cnn.close();
     }
    }
    
    @Override
    public Empleado LoginEmpleado (String ced, String pass) throws SQLException
    {
     Connection cnn = null;
     Empleado e = new Empleado();
     try
     {
       cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
       cnn.setAutoCommit(false);
       CallableStatement cs = cnn.prepareCall("{call LogueoUsuario(?,?)}");
       cs.setString("cedula2", ced);
       cs.setString("passw2", pass);
       ResultSet rs = cs.executeQuery();
       if (rs.next()) {
            rs.first();
            e.setCedula(rs.getString("Cedula"));
            e.setPassw(rs.getString("Passw"));
            e.setNombre(rs.getString("Nombre"));
            e.setTelefono(rs.getString("Telefono"));
            e.setCelular(rs.getString("Celular"));
            e.setFechaIngreso(rs.getDate("FechaIngreso"));
            e.setTipoEmpleado(TipoEmpleado.valueOf(rs.getInt("TipoEmpleado")));
            
            //Sucursal
            Sucursal s = new Sucursal();
            s.setIdSuc(rs.getInt("IdSuc"));
            e.setSucursal(s);
//            cs.execute();
//            e.setCedula(ced);
//            e.setPassw(pass);
          }
     }
     catch (Exception ex) 
     {
       cnn.rollback();
     } 
     finally 
     {
       cnn.close();
     }
     return e;
    }
    
    @Override
    public void AltaEmpleado(Empleado emp) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int resultado2 = -1;

            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false); 

            CallableStatement cs = cnn.prepareCall("{ call AltaEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString("cedula2", emp.getCedula());
            cs.setString("passw2", emp.getPassw());
            cs.setString("nombre2", emp.getNombre());
            cs.setString("telefono2", emp.getTelefono());
            cs.setString("celular2", emp.getCelular());
            cs.setBigDecimal("sueldo2", emp.getSueldo());
            String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(emp.getFechaIngreso());
            cs.setString("fechaingreso2", fecha);
            cs.setString("tipoempleado2", emp.getTipoEmpleado().toString());
            cs.setInt("IdSuc2", emp.getSucursal().getIdSuc());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if(resultado == 1){
            CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_UbicPersona(?,?,?)}");
            cs2.setString("CedPersona2", emp.getCedula());
            cs2.setInt("idubic2", emp.getUbicacion().getId());
            cs2.registerOutParameter("result", java.sql.Types.INTEGER);
            cs2.execute();
            resultado2 =  cs2.getInt("result");
            
            if(resultado2 == -1) {
              throw new Exception("Error al intentar ejecutar la operacion");
          }
          }
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
              if(resultado == -2){
              throw new Exception("Nombre de Usuario ya existe, intente con otro");
          }

            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public void ModificarEmpleados(Empleado emp) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int resultado2 = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString("cedula2", emp.getCedula());
            cs.setString("passw2", emp.getPassw());
            cs.setString("nombre2", emp.getNombre());
            cs.setString("telefono2", emp.getTelefono());
            cs.setString("celular2", emp.getCelular());
            cs.setBigDecimal("sueldo2", emp.getSueldo());
            String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(emp.getFechaIngreso());
            cs.setString("fechaingreso2", fecha);
            cs.setString("tipoempleado2", emp.getTipoEmpleado().toString());
            cs.setInt("IdSuc2", emp.getSucursal().getIdSuc());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if(resultado == 1){
            CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_UbicPersona(?,?,?)}");
            cs2.setString("CedPersona2", emp.getCedula());
            cs2.setInt("idubic2", emp.getUbicacion().getId());
            cs2.registerOutParameter("result", java.sql.Types.INTEGER);
            cs2.execute();
            resultado2 =  cs2.getInt("result");
            
            if(resultado2 == -1) {
              throw new Exception("Error al intentar ejecutar la operacion");
          }
          }
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if(resultado == -2){
              throw new Exception("Nombre de Usuario ya existe, intente con otro");
          }

            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public int BajaEmpleado(String cedula) throws SQLException {
    	int retorno = 0;    
		Connection cnn = null;
		

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaPersona( ?, ?, ? ) }");
            cs.setString("cedula2", cedula);
            cs.setString("tipo", "e");
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
			if(resultado == 2) {
              retorno = 1;
            }
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
		return retorno;
    }
    @Override
    public Empleado BuscarEmpleado(String Cedula) throws SQLException {
        Connection cnn = null;
        Empleado emp = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false); 

            CallableStatement cs = cnn.prepareCall("{ call BuscarEmpleado( ? ) }");
            cs.setString("cedula2", Cedula);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                rs.first();

                emp = new Empleado();
                emp.setCedula(rs.getString("Cedula"));
                emp.setPassw(rs.getString("Passw"));
                emp.setNombre(rs.getString("nombre"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setCelular(rs.getString("celular"));
                emp.setSueldo(rs.getBigDecimal("sueldo"));
                emp.setFechaIngreso(rs.getDate("fechaIngreso"));
                emp.setTipoEmpleado(TipoEmpleado.valueOf(rs.getInt("TipoEmpleado")));
                Sucursal s = new Sucursal();
                s.setIdSuc(rs.getInt("IdSuc"));
                s.setNombreSuc(rs.getString("NombreSuc"));
                emp.setSucursal(s);
                Ubicacion ub = new Ubicacion();
                ub.setId(rs.getInt("IdUbic"));
                ub.setDireccion(rs.getString("Direccion"));
                ub.setBarrio(rs.getString("Barrio"));
                ub.setCiudad(rs.getString("Ciudad"));
                emp.setUbicacion(ub);
            }
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            ex.printStackTrace();
        } finally {
            cnn.close();
        }
        return emp;
    }

    @Override
    public LinkedList<Empleado> ListarEmpleados() throws SQLException {
        Connection cnn = null;
        Empleado emp = null;
        LinkedList<Empleado> lista = new LinkedList<Empleado>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarEmpleados() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                emp = new Empleado();
                emp.setCedula(rs.getString("Cedula"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setTelefono(rs.getString("Telefono"));
                emp.setCelular(rs.getString("Celular"));
                emp.setSueldo(rs.getBigDecimal("Sueldo"));
                emp.setFechaIngreso(rs.getDate("FechaIngreso"));              
                Ubicacion ub = new Ubicacion();
                ub.setDireccion(rs.getString("Direccion"));
                Sucursal s = new Sucursal();
                s.setNombreSuc(rs.getString("NombreSuc"));
                emp.setUbicacion(ub);
                emp.setTipoEmpleado((TipoEmpleado.valueOf(rs.getInt("TipoEmpleado"))));
                emp.setSucursal(s);
                lista.add(emp);
            }
            cnn.commit();
        } 
        catch (Exception ex) 
        {
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
            rs.close();
        }
        return lista;
    }
    
    @Override
    public LinkedList<Empleado> ListarEmpleadosConSucursal() throws SQLException {
        Connection cnn = null;
        Empleado emp = null;
        LinkedList<Empleado> lista = new LinkedList<Empleado>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarEmpleadosConSucursal() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                emp = new Empleado();
                emp.setCedula(rs.getString("Cedula"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setTelefono(rs.getString("Telefono"));
                emp.setCelular(rs.getString("Celular"));
                emp.setSueldo(rs.getBigDecimal("Sueldo"));
                emp.setFechaIngreso(rs.getDate("FechaIngreso"));
                emp.setTipoEmpleado((TipoEmpleado.valueOf(rs.getInt("TipoEmpleado"))));
                lista.add(emp);
            }
            cnn.commit();
        } 
        catch (Exception ex) 
        {
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
            rs.close();
        }
        return lista;
    }
}

package Persistencia.Clases;

import Entidades.Exceptions.PersistenciaException;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Ubicacion;
import Persistencia.Interfaces.IPersistenciaCliente;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.LinkedList;

public class PersistenciaCliente implements IPersistenciaCliente {

    private static PersistenciaCliente _instancia = null;

    private PersistenciaCliente() {
    }

    public static PersistenciaCliente getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaCliente();
        }
        return _instancia;
    }

    @Override
    public Cliente LoginCliente(String ced, String pass) throws Exception {
        Connection cnn = null;
        Cliente c = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{call LogueoUsuario(?, ?)}");
            cs.setString("cedula2", ced);
            cs.setString("passw2", pass);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                rs.first();
                c = new Cliente();
                c.setCedula(rs.getString("Cedula"));
                c.setPassw(rs.getString("Passw"));
                c.setNombre(rs.getString("Nombre"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCelular(rs.getString("Celular"));
                c.setfechareg(rs.getDate("FechaReg"));
            }

        } catch (Exception e) {
            if (cnn != null) {
                cnn.rollback();
            }
            throw new PersistenciaException(e.getMessage(), e);
        } finally {
            if (cnn != null) {
                cnn.close();
            }
        }
        return c;
    }

    @Override
    public void AltaCliente(Cliente cli) throws SQLException {
        Connection cnn = null;
        try {
            long f = Date.from(Instant.now()).getTime();
            String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(f);
            int resultado = -1;
            int resultado2 = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call AltaCliente( ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString("cedula2", cli.getCedula());
            cs.setString("passw2", cli.getPassw());
            cs.setString("nombre2", cli.getNombre());
            cs.setString("telefono2", cli.getTelefono());
            cs.setString("celular2", cli.getCelular());
            cs.setString("fechaReg2", fecha);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == 1) {
                CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_UbicPersona(?,?,?)}");
                cs2.setString("CedPersona2", cli.getCedula());
                cs2.setInt("idubic2", cli.getUbicacion().getId());
                cs2.registerOutParameter("result", java.sql.Types.INTEGER);
                cs2.execute();
                resultado2 = cs2.getInt("result");

                if (resultado2 == -1) {
                    throw new Exception("Error al intentar ejecutar la operacion");
                }
            }
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if (resultado == -2) {
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
    public void ModificarCliente(Cliente cli) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int resultado2 = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarCliente(?, ?, ?, ?, ?, ?)}");
            cs.setString("cedula2", cli.getCedula());
            cs.setString("passw2", cli.getPassw());
            cs.setString("nombre2", cli.getNombre());
            cs.setString("telefono2", cli.getTelefono());
            cs.setString("celular2", cli.getCelular());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == 1) {
                CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_UbicPersona(?,?,?)}");
                cs2.setString("CedPersona2", cli.getCedula());
                cs2.setInt("idubic2", cli.getUbicacion().getId());
                cs2.registerOutParameter("result", java.sql.Types.INTEGER);
                cs2.execute();
                resultado2 = cs2.getInt("result");

                if (resultado2 == -1) {
                    throw new Exception("Error al intentar ejecutar la operacion");
                }
            }
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if (resultado == -2) {
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
    public int BajaCliente(String cedula) throws SQLException {
	int retorno = 0;
        Connection cnn = null;

        try {
            int resultado = -1;
            String tipo = "c";
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaPersona( ?, ?, ? ) }");
            cs.setString("cedula2", cedula);
            cs.setString("tipo", tipo);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
			if(resultado == 2) {
            	retorno =1;
            }
            else if(resultado ==1) {
            	retorno =2;
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
    public Cliente BuscarCliente(String Cedula) throws Exception {
        Connection cnn = null;
        Cliente cli = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BuscarCliente( ? ) }");
            cs.setString("cedula2", Cedula);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                rs.first();
                cli = new Cliente();
                cli.setCedula(rs.getString("Cedula"));
                cli.setPassw(rs.getString("Passw"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setCelular(rs.getString("Celular"));
                Ubicacion ub = new Ubicacion();
                ub.setId(rs.getInt("IdUbic"));
                ub.setDireccion(rs.getString("Direccion"));
                ub.setBarrio(rs.getString("Barrio"));
                ub.setCiudad(rs.getString("Ciudad"));
                cli.setUbicacion(ub);
            }
            cnn.commit();
        } catch (Exception e) {
            if (cnn != null) {
                cnn.rollback();
            }
            throw new PersistenciaException(e.getMessage(), e);
        } finally {
            if (cnn != null) {
                cnn.close();
            }
        }
        return cli;
    }

    @Override
    public LinkedList<Cliente> ListarClientesXFechareg() throws SQLException {
        Connection cnn = null;
        Cliente cli = null;
        LinkedList<Cliente> lista = new LinkedList<Cliente>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarClientesXFechareg() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setCedula(rs.getString("Cedula"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setCelular(rs.getString("Celular"));
                cli.setfechareg(rs.getDate("fechareg"));
                cli.setfechaUltimaEntrada(rs.getDate("fechaUltimaEntrada"));
                Ubicacion ub = new Ubicacion();
                ub.setDireccion(rs.getString("Direccion"));
                cli.setUbicacion(ub);
                lista.add(cli);
            }

            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
        } finally {
            cnn.close();
            rs.close();
        }
        return lista;
    }

    @Override
    public LinkedList<Cliente> ListarClientesXfechaUltimaEntrada() throws SQLException {
        Connection cnn = null;
        Cliente cli = null;
        LinkedList<Cliente> lista = new LinkedList<Cliente>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarClientesXfechaUltimaEntrada() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                cli = new Cliente();
                cli.setCedula(rs.getString("Cedula"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setCelular(rs.getString("Celular"));
                cli.setfechareg(rs.getDate("fechareg"));
                cli.setfechaUltimaEntrada(rs.getDate("fechaUltimaEntrada"));
                Ubicacion ub = new Ubicacion();
                ub.setDireccion(rs.getString("Direccion"));
                cli.setUbicacion(ub);
                lista.add(cli);
            }

            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
        } finally {
            cnn.close();
            rs.close();
        }
        return lista;
    }

    @Override
    public void IngresoSistemaCli(String cedula) throws SQLException {
        Connection cnn = null;
        try {
            long f = Date.from(Instant.now()).getTime();
            String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(f);
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call IngresoSistemaCli(?, ?, ?)}");
            cs.setString("cedula2", cedula);
            cs.setString("fechaUltimaEntrada2", fecha);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");

            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if (resultado == -2) {
                throw new Exception("No existe dicha cedula");
            }
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }
}

package Persistencia.Clases;

import Entidades.Enumeraciones;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Sucursal;
import Entidades.Objetos.Ubicacion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class PersistenciaSucursales implements Persistencia.Interfaces.IPersistenciaSucursales {

    private static PersistenciaSucursales _instancia = null;

    private PersistenciaSucursales() {
    }

    public static PersistenciaSucursales getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaSucursales();
        }
        return _instancia;
    }

    @Override
    public void AltaSucursal(Sucursal suc) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int resultado2 = -1;
            int idsuc = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs;
            cs = cnn.prepareCall("{ call AltaSucursal( ?, ?, ?, ?)}");

            cs.setString("nombresuc2", suc.getNombreSuc());
            cs.setString("telefono2", suc.getTelefono());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.registerOutParameter("increment", java.sql.Types.INTEGER);
            cs.executeUpdate();

            suc.setIdSuc(cs.getInt("increment"));
            resultado = cs.getInt("result");
            if (resultado == 1) {
                CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_ubicsucursales(?,?,?)}");
                cs2.setInt("idubic2", suc.getUbicacion().getId());
                cs2.setInt("idSuc2", suc.getIdSuc());
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

            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public void ModificarSucursal(Sucursal suc) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int resultado2 = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarSucursal( ?, ?, ?, ?)}");
            cs.setInt("IdSuc2", suc.getIdSuc());
            cs.setString("nombresuc2", suc.getNombreSuc());
            cs.setString("telefono2", suc.getTelefono());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");

            if (resultado == 1) {
                CallableStatement cs2 = cnn.prepareCall("{call AltaRelacion_ubicsucursales(?,?,?)}");
                cs2.setInt("idubic2", suc.getUbicacion().getId());
                cs2.setInt("idSuc2", suc.getIdSuc());
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

            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public void BajaSucursal(int idSuc) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaSucursal( ?, ? ) }");
            cs.setInt("IdSuc2", idSuc);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public Sucursal BuscarSucursal(String nombreSuc) throws SQLException {
        Connection cnn = null;
        Sucursal suc = null;
        int resultado;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BuscarSucursal( ? ) }");
            cs.setString("nombresuc2", nombreSuc);
            cs.execute();
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                rs.first();
                suc = new Sucursal(
                        rs.getInt("idSuc"),
                        rs.getString("NombreSuc"),
                        rs.getString("Telefono"));
                Ubicacion ub = new Ubicacion();
                ub.setId(rs.getInt("IdUbic"));
                ub.setDireccion(rs.getString("Direccion"));
                ub.setBarrio(rs.getString("Barrio"));
                ub.setCiudad(rs.getString("Ciudad"));
                suc.setUbicacion(ub);
            }

            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            ex.printStackTrace();
        } finally {
            cnn.close();
        }
        return suc;
    }

    @Override
    public LinkedList<Sucursal> ListarSucursales() throws SQLException {
        Connection cnn = null;
        Sucursal suc = null;
        LinkedList<Sucursal> lista = new LinkedList<Sucursal>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarSucursales() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                suc = new Sucursal();
                suc.setNombreSuc(rs.getString("NombreSuc"));
                suc.setTelefono(rs.getString("Telefono"));
                Ubicacion u = new Ubicacion();
                u.setDireccion(rs.getString("Direccion"));
                u.setBarrio(rs.getString("Barrio"));
                u.setCiudad(rs.getString("Ciudad"));
                suc.setUbicacion(u);
                lista.add(suc);
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
    public LinkedList<Sucursal> ListarSucursalesPorTint(int idTint) throws SQLException {
        Connection cnn = null;
        Sucursal suc = null;
        LinkedList<Sucursal> lista = new LinkedList<Sucursal>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarSucursalesPorTint() }");
            cs.setInt("IdTint2", idTint);
            rs = cs.executeQuery();

            while (rs.next()) {
                suc = new Sucursal();
                suc.setIdSuc(rs.getInt("IdSuc"));
                suc.setNombreSuc(rs.getString("NombreSuc"));
                suc.setTelefono(rs.getString("Telefono"));
                Ubicacion u = new Ubicacion();
                u.setId(rs.getInt("IdUbic"));
                u.setDireccion(rs.getString("Direccion"));
                u.setBarrio(rs.getString("Barrio"));
                u.setCiudad(rs.getString("Ciudad"));
                suc.setUbicacion(u);
                lista.add(suc);
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
    public void BajaRelacion_TintoreriasSucursales(int idTint, int idSuc) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaRelacion_TintoreriasSucursales( ?, ?, ? ) }");
            cs.setInt("idTint2", idTint);
            cs.setInt("idSuc2", idSuc);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }
}

package Persistencia.Clases;

import Entidades.Objetos.Ubicacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaUbicacion implements Persistencia.Interfaces.IPersistenciaUbicacion {

    private static PersistenciaUbicacion _instancia = null;

    private PersistenciaUbicacion() {
    }

    public static PersistenciaUbicacion getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaUbicacion();
        }
        return _instancia;
    }

    @Override
    public void AltaUbicacion(Ubicacion ub) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int idubic = -1;

            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call AltaUbicacion( ?, ?, ?, ?,?)}");
            cs.setString("Direccion2", ub.getDireccion());
            cs.setString("barrio2", ub.getBarrio());
            cs.setString("ciudad2", ub.getCiudad());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.registerOutParameter("increment", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            idubic = cs.getInt("increment");
            ub.setId(idubic);
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
    public void ModificarUbicacion(Ubicacion ub) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            int idubic = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarUbicacion( ?, ?, ?, ?, ?)}");
            cs.setInt("id2", ub.getId());
            cs.setString("Direccion2", ub.getDireccion());
            cs.setString("barrio2", ub.getBarrio());
            cs.setString("ciudad2", ub.getCiudad());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.registerOutParameter("increment", java.sql.Types.INTEGER);
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
    public void BajaRelacion_ubicsucursales(int idubic, int idsuc) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaRelacion_ubicsucursales( ?, ?, ? ) }");
            cs.setInt("idubic2", idubic);
            cs.setInt("idSuc2", idsuc);
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
      public void Bajarelacion_ubictintorerias(int idubic, int idtint) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call Bajarelacion_ubictintorerias( ?, ?, ? ) }");
            cs.setInt("idubic2", idubic);
            cs.setInt("idTint2", idtint);
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
    public void BajaUbicacion(int id) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaUbicacion( ?, ? ) }");
            cs.setInt("id2", id);
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
    public Ubicacion BuscarUbicacion(String direccion) throws SQLException {
        Connection cnn = null;
        Ubicacion ub = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false); 

            CallableStatement cs = cnn.prepareCall("{ call BuscarUbicacion( ? ) }");
            cs.setString("Direccion2", direccion);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                rs.first();
                ub = new Ubicacion();
                ub.setId(rs.getInt("id"));
                ub.setBarrio(rs.getString("Barrio"));
                ub.setCiudad(rs.getString("Ciudad"));
                ub.setDireccion(rs.getString("Direccion"));
            }
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            ex.printStackTrace();
        } finally {
            cnn.close();
        }
        return ub;
    }

    @Override
    public LinkedList<Ubicacion> ListarUbicaciones() throws SQLException {
        Connection cnn = null;
        Ubicacion ub = null;
        LinkedList<Ubicacion> lista = new LinkedList<Ubicacion>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarUbicaciones() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                ub = new Ubicacion();
                ub.setDireccion(rs.getString("Direccion"));
                ub.setBarrio(rs.getString("Barrio"));
                ub.setCiudad(rs.getString("Ciudad"));
                
                lista.add(ub);
            }
            cnn.commit();
        } 
        catch (Exception ex) {
            cnn.rollback();
        } 
        finally {
            cnn.close();
            rs.close();
        }
        return lista;
    }

}

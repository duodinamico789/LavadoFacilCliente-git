package Persistencia.Clases;

import Entidades.Datatypes.PrendaExtended;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import Entidades.Objetos.Tintoreria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaPrendas implements Persistencia.Interfaces.IPersistenciaPrendas {

    private static PersistenciaPrendas _instancia = null;

    private PersistenciaPrendas() {
    }

    public static PersistenciaPrendas getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaPrendas();
        }
        return _instancia;
    }

    @Override
    public void AltaPrendaEnvio(PrendaEnvio pre) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;

            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaPrendaEnvio( ?, ?, ?, ?)}");
            cs.setInt("IdPda2", pre.getIdpren().getIdpda());
            cs.setInt("IdTint2", pre.getIdtint().getIdTint());
            cs.setBigDecimal("Precio2", pre.getPrecio());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if (resultado == -2) {
                throw new Exception("Tipo de prenda ya existente");
            }
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public void ModificarPrendaEnvio(PrendaEnvio pre) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarPrendaEnvio( ?, ?, ?, ?)}");
            cs.setInt("IdPda2", pre.getIdpren().getIdpda());
            cs.setInt("IdTint2", pre.getIdtint().getIdTint());
            cs.setBigDecimal("Precio2", pre.getPrecio());
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
    public void BajaPrendaEnvio(int id) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaPrendaEnvio( ?, ? ) }");
            cs.setInt("Id2", id);
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
    public void AltaPrenda(Prenda pre) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;

            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call AltaPrenda( ?, ?, ?)}");
            cs.setString("tipo2", pre.getTipo());
            cs.setBoolean("aplicaTint2", (Boolean) pre.getTintoreria());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            if (resultado == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            if (resultado == -2) {
                throw new Exception("Tipo de prenda ya existente");
            }

            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.close();
        }
    }

    @Override
    public void ModificarPrenda(Prenda pre) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarPrenda( ?, ?, ?, ?)}");
            cs.setInt("idPda2", pre.getIdpda());
            cs.setString("Tipo2", pre.getTipo());
            cs.setBoolean("aplicaTint2", (Boolean) pre.getTintoreria());
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
    public void BajaPrenda(int idPda) throws SQLException {
        Connection cnn = null;

        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaPrenda( ?, ? ) }");
            cs.setInt("IdPda2", idPda);
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
    public Prenda BuscarPrenda(String pda) throws SQLException {
        Connection cnn = null;
        Prenda pre = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BuscarPrenda( ? ) }");
            cs.setString("tipo2", pda);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                rs.first();
                pre = new Prenda(
                        rs.getInt("idPda"),
                        rs.getString("Tipo"),
                        rs.getBoolean("aplicaTint"));
            }
            cnn.commit();
        } catch (Exception ex) {
            cnn.rollback();
            ex.printStackTrace();
        } finally {
            cnn.close();
        }
        return pre;
    }

    @Override
    public LinkedList<Prenda> ListarPrendas(boolean aplicaTint) throws SQLException {
        Connection cnn = null;
        Prenda pre = null;
        LinkedList<Prenda> lista = new LinkedList<Prenda>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarPrendas( ? ) }");
            cs.setBoolean("aplicaTint", aplicaTint);
            rs = cs.executeQuery();

            while (rs.next()) {
                pre = new Prenda(
                        rs.getInt("IdPda"),
                        rs.getString("Tipo"),
                        rs.getBoolean("AplicaTint"));
                lista.add(pre);
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
    public LinkedList<PrendaEnvio> ListarPrendasEnvio() throws SQLException {
        Connection cnn = null;
        PrendaEnvio pre = null;
        LinkedList<PrendaEnvio> lista = new LinkedList<PrendaEnvio>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarPrendaEnvio() }");
            rs = cs.executeQuery();

            while (rs.next()) {
                pre = new PrendaEnvio();
                pre.setId(rs.getInt("Id"));
                Tintoreria tin = new Tintoreria();
                tin.setIdTint(rs.getInt("IdTint"));
                Prenda p = new Prenda();
                p.setIdpda(rs.getInt("IdPda"));
                p.setTipo(rs.getString("Tipo"));
                pre.setPrecio(rs.getBigDecimal("Precio"));
                pre.setIdpren(p);
                pre.setIdtint(tin);
                lista.add(pre);
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
    public LinkedList<PrendaExtended> ListarPrendasXSol(int idSol) throws SQLException
    {
        Connection cnn = null;
        PrendaExtended pre = null;
        LinkedList<PrendaExtended> lista = new LinkedList<PrendaExtended>();
        ResultSet rs = null;
        ResultSet rs2 = null;


        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarPrendasXSol( ? ) }");
            cs.setInt("idSol", idSol);
            rs = cs.executeQuery();

            while (rs.next()) {

                pre = new PrendaExtended();
                Prenda p = new Prenda();
                pre.setCantPrendas(rs.getInt("Cantidad"));
                p.setTipo(rs.getString("Tipo"));
                p.setIdpda(rs.getInt("IdPda"));
                p.setTintoreria( rs.getBoolean("AplicaTint"));
                LinkedList<Excepcion> ex = FabricaPersistencia.getInstancia().getIpersistenciaExcepciones().ListarExcepciones(p.getIdpda());
                p.setExcepcionesList(ex);
                pre.setPrenda(p);



                lista.add(pre);
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
    public LinkedList<PrendaEnvio> ListarPrendasEnvioXIdPren(int idPren) throws SQLException {
        Connection cnn = null;
        PrendaEnvio pre = null;
        LinkedList<PrendaEnvio> lista = new LinkedList<PrendaEnvio>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarPrendasEnvioXIdPren(?) }");
            cs.setInt("idpren", idPren);
            rs = cs.executeQuery();

            while (rs.next()) {
                pre = new PrendaEnvio();
                pre.setId(rs.getInt("Id"));
                Tintoreria tin = new Tintoreria();
                tin.setIdTint(rs.getInt("IdTint"));
                tin.setNombre(rs.getString("Nombre"));
                Prenda p = new Prenda();
                p.setIdpda(rs.getInt("IdPda"));
                p.setTipo(rs.getString("Tipo"));
                pre.setPrecio(rs.getBigDecimal("Precio"));
                pre.setIdpren(p);
                pre.setIdtint(tin);
                lista.add(pre);
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
}

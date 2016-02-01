package Persistencia.Clases;

import Entidades.Enumeraciones.TipoMov;
import Entidades.Exceptions.StoredProcedureException;
import Entidades.Objetos.Movimiento;
import Entidades.Objetos.Sucursal;
import Persistencia.Interfaces.IPersistenciaMovimientos;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaMovimientos implements IPersistenciaMovimientos {

    //<editor-fold defaultstate="collapsed" desc="Singleton">    
    private static PersistenciaMovimientos _instancia = null;

    private PersistenciaMovimientos() {
    }

    public static PersistenciaMovimientos getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaMovimientos();
        }
        return _instancia;
    }
    //</editor-fold>

    @Override
    public int AltaMovimiento(Movimiento mov) throws SQLException {
        Connection cnn = null;
        int resultado = -1;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaMovimiento( ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString("fechaMov2", mov.getFechaMovStrLarge());
            cs.setString("nombreMov2", mov.getNombreMov());
            cs.setInt("tipoMov2", mov.getTipoMov().getValue());
            cs.setString("descripcion2", mov.getDescripcion());
            cs.setDouble("monto2", mov.getMonto().doubleValue());
            cs.setDouble("idSuc2", mov.getSucursal().getIdSuc());

            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();

            resultado = cs.getInt("result");

            if (resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            }

            cnn.commit();
            resultado = 0;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            cnn.rollback();

            if (ex instanceof SQLException) {
                resultado = -3;
            }
        } finally {
            cnn.close();
        }

        return resultado;
    }

    @Override
    public int ModificarMovimiento(Movimiento mov) throws SQLException {
        Connection cnn = null;
        int resultado = -1;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ModificarMovimiento( ?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt("idMov2", mov.getIdMov());
            cs.setString("fechaMov2", mov.getFechaMovStrLarge());
            cs.setString("nombreMov2", mov.getNombreMov());
            cs.setInt("tipoMov2", mov.getTipoMov().getValue());
            cs.setString("descripcion2", mov.getDescripcion());
            cs.setDouble("monto2", mov.getMonto().doubleValue());

            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();

            resultado = cs.getInt("result");

            if (resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion. ");
            } else if (resultado == -2) {
                throw new StoredProcedureException("No existe un movimiento con el ID especificado. ");
            }

            cnn.commit();
            resultado = 0;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            cnn.rollback();

            if (ex instanceof SQLException) {
                resultado = -3;
            }
        } finally {
            cnn.close();
        }

        return resultado;
    }

    @Override
    public int BajaMovimiento(int idMov) throws SQLException {
        Connection cnn = null;
        int resultado = -1;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BajaMovimiento( ?, ?)}");
            cs.setInt("idMov2", idMov);

            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();

            resultado = cs.getInt("result");

            if (resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            }

            cnn.commit();
            resultado = 0;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            cnn.rollback();

            if (ex instanceof SQLException) {
                resultado = -3;
            }
        } finally {
            cnn.close();
        }

        return resultado;
    }

    @Override
    public LinkedList<Movimiento> ListarMovimientosPorSucursal(TipoMov tipoMovs, int idSuc) throws SQLException {
        Connection cnn = null;
        Movimiento mov1 = null;
        LinkedList<Movimiento> listMovs = null;

        try {
            //Creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarMovimientosPorSucursal(?, ?) }");
            cs.setInt("tipoMov2", tipoMovs.getValue());
            cs.setInt("idSuc2", idSuc);
            ResultSet rs = cs.executeQuery();

            listMovs = new LinkedList<>();

            while (rs.next()) {
                mov1 = new Movimiento(
                        rs.getInt("IdMov"),
                        rs.getDate("FechaMov"),
                        rs.getString("NombreMov"),
                        TipoMov.valueOf(rs.getInt("TipoMov")),
                        rs.getString("Descripcion"),
                        BigDecimal.valueOf(rs.getDouble("Monto"))
                );

                //TODO: Traer suc. desde persistencia sucursal:
                Sucursal sucAux = new Sucursal();
                sucAux.setIdSuc(rs.getInt("IdSuc"));
                mov1.setSucursal(sucAux);

                listMovs.add(mov1);
            }
            // confirmar si se ejecuto sin errores
            cnn.commit();
        } catch (Exception ex) {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } finally {
            cnn.close();
        }
        return listMovs;
    }

    @Override
    public Movimiento BuscarMovimiento(int idMov) throws SQLException {
        Connection cnn = null;
        Movimiento resultado = null;

        try {
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BuscarMovimiento( ? ) }");
            cs.setInt("idMov2", idMov);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                resultado = new Movimiento(
                        rs.getInt("IdMov"),
                        rs.getDate("FechaMov"),
                        rs.getString("NombreMov"),
                        TipoMov.valueOf(rs.getInt("TipoMov")),
                        rs.getString("Descripcion"),
                        BigDecimal.valueOf(rs.getDouble("Monto"))
                );

                Sucursal sucAux = new Sucursal();
                sucAux.setIdSuc(rs.getInt("IdSuc"));
                sucAux.setNombreSuc(rs.getString("NombreSuc"));
                sucAux.setTelefono(rs.getString("SucTelefono"));
                resultado.setSucursal(sucAux);
            }
            // confirmar si se ejecuto sin errores
            cnn.commit();
        } catch (Exception ex) {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            //if(!Utilidades.IsNull(cnn)) cnn.rollback();
        } finally {
            /*if(!Utilidades.IsNull(cnn))*/ cnn.close();
        }
        return resultado;
    }
}

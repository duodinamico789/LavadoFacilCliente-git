package Persistencia.Clases;

import Entidades.Exceptions.StoredProcedureException;
import Entidades.Objetos.BrechaHoraria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;

public class PersistenciaBrechasHorarias implements Persistencia.Interfaces.IPersistenciaBrechasHorarias {
    private static PersistenciaBrechasHorarias _instancia = null;
    
    private PersistenciaBrechasHorarias() { }
    
    public static PersistenciaBrechasHorarias getInstancia() 
    {
        if(_instancia == null)
            _instancia = new PersistenciaBrechasHorarias();
        return _instancia;
    }

    @Override
    public int AltaBrechaHoraria(BrechaHoraria brecha) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //HoraInicio2 time, HoraFin2 time, Limitees2 int(11), NoDisponible2 bit , out result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaBrechaHoraria( ?, ?, ?, ?, ?, ?)}");
            
            Time time = new Time(brecha.getHoraInicio().getTime());
            cs.setTime("HoraInicio2", time);
            time = new Time(brecha.getHoraFin().getTime());
            cs.setTime("HoraFin2", time); 
            cs.setString("DiasVigencia2", brecha.getDiasVigencia()); 
            cs.setInt("LimiteSol2", brecha.getLimitees());
            cs.setBoolean("NoDisponible2", brecha.getNoDisponible());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            
            resultado = cs.getInt("result");

            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            } else if (resultado == -2) {
                throw new Exception("Error de duplicación de datos en base de datos");
            }

            cnn.commit();
            resultado = 0;
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString());
            cnn.rollback();            
            
            if(ex instanceof StoredProcedureException) {
                resultado = -1;
            } else if (ex instanceof SQLException) {
                resultado = -3;
            } else {
                resultado = -2;
            }
        } 
        finally 
        {
            cnn.close();
        }
        
        return resultado;
    }

    @Override
    public int ModificarBrechaHoraria(Date oldHoraInicio, Date oldHoraFin, BrechaHoraria brecha) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //(HoraInicio2 time, HoraFin2 time, NewHoraInicio2 time, NewHoraFin2 time, 
        //Limitees2 int(11), NoDisponible2 bit, out result int//
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call ModificarBrechaHoraria( ?, ?, ?, ?, ?, ?, ?, ?)}");
            
            Time time = new Time(oldHoraInicio.getTime());
            cs.setTime("HoraInicio2", time);
            time = new Time(oldHoraFin.getTime());
            cs.setTime("HoraFin2", time); 
            time = new Time(brecha.getHoraInicio().getTime());
            cs.setTime("NewHoraInicio2", time);
            time = new Time(brecha.getHoraFin().getTime());
            cs.setTime("NewHoraFin2", time); 
            
            cs.setString("DiasVigencia2", brecha.getDiasVigencia());
            cs.setInt("Limitees2", brecha.getLimitees());
            cs.setBoolean("NoDisponible2", brecha.getNoDisponible());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);

            cs.execute();
            
            resultado= cs.getInt("result");

            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            }

            cnn.commit();
            resultado = 0;
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString());
            cnn.rollback();            
            
            if(ex instanceof StoredProcedureException) {
                resultado = -1;
            } else if (ex instanceof SQLException) {
                resultado = -3;
            } else {
                resultado = -2;
            }
        } 
        finally 
        {
            cnn.close();
        }
        
        return resultado;
    }

    @Override
    public int BajaBrechaHoraria(Date horaInicio, Date horaFin) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //HoraInicio2 time, HoraFin2 time, OUT result int
        
        try 
        {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BajaBrechaHoraria( ?, ?, ?)}");
            
            Time time = new Time(horaInicio.getTime());
            cs.setTime("HoraInicio2", time);
            time = new Time(horaFin.getTime());
            cs.setTime("HoraFin2", time); 
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            
            resultado = cs.getInt("result");

            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            }

            cnn.commit();
            resultado = 0;
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString());
            cnn.rollback();            
            
            if(ex instanceof StoredProcedureException) {
                resultado = -1;
            } else if (ex instanceof SQLException) {
                resultado = -3;
            } else {
                resultado = -2;
            }
        } 
        finally 
        {
            cnn.close();
        }
        
        return resultado;
    }

    @Override
    public BrechaHoraria BuscarBrechaHoraria(Date horaInicio, Date horaFin) throws SQLException {
        Connection cnn = null;
        BrechaHoraria resultado = null;
        
        //Parametros definidos en bd:
        ////HoraInicio2 time, HoraFin2 time
        
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call BuscarBrechaHoraria( ?, ? ) }");
            Time time = new Time(horaInicio.getTime());
            cs.setTime("HoraInicio2", time);
            time = new Time(horaFin.getTime());
            cs.setTime("HoraFin2", time); 
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()) {
                java.sql.Time sqlTime = rs.getTime("HoraInicio");
                java.util.Date sqlTimeConverted = new java.util.Date(sqlTime.getTime());
                java.sql.Time sqlTime2 = rs.getTime("HoraFin");
                java.util.Date sqlTimeConverted2 = new java.util.Date(sqlTime2.getTime());
                
                resultado = new BrechaHoraria(sqlTimeConverted, sqlTimeConverted2);
                resultado.setDiasVigencia(rs.getString("DiasVigencia"));
                resultado.setLimitees(rs.getInt("Limitees"));
                resultado.setNoDisponible(rs.getBoolean("NoDisponible"));
            }         
            // confirmar si se ejecuto sin errores
            cnn.commit();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
        } 
        return resultado;
    }

    @Override
    public LinkedList<BrechaHoraria> ListarBrechasHorarias() throws SQLException {
        Connection cnn = null;
        BrechaHoraria bh1 = null;
        LinkedList<BrechaHoraria> brechasHorarias = null;
        
        //Parametros definidos en bd:
        //HoraInicio2 time, HoraFin2 time
        
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call ListarBrechasHorarias() }");
            ResultSet rs = cs.executeQuery();
            
            brechasHorarias = new LinkedList<>();
            
            while(rs.next()) {
                java.sql.Time sqlTime = rs.getTime("HoraInicio");
                java.util.Date sqlTimeConverted = new java.util.Date(sqlTime.getTime());
                java.sql.Time sqlTime2 = rs.getTime("HoraFin");
                java.util.Date sqlTimeConverted2 = new java.util.Date(sqlTime2.getTime());
                
                bh1 = new BrechaHoraria(sqlTimeConverted, sqlTimeConverted2);
                bh1.setDiasVigencia(rs.getString("DiasVigencia"));
                bh1.setLimitees(rs.getInt("LimiteSol"));
                bh1.setNoDisponible(rs.getBoolean("NoDisponible"));
                
                brechasHorarias.add(bh1);
            }         
            // confirmar si se ejecuto sin errores
            cnn.commit();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
        } 
        return brechasHorarias;
    }
    
}

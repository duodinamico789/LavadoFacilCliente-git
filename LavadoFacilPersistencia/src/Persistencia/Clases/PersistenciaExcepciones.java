package Persistencia.Clases;
import Entidades.Exceptions.DuplicateKeyException;
import Entidades.Exceptions.StoredProcedureException;
import Entidades.Objetos.Excepcion;
import Persistencia.Interfaces.IPersistenciaExcepciones;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaExcepciones implements IPersistenciaExcepciones {
    
    private static PersistenciaExcepciones _instancia = null;
    
    private PersistenciaExcepciones() { }
    
    public static PersistenciaExcepciones getInstancia() 
    {
        if(_instancia == null)
            _instancia = new PersistenciaExcepciones();
        return _instancia;
    }
    @Override
    public int AltaExcepcion(Excepcion excepcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaExcepcion( ?, ?)}");
            cs.setString("Nombre2", excepcion.getNombre());
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
    public int ModificarExcepcion(String oldNombre, Excepcion excepcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), NewNombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call ModificarExcepcion( ?, ?, ?)}");
            cs.setString("Nombre2", oldNombre);
            cs.setString("NewNombre2", excepcion.getNombre());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            
            resultado= cs.getInt("result");

            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            } else if (resultado == -2) {
                throw new DuplicateKeyException("El nombre ya existe en la base de datos. Pruebe con otro. ");
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
    public int BajaExcepcion(Excepcion excepcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BajaExcepcion( ?, ?)}");
            cs.setString("Nombre2", excepcion.getNombre());
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
    public LinkedList<Excepcion> ListarExcepciones() throws SQLException {
        Connection cnn = null;
        Excepcion excepcion1 = null;
        LinkedList<Excepcion> excepcions = null;
        
        //Parametros definidos en bd:
        //
        
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call ListarExcepciones() }");
            ResultSet rs = cs.executeQuery();
            
            excepcions = new LinkedList<>();
            
            while(rs.next()) {
                excepcion1 = new Excepcion(rs.getString("Nombre"));      
                excepcion1.setid(rs.getInt("IdExc"));
                excepcions.add(excepcion1);
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
        return excepcions;
    }

    @Override
    public Excepcion BuscarExcepcion(String nomExcepcion) throws SQLException {
        Connection cnn = null;
        Excepcion resultado = null;
        
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call BuscarExcepcion( ? ) }");
            cs.setString("Nombre2", nomExcepcion);
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()) {
                resultado = new Excepcion(rs.getString("Nombre"));
                resultado.setid(rs.getInt("IdExc"));
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
}

package Persistencia.Clases;
import Entidades.Exceptions.DuplicateKeyException;
import Entidades.Exceptions.StoredProcedureException;
import Entidades.Objetos.Opcion;
import Persistencia.Interfaces.IPersistenciaOpciones;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaOpciones implements IPersistenciaOpciones {
    
    private static PersistenciaOpciones _instancia = null;
    
    private PersistenciaOpciones() { }
    
    public static PersistenciaOpciones getInstancia() 
    {
        if(_instancia == null)
            _instancia = new PersistenciaOpciones();
        return _instancia;
    }
    @Override
    public int AltaOpcion(Opcion opcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaOpcion( ?, ?, ?)}");
            cs.setString("Nombre2", opcion.getNombre());
            cs.setDouble("Precio2", opcion.getPrecio().doubleValue());
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
    public int ModificarOpcion(String oldNombre, Opcion opcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), NewNombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call ModificarOpcion( ?, ?, ?, ?, ?)}");
            cs.setInt("IdOpc2", opcion.getidOpcion());
            cs.setString("Nombre2", oldNombre);
            cs.setString("NewNombre2", opcion.getNombre());
            cs.setDouble("Precio2", opcion.getPrecio().doubleValue());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            
            resultado= cs.getInt("result");

            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            } else if (resultado == -2) {
                throw new DuplicateKeyException("La opcion con el nombre especificado ya existente!");
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
    public int BajaOpcion(Opcion opcion) throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        
        //Parametros definidos en bd:
        //Nombre2 varchar(50), OUT result int
        
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BajaOpcion( ?, ?)}");
            cs.setInt("IdOpc2", opcion.getidOpcion());
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
    public LinkedList<Opcion> ListarOpciones() throws SQLException {
        Connection cnn = null;
        Opcion opcion1 = null;
        LinkedList<Opcion> opcions = null;
        
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call ListarOpciones() }");
            ResultSet rs = cs.executeQuery();
            
            opcions = new LinkedList<>();
            
            while(rs.next()) {
                
                opcion1 = new Opcion(rs.getString("NombreOpc"));                
                opcion1.setidOpcion(rs.getInt("IdOpc"));
                opcion1.setPrecio(new BigDecimal(rs.getDouble("Precio")));
                opcions.add(opcion1);
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
        return opcions;
    }
    
    @Override
    public LinkedList<Opcion> ListarOpcionesXSol(int idSol) throws SQLException {
        Connection cnn = null;
        Opcion opcion1 = null;
        LinkedList<Opcion> opcions = null;
        
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call ListarOpcionesXSol(?) }");
            cs.setInt("idSol", idSol);
            ResultSet rs = cs.executeQuery();
            
            opcions = new LinkedList<>();
            
            while(rs.next()) {               
                opcion1 = new Opcion(rs.getString("NombreOpc"));                
                opcion1.setidOpcion(rs.getInt("IdOpc"));
                opcion1.setPrecio(new BigDecimal(rs.getDouble("Precio")));
                opcions.add(opcion1);
            }
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
        return opcions;
    }

    @Override
    public Opcion BuscarOpcion(int idOpcion) throws SQLException {
        Connection cnn = null;
        Opcion resultado = null;
                
        try {            
            // creamos la conexion
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            
            CallableStatement cs = cnn.prepareCall("{ call BuscarOpcion( ? ) }");
            cs.setInt("IdOpc2", idOpcion);
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()) {
                resultado = new Opcion(rs.getString("NombreOpc"));                
                resultado.setidOpcion(rs.getInt("IdOpc"));
                resultado.setPrecio(new BigDecimal(rs.getDouble("Precio")));
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

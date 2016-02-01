package Persistencia.Clases;

import Entidades.Exceptions.StoredProcedureException;
import Entidades.Objetos.Tintoreria;
import Entidades.Objetos.Ubicacion;
import Entidades.Objetos.Sucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PersistenciaTintorerias implements Persistencia.Interfaces.IPersistenciaTintoreria {
    private static PersistenciaTintorerias _instancia = null;
    
    private PersistenciaTintorerias() { }
    
    public static PersistenciaTintorerias getInstancia() 
    {
        if(_instancia == null)
            _instancia = new PersistenciaTintorerias();
        return _instancia;
    }
    
    @Override
    public int AltaTintoreria(Tintoreria tintoreria)  throws SQLException {
        Connection cnn = null;
        int resultado = -1;
        int resultado2 = -1;
        int resultado3 = -1;
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call AltaTintoreria( ?, ?, ?, ?)}");
            cs.setString("Nombre2", tintoreria.getNombre());
            cs.setString("Telefono2", tintoreria.getTelefono());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.registerOutParameter("increment", java.sql.Types.INTEGER);
            cs.execute();           
            int idtint = cs.getInt("increment");
            tintoreria.setIdTint(idtint);
            resultado = cs.getInt("result");
            if(resultado == 1){
                CallableStatement cs2 = cnn.prepareCall("{call Altarelacion_ubictintorerias(?,?,?)}");
                cs2.setInt("idTint2", tintoreria.getIdTint());
                cs2.setInt("idubic2", tintoreria.getUbicacion().getId());
                cs2.registerOutParameter("result", java.sql.Types.INTEGER);
                cs2.execute();
                resultado2 =  cs2.getInt("result");
                if(resultado2==1)
                {
                    LinkedList<Sucursal> suc;
                    suc = (LinkedList<Sucursal>) tintoreria.getSucursalCercana();
                    for(int i=0;i<suc.size();i++)
                    {
                        int idsuc = suc.get(i).getIdSuc();
                        CallableStatement cs3 = cnn.prepareCall("{call AltaRelacion_TintoreriasSucursales(?,?,?)}");
                        cs3.setInt("idTint2", tintoreria.getIdTint());
                        cs3.setInt("idSuc2", idsuc);
                        cs3.registerOutParameter("result", java.sql.Types.INTEGER);
                        cs3.execute();
                        resultado3 =  cs3.getInt("result");

                        if(resultado3==-1)
                        {
                          throw new Exception("Error al intentar ejecutar la operacion");
                        }
                    }
                }
                if(resultado2 == -1) {
                  throw new StoredProcedureException("Error al intentar ejecutar la operacion");
                }  
                if(resultado == -1) {
                    throw new StoredProcedureException("Error al intentar ejecutar la operacion");
                }
                cnn.commit();
                resultado = 0;
        } 
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
    public int BajaTintoreria(int idtint)  throws SQLException {
        Connection cnn = null;
        int resultado= -1;
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call BajaTintoreria( ?, ?)}");
            cs.setInt("idTint2", idtint);
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
    
//    @Override
//    public Tintoreria BuscarTintoreria(String nombre) throws SQLException { 
//        Connection cnn = null;
//        Tintoreria tin = null;
//        int resultado;
//        
//        try { 
//            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
//            cnn.setAutoCommit(false);
//            
//            CallableStatement cs = cnn.prepareCall("{ call BuscarTintoreria( ?,? ) }");
//            cs.setString("Nombre2", nombre);
//            cs.registerOutParameter("result", java.sql.Types.INTEGER);
//            cs.execute();
//            resultado = cs.getInt("result");
//            
//            if(resultado ==1)
//            {
//             CallableStatement cs2 = cnn.prepareCall("{ call BuscarTintoreria( ?,? ) }");
//             cs2.setString("Nombre2", nombre);
//             cs2.registerOutParameter("result", java.sql.Types.INTEGER);
//             cs2.execute();
//             ResultSet rs = cs.executeQuery();
//             ResultSet rs2 = cs2.executeQuery();
//             LinkedList<Sucursal> sucus = new LinkedList<Sucursal>();
//            while(rs.next())
//            {
//              Sucursal s = new Sucursal();
//              Ubicacion ub2 = new Ubicacion();
//              ub2.setDireccion(rs.getString("Direccion"));//arreglar direccion de tintoreria
//              s.setIdSuc(rs.getInt("IdSuc"));
//              s.setNombreSuc(rs.getString("NombreSuc")); 
//              s.setUbicacion(ub2);
//              sucus.add(s);
//            }
//            if(rs2.next()) {
//                rs2.first();
//                tin = new Tintoreria();
//                tin.setIdTint(rs2.getInt("IdTint"));
//                tin.setNombre(rs2.getString("Nombre"));
//                tin.setTelefono(rs2.getString("Telefono"));
//                Ubicacion ub = new Ubicacion();
//                ub.setId(rs2.getInt("Id"));
//                ub.setDireccion(rs2.getString("Direccion"));
//                ub.setBarrio(rs2.getString("Barrio"));
//                ub.setCiudad(rs2.getString("Ciudad"));
//                tin.setUbicacion(ub);
//                tin.setSucursalCercana(sucus);
//            }
//            }
//            else if(resultado==2)
//            {
//                ResultSet rs = cs.executeQuery();
//                if(rs.next()) {
//                tin = new Tintoreria();
//                tin.setIdTint(rs.getInt("IdTint"));
//                tin.setNombre(rs.getString("Nombre"));
//                tin.setTelefono(rs.getString("Telefono"));
//                Ubicacion ub = new Ubicacion();
//                ub.setDireccion(rs.getString("Direccion"));
//                ub.setBarrio(rs.getString("Barrio"));
//                ub.setCiudad(rs.getString("Ciudad"));
//                tin.setUbicacion(ub);
//                tin.setSucursalCercana(null);
//            }
//            }
//            else if( resultado==-1)
//            {
//             throw new Exception("Error al intentar ejecutar la operacion");
//            }
//            cnn.commit();
//        } 
//        catch (Exception ex) 
//        {
//            System.out.println(ex.toString() + " - " + ex.getMessage());
//            cnn.rollback();
//        } 
//        finally 
//        {
//            cnn.close();
//        } 
//        return tin;
//    } 
    
    @Override
    public Tintoreria BuscarTintoreria(String nombre) throws SQLException {
        Connection cnn = null;
        Tintoreria tin = null;
        int resultado;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BuscarTintoreria2( ?,? ) }");
            cs.setString("Nombre2", nombre);
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");

            if (resultado != -1) {
                ResultSet rs = cs.executeQuery();
                LinkedList<Sucursal> sucus = new LinkedList<Sucursal>();
                while (rs.next()) {
                    tin = new Tintoreria();
                    int idTint = rs.getInt("IdTint");
                    tin.setIdTint(idTint);
                    tin.setNombre(rs.getString("Nombre"));
                    tin.setTelefono(rs.getString("Telefono"));
                    Ubicacion ub = new Ubicacion();
                    ub.setId(rs.getInt("Id"));
                    ub.setDireccion(rs.getString("Direccion"));
                    ub.setBarrio(rs.getString("Barrio"));
                    ub.setCiudad(rs.getString("Ciudad"));
                    tin.setUbicacion(ub);
                    
                    tin.setSucursalCercana(PersistenciaSucursales.getInstancia().ListarSucursalesPorTint(idTint));
                    //Aca hacer un metodo en persistenciaSucursales "ListarSucursalesPorTint"
                    //Para traer la lista de sucs asociadas
                    
                }
            } else {
                throw new Exception("Error al intentar ejecutar la operacion");
            }
            cnn.commit();
        } catch (Exception ex) {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } finally {
            cnn.close();
        }
        return tin;
    }
    
    @Override
    public int ModificarTintoreria(Tintoreria tintoreria) throws SQLException {
        Connection cnn = null;
        int resultado = -1;
        int resultado2 = -1;
        int resultado3 = -1;
        try 
        {            
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            CallableStatement cs = cnn.prepareCall("{ call ModificarTintoreria(?, ?, ?, ?)}");
            cs.setInt("idTint2", tintoreria.getIdTint());
            cs.setString("Nombre2", tintoreria.getNombre());
            cs.setString("Telefono2", tintoreria.getTelefono());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
            
            resultado= cs.getInt("result");
            if(resultado == 1){
            CallableStatement cs2 = cnn.prepareCall("{call Altarelacion_ubictintorerias(?,?,?)}");
            cs2.setInt("idubic2", tintoreria.getUbicacion().getId());
            cs2.setInt("idTint2", tintoreria.getIdTint());
            cs2.registerOutParameter("result", java.sql.Types.INTEGER);
            cs2.execute();
            resultado2 =  cs2.getInt("result");
            
            if(resultado2==1 || resultado2==-2)           {
            LinkedList<Sucursal> suc;
            suc = (LinkedList<Sucursal>) tintoreria.getSucursalCercana();
            for(int i=0;i<suc.size();i++)
            {
            int idsuc = suc.get(i).getIdSuc();
            CallableStatement cs3 = cnn.prepareCall("{call AltaRelacion_TintoreriasSucursales(?,?,?)}");
            cs3.setInt("idTint2", tintoreria.getIdTint());
            cs3.setInt("idSuc2", idsuc);
            cs3.registerOutParameter("result", java.sql.Types.INTEGER);
            cs3.execute();
            resultado3 =  cs3.getInt("result");
            
            if(resultado3==-1)
            {
              throw new Exception("Error al intentar ejecutar la operacion");
            }
            }
            }
            if(resultado2 == -1) {
              throw new Exception("Error al intentar ejecutar la operacion");
            }  
            if(resultado == -1) {
                throw new StoredProcedureException("Error al intentar ejecutar la operacion");
            }
            resultado = 0;
            cnn.commit();
        }} 
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
    public LinkedList<Tintoreria> ListarTintorerias() throws SQLException {
        Connection cnn = null;
        Tintoreria tint1 = null;
        LinkedList<Tintoreria> tintorerias = null;
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            LinkedList<Sucursal>ssss = new LinkedList<Sucursal>();
            CallableStatement cs = cnn.prepareCall("{ call ListarTintorerias() }");
            CallableStatement cs2 = cnn.prepareCall("{ call ListarTintorerias() }");
            ResultSet rs = cs.executeQuery();
            ResultSet rs2 = cs2.executeQuery();
            tintorerias = new LinkedList<>();
            while(rs.next()) {      //NO ANDA, VER COMO TRAER LA LISTA DE SUCURSALES EN TINTORERIA    
              while(rs2.next())
              {
              Sucursal s = new Sucursal();
              s.setIdSuc(rs2.getInt("IdSuc"));
              s.setNombreSuc(rs2.getString("NombreSuc"));
              ssss.add(s);
              }          
              tint1 = new Tintoreria();
              tint1.setNombre(rs.getString("Nombre"));
              tint1.setTelefono(rs.getString("Telefono"));
              Ubicacion u = new Ubicacion();
              u.setDireccion(rs.getString("Direccion"));
              u.setBarrio(rs.getString("Barrio"));
              u.setCiudad(rs.getString("Ciudad"));
              tint1.setUbicacion(u);
              tint1.setSucursalCercana(ssss);
              tintorerias.add(tint1);
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
        return tintorerias;
    }
}

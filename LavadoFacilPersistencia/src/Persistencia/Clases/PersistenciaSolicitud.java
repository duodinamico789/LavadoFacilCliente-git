package Persistencia.Clases;

import Entidades.Enumeraciones.EstadosSolicitud;
import Entidades.Objetos.BrechaHoraria;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Opcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.Solicitud;
import Entidades.Objetos.SolicitudDetalle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import Persistencia.Interfaces.IPersistenciaSolicitud;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;

public class PersistenciaSolicitud implements IPersistenciaSolicitud{
    
    private static PersistenciaSolicitud _instancia = null;
    boolean delivery;
    private PersistenciaSolicitud() {
    }
    public static PersistenciaSolicitud getInstancia() {
        if (_instancia == null) {
            _instancia = new PersistenciaSolicitud();
        }
        return _instancia;
    }

    @Override
    public void AltaSolicitud(Solicitud sol) throws SQLException {
        Connection cnn = null;
        try {
            long f = Date.from(Instant.now()).getTime();
            String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(f);
            String fecha2 = new java.text.SimpleDateFormat("yyyy-MM-dd").format(sol.getFechaEntrega());
            int resultado = -1;
            int resultado2 = -1;
            int resultado3 = -1;
            int resultado4 = -1;

            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call AltaSolicitud(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString("fechaIngreso2", fecha);
            cs.setString("Observaciones2", sol.getObservaciones());
            cs.setString("fechaEntrega2", fecha2);
            cs.setString("estado2", sol.getEstado().toString());
            cs.setString("cedulaCli2", sol.getCedulaCli().getCedula());
            cs.setString("cedulaEmp2", sol.getCedulaEmp().getCedula());
            cs.setBoolean("ConDelivery2", sol.getDelivery());
            cs.setInt("idSuc2", sol.getNomSucursal().getIdSuc());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.registerOutParameter("increment", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("result");
            int idSol = cs.getInt("increment");
            
            if(resultado == 1){
              
               CallableStatement cs7 = cnn.prepareCall("{ call AltaRelacion_solicitudesopciones(?,?,?)}");
               List<Opcion> listaOp = sol.getOpcionesList();
               for(int i=0;i<listaOp.size();i++)
               {
                cs7.setInt("IdSol2", idSol);
                cs7.setInt("IdOpcion2", listaOp.get(i).getidOpcion());
                cs7.registerOutParameter("result", java.sql.Types.INTEGER);
                cs7.execute();
                resultado2 = cs7.getInt("result");
                if (resultado2 == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
               }
               }
               
            if(resultado2 == 1)
            {
                CallableStatement cs8 = cnn.prepareCall("{ call AltaSolicitudDetalle(?, ?, ?, ?, ?, ?, ?)}");
                List<SolicitudDetalle> sd = sol.getDetalles();
                for(int i=0;i<sd.size();i++)
                {
                double r = 22;
                cs8.setInt("idSol2", idSol);
                cs8.setInt("linea2", sol.getDetalles().get(i).getLinea());
                cs8.setDouble("precio2",r );
                cs8.setInt("cantidad2", sol.getDetalles().get(i).getCantidad());
                cs8.setString("descripcion2", sol.getDetalles().get(i).getDescripcion());
                cs8.setInt("idPda2", sol.getDetalles().get(i).getPrenda().getIdpda());
                cs8.registerOutParameter("result", java.sql.Types.INTEGER);
                cs8.execute();
                resultado3 = cs8.getInt("result");
                }
            }
            else if(resultado3 == -1)
            {
             throw new Exception("Error al ejecutar la operacion");
            }
               if(resultado3 == 1 && sol.getDelivery()==true)
               {
                CallableStatement cs3 = cnn.prepareCall("{ call AltaRelacion_solicitudesbrechas(?, ?, ?, ?)}");
                cs3.setInt("IdSol2", idSol);
                Time horaI = new Time(sol.getBrechaHoraria().getHoraInicio().getTime());
                Time horaF = new Time (sol.getBrechaHoraria().getHoraFin().getTime());
                cs3.setTime("HoraInicio2", horaI);
                cs3.setTime("HoraFin2", horaF);
                cs3.registerOutParameter("result", java.sql.Types.INTEGER);
                cs3.execute();
                resultado4 = cs3.getInt("result");                
               }
               if (resultado4 == -1) {
                throw new Exception("Error al intentar ejecutar la operacion");
               }
            }
            else if (resultado == -1) {
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
    public void ModificarSolicitud(Solicitud sol)throws SQLException
    {
    Connection cnn =null;
        try 
        {
          long f = Date.from(Instant.now()).getTime();
          String fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").format(f);  
          int resultado = -1;
          cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
          cnn.setAutoCommit(false);
          
          CallableStatement cs = cnn.prepareCall("{ call ModificarSolicitd(?, ?, ?, ?, ?, ?)}");
            cs.setString("fechaIngreso2", fecha);
            cs.setString("Observaciones2", sol.getObservaciones());
            cs.setString("fechaEntrega2", null);
            cs.setString("estado2", sol.getEstado().toString());
            cs.setString("cedulaCli2", sol.getCedulaCli().getCedula());
            cs.setBoolean("ConDelivery2", sol.getDelivery());
            cs.registerOutParameter("result", java.sql.Types.INTEGER);
            cs.execute();
          resultado= cs.getInt("result");
            if(resultado == 1){

          }
          if(resultado == -1) {
              throw new Exception("Error al intentar ejecutar la operacion");
          }  
          cnn.commit();
        } 
        catch (Exception e) 
        {
            cnn.rollback();
        } 
        finally 
        {
            cnn.close();
        } 
    }
    
    @Override
    public void BajaSolicitud(int id) throws SQLException {
        Connection cnn = null;
        try {
            int resultado = -1;
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call BajaSolicitud( ?, ? ) }");
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
    public LinkedList<Solicitud> ListarSolicitud() throws SQLException {
        Connection cnn = null;
        Solicitud s = null;
        LinkedList<Solicitud> lista = new LinkedList<Solicitud>();
        ResultSet rs = null;

        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);

            CallableStatement cs = cnn.prepareCall("{ call ListarSolicitudes() }");
            rs = cs.executeQuery();

            //FIJARSE BIEN TEMA DE LA LISTA EN BASE DE DATOS Y QUE SE VA A MOSTRAR
//            while (rs.next()) {
//                s = new Solicitud();
//                s.setCedulaCli(rs.getString("cliente"));
                
//                lista.add(s);
//            }
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
    
    @Override
    public Solicitud BuscarSolicitudXId(int idSol) throws SQLException {
        Connection cnn = null;
        Solicitud sol = null;
    
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            delivery = false; 
            CallableStatement cs = cnn.prepareCall("{ call BuscarSolicitudXId(?) }");
            cs.setInt("idSol", idSol);
            cs.execute();
            ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    sol = new Solicitud();
                    Cliente c = new  Cliente();
                    Empleado e = new Empleado();
                    SolicitudDetalle sd = new SolicitudDetalle();
                    int Id = rs.getInt("Id");
                    sol.setId(Id);
                    c.setCedula(rs.getString("CedulaCli"));
                    e.setCedula(rs.getString("CedulaEmp"));
                    delivery = rs.getBoolean("ConDelivery");
                    sol.setDelivery(delivery);
                    sol.setEstado(EstadosSolicitud.valueOf(rs.getString("Estado")));
                    sol.setFechaEntrega(rs.getDate("FechaEntrega"));
                    sol.setFechaIngreso(rs.getDate("FechaIngreso"));
                    sol.setObservaciones(rs.getString("Observaciones"));
                    sol.setCedulaCli(c);
                    sol.setEmpleado(e);
                    sol.setOpcionesList(PersistenciaOpciones.getInstancia().ListarOpcionesXSol(idSol));
                    sol.setPrendas(PersistenciaPrendas.getInstancia().ListarPrendasXSol(idSol));
                }
            if(delivery == true)
            {
                CallableStatement cs2 = cnn.prepareCall("{ call listarBrechasXSol(?) }");
                cs2.setInt("idSol", idSol);
                cs2.execute();
                ResultSet rs2 = cs2.executeQuery();
                while (rs2.next()) {
                     BrechaHoraria b = new BrechaHoraria();
                     b.setHoraInicio(rs2.getDate("HoraInicio"));
                     b.setHoraFin(rs2.getDate("HoraFin"));
                     sol.setBrechaHoraria(b);
                }
            }           
            cnn.commit();
        } catch (Exception ex) {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } finally {
            cnn.close();
        }
     return sol;  
 }
    
    @Override
    public Solicitud BuscarSolicitudXCli(String ciCli) throws SQLException {
        Connection cnn = null;
        Solicitud sol = null;
    
        try {
            cnn = Conexion.ConectarMysql("localhost", 3306, "root", "", "lavadero_01");
            cnn.setAutoCommit(false);
            delivery = false; 
            CallableStatement cs = cnn.prepareCall("{ call BuscarSolicitudXCli(?) }");
            cs.setString("CiCli", ciCli);
            cs.execute();
            ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    sol = new Solicitud();
                    Cliente c = new  Cliente();
                    Empleado e = new Empleado();
                    SolicitudDetalle sd = new SolicitudDetalle();
                    int Id = rs.getInt("Id");
                    sol.setId(Id);
                    c.setCedula(rs.getString("CedulaCli"));
                    e.setCedula(rs.getString("CedulaEmp"));
                    delivery = rs.getBoolean("ConDelivery");
                    sol.setDelivery(delivery);
                    sol.setEstado(EstadosSolicitud.valueOf(rs.getString("Estado")));
                    sol.setFechaEntrega(rs.getDate("FechaEntrega"));
                    sol.setFechaIngreso(rs.getDate("FechaIngreso"));
                    sol.setObservaciones(rs.getString("Observaciones"));
                    sol.setCedulaCli(c);
                    sol.setEmpleado(e);
                    sol.setOpcionesList(PersistenciaOpciones.getInstancia().ListarOpcionesXSol(Id));
                    sol.setPrendas(PersistenciaPrendas.getInstancia().ListarPrendasXSol(Id));
                }
            if(delivery == true)
            {
                CallableStatement cs2 = cnn.prepareCall("{ call listarBrechasXSol(?) }");
                cs2.setInt("idSol", sol.getId());
                cs2.execute();
                ResultSet rs2 = cs2.executeQuery();
                while (rs2.next()) {
                     BrechaHoraria b = new BrechaHoraria();
                     b.setHoraInicio(rs2.getDate("HoraInicio"));
                     b.setHoraFin(rs2.getDate("HoraFin"));
                     sol.setBrechaHoraria(b);
                }
            } 
            cnn.commit();
        } catch (Exception ex) {
            System.out.println(ex.toString() + " - " + ex.getMessage());
            cnn.rollback();
        } finally {
            cnn.close();
        }
     return sol;  
 }
}

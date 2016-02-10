package Persistencia.Clases;

import Entidades.Constantes;
import Entidades.Exceptions.ConexionException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class Conexion {

    private static Connection con_mysql;

    public static Connection ConectarMysql(String pHost,
            int pPuerto,
            String pUsuario,
            String pPass,
            String pNombreBd)
            throws Exception {
        try {
            String databaseURL
                    = "jdbc:mysql://" + pHost
                    + ":" + pPuerto
                    + "/" + pNombreBd;
            Class.forName("com.mysql.jdbc.Driver");
            con_mysql = java.sql.DriverManager.getConnection(databaseURL,
                    pUsuario,
                    "Lavadero1111Facil");
            //System.out.println("Conexion con MySQL Establecida..");
            
            return con_mysql;
        } catch (Exception e) {
//            if (e instanceof MySQLNonTransientConnectionException
//                    || e instanceof CommunicationsException) {
//                throw new ConexionException(Constantes.sql_error_unreachable_connection, e);
//            } else {
//                throw new ConexionException(e.getMessage(), e);
//            }
            throw new ConexionException(Constantes.compartido_ErrorConexion, e);
        }
    }
}

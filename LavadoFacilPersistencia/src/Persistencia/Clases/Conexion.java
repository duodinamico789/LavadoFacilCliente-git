package Persistencia.Clases;

import Entidades.Constantes;
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
            String databaseURL = 
                    "jdbc:mysql://" + pHost 
                    + ":" + pPuerto 
                    + "/" + pNombreBd;
            Class.forName("com.mysql.jdbc.Driver");
            con_mysql = java.sql.DriverManager.getConnection(databaseURL, 
                                                             pUsuario, 
                                                             pPass);
            //System.out.println("Conexion con MySQL Establecida..");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof MySQLNonTransientConnectionException
                    || e instanceof CommunicationsException) {
                throw new Exception(Constantes.sql_error_unreachable_connection);
            } else {
                throw new Exception(e);
            }
        }
        return con_mysql;
    }

    public static void ImprimirSQLException(SQLException sqlex) {
        System.out.println(sqlex.getMessage());
    }
}

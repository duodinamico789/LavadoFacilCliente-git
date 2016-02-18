package Persistencia.Clases;

import Entidades.Constantes;
import Entidades.Exceptions.ConexionException;
import java.sql.Connection;
import java.sql.SQLException;

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
            throw new ConexionException(Constantes.compartido_ErrorConexion, e);
        }
    }
}

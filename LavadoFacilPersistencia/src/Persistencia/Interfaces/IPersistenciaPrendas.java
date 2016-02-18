package Persistencia.Interfaces;

import Entidades.Datatypes.PrendaExtended;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaPrendas {
    void AltaPrendaEnvio(PrendaEnvio pre) throws SQLException;
    void ModificarPrendaEnvio(PrendaEnvio pre) throws SQLException;
    void BajaPrendaEnvio(int id) throws SQLException;
    void AltaPrenda(Prenda p)throws SQLException;
    void ModificarPrenda(Prenda p)throws SQLException;
    void BajaPrenda(int idPda) throws SQLException;
    Prenda BuscarPrenda(String pda)throws SQLException;
    LinkedList<Prenda> ListarPrendas(boolean aplicaTint) throws SQLException;
    LinkedList<PrendaEnvio> ListarPrendasEnvio() throws SQLException;
    LinkedList<PrendaExtended> ListarPrendasXSol(int idSol) throws SQLException;
    LinkedList<PrendaEnvio> ListarPrendasEnvioXIdPren(int idPren) throws SQLException;
}

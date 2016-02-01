package Logica.Interface;

import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import java.util.LinkedList;

public interface ILogicaPrendas {
    
     void AltaPrendasEnvio(PrendaEnvio p)throws Exception;
     void ModificarPrendasEnvio(PrendaEnvio p) throws Exception;
     void BajaPrendasEnvio(int id) throws Exception;
     void AltaPrendas(Prenda p)throws Exception;
     Prenda BuscarPrendas(String pda) throws Exception;
     void ModificarPrendas(Prenda p) throws Exception;
     void BajaPrendas(int idPda) throws Exception;
     LinkedList<Prenda> ListarPrendas(boolean aplicaTint) throws Exception;
     LinkedList<Prenda> ListarPrendas() throws Exception;
     LinkedList<PrendaEnvio> ListarPrendasEnvio()throws Exception;
     LinkedList<Prenda> ListarPrendasXSol(int idSol) throws Exception;
     LinkedList<PrendaEnvio> ListarPrendasEnvioXIdPren(int idPren) throws Exception ;
}

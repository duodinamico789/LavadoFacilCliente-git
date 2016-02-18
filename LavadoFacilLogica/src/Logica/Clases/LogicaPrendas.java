package Logica.Clases;

import Entidades.Datatypes.PrendaExtended;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import java.util.LinkedList;

public class LogicaPrendas implements Logica.Interface.ILogicaPrendas {

    private static LogicaPrendas _instancia = null;

    private LogicaPrendas() {
    }

    public static LogicaPrendas getInstancia() {
        if (_instancia == null) {
            _instancia = new LogicaPrendas();
        }
        return _instancia;
    }

    @Override
    public void AltaPrendasEnvio(PrendaEnvio p) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.AltaPrendaEnvio(p);
    }

    @Override
    public void ModificarPrendasEnvio(PrendaEnvio p) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.ModificarPrendaEnvio(p);
    }

    @Override
    public void BajaPrendasEnvio(int id) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.BajaPrendaEnvio(id);
    }

    @Override
    public void AltaPrendas(Prenda p) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.AltaPrenda(p);
    }

    @Override
    public Prenda BuscarPrendas(String pda) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas p = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        Prenda pe = p.BuscarPrenda(pda);
        return pe;
    }

    @Override
    public void ModificarPrendas(Prenda p) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.ModificarPrenda(p);
    }

    @Override
    public void BajaPrendas(int idPda) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        pre.BajaPrenda(idPda);
    }

    @Override
    public LinkedList<Prenda> ListarPrendas(boolean aplicaTint) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        return pre.ListarPrendas(aplicaTint);
    }
        
    @Override
    public LinkedList<Prenda> ListarPrendas() throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        LinkedList<Prenda> prendas = pre.ListarPrendas(true);
        prendas.addAll(pre.ListarPrendas(false));
        return prendas;
    }

    @Override
    public LinkedList<PrendaEnvio> ListarPrendasEnvio() throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        return pre.ListarPrendasEnvio();
    }
    
    @Override
    public LinkedList<PrendaExtended> ListarPrendasXSol(int idSol) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        return pre.ListarPrendasXSol(idSol);
    }
    
    @Override
    public LinkedList<PrendaEnvio> ListarPrendasEnvioXIdPren(int idPren) throws Exception {
        Persistencia.Interfaces.IPersistenciaPrendas pre = Persistencia.Clases.FabricaPersistencia.getInstancia().getIPersistenciaPrenda();
        return pre.ListarPrendasEnvioXIdPren(idPren);
    }
}

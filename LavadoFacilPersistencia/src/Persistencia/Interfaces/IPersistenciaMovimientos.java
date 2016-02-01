package Persistencia.Interfaces;

import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Movimiento;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IPersistenciaMovimientos {

    int AltaMovimiento(Movimiento mov) throws SQLException;

    int ModificarMovimiento(Movimiento mov) throws SQLException;

    int BajaMovimiento(int idMov) throws SQLException;

    LinkedList<Movimiento> ListarMovimientosPorSucursal(TipoMov tipoMovs, int idSuc) throws SQLException;

    Movimiento BuscarMovimiento(int idMov) throws SQLException;
}

package Logica.Interface;

import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Movimiento;
import java.sql.SQLException;
import java.util.LinkedList;

public interface ILogicaMovimientos {

    int AltaMovimiento(Movimiento mov) throws Exception;

    int ModificarMovimiento(Movimiento mov) throws Exception;

    int BajaMovimiento(int idMov) throws Exception;

    LinkedList<Movimiento> ListarMovimientosPorSucursal(TipoMov tipoMovs, int idSuc) throws Exception;

    Movimiento BuscarMovimiento(int idMov) throws Exception;

//    Movimiento ConsultarContabAuto(boolean incluirGastosIngresos, Empleado empLogueado) throws Exception;
//    HSSFWorkbook GenerarExcelDocumentOldFormat(Movimiento contab) throws IOException;
//    ByteArrayOutputStream GenerarPdfDocumentFormat(Movimiento contab) throws GenerationException;
//    LinkedList<Movimiento> ListarUltimasDoceContabs() throws SQLException;
}

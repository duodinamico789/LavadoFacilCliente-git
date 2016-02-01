package Presentacion.Interfaces;

import Entidades.Objetos.Movimiento;

public interface ParentFrameMethodListener {
    void MostrarLoading(boolean mostrar);
    void SetMensajeError(String mensaje);
    void ModoDefault(boolean ejecutarModoDefaultListado) throws Exception;
    void ModoModificar(Object objeto);
    void Eliminar(int idMov) throws Exception;
}

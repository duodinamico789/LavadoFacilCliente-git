package Presentacion.Utils;

import Presentacion.Frames.ErrorInesperado;

public class ClienteUtils {
    public static void IniciarFrameError(String mensajeError) {
        ErrorInesperado frame = new ErrorInesperado();
        frame.CorrerVentana(mensajeError);
    }
}

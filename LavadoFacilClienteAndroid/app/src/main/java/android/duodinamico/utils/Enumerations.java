package android.duodinamico.utils;

import java.util.HashMap;
import java.util.Map;

public class Enumerations {

    public enum Paginas {
        COMO_USAR_LA_APP(0), ALTA_SOLICITUD_1(1), MODIFICAR_CLIENTE(2), CERRAR_SESION(3), ALTA_SOLICITUD_2(5);
        private int value;
        private static Map<Integer, Paginas> map = new HashMap<>();
        static {
            for (Paginas _enum : Paginas.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private Paginas(final int value) { this.value = value; }
        public static Paginas valueOf(int value) {
            return map.get(value);
        }
        public static Paginas valueOfStr(String value) {
            return valueOf(value);
        }
        public int getValue() { return value; }
    }

}

package android.duodinamico.servicios.Impl;

import java.util.HashMap;
import java.util.Map;

public class Enumeraciones {
    public enum TipoPersona {
        Cliente(1), Empleado(2);
        private int value;
        private static Map<Integer, TipoPersona> map = new HashMap<>();
        static {
            for (TipoPersona _enum : TipoPersona.values()) {
                map.put(_enum.value, _enum);
            }
        }
        private TipoPersona(final int value) { this.value = value; }
        public static TipoPersona valueOf(int value) {
            return map.get(value);
        }
        public static TipoPersona valueOfStr(String value) {
            return valueOf(value);
        }
        public int getValue() { return value; }
    }
}
